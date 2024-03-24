package games.classifier.managertdd.infrastructure.adapters.input.http.v1

import games.classifier.managertdd.AbstractIntegrationTest
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameListDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.error.ApiError
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.*

class GameApiControllerIntegrationTest : AbstractIntegrationTest() {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    lateinit var port: Number

    @Test
    fun `should return 404 for request get if the game does not exist`() {
        val response = restTemplate.getForEntity(
            "http://localhost:$port/api/v1/game/{gameId}",
            ApiError::class.java,
            1001
        )
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_NOT_FOUND", response.body!!.errorCode)
    }

    @Test
    fun `should return 404 for request update if the game does not exist`() {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val entity = HttpEntity<String>(
            "{ \"generalName\": \"some game\", \"price\": 10000, \"isDelete\": false }",
            headers,
        )

        val response = restTemplate.exchange(
            "http://localhost:$port/api/v1/game/{gameId}",
            HttpMethod.PUT,
            entity,
            ApiError::class.java,
            1001,
        )
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_NOT_FOUND", response.body!!.errorCode)
    }

    @Test
    fun `should return 404 for request delete if the game does not exist`() {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val entity = HttpEntity<String>(null, headers)

        val response = restTemplate.exchange(
            "http://localhost:$port/api/v1/game/{gameId}",
            HttpMethod.DELETE,
            entity,
            ApiError::class.java,
            1001
        )
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_NOT_FOUND", response.body!!.errorCode)
    }

    @Test
    fun `should return 400 if the gameCode is too short`() {
        val gameInput = GameDto(gameCode = 3, generalName = null, price = 10000)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val response =
            restTemplate.postForEntity(
                "http://localhost:$port/api/v1/game",
                gameInput,
                ApiError::class.java
            )

        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_CODE_TOO_SHORT", response.body!!.errorCode)
    }

    @Test
    fun `should return 409 if game creating second time`() {
        val gameInput = GameDto(gameCode = 6104, generalName = null, price = 10000)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        // first time
        restTemplate.postForEntity(
            "http://localhost:$port/api/v1/game",
            gameInput,
            String::class.java
        )

        // second time
        val response =
            restTemplate.postForEntity(
                "http://localhost:$port/api/v1/game",
                gameInput,
                ApiError::class.java
            )

        assertEquals(HttpStatus.CONFLICT, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_ALREADY_EXISTS", response.body!!.errorCode)
    }

    @Test
    fun `should store game success on post endpoint`() {
        val gameInput = GameDto(gameCode = 6104, generalName = null, price = 10000)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val response =
            restTemplate.postForEntity(
                "http://localhost:$port/api/v1/game",
                gameInput,
                String::class.java
            )

        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `should update game success on put endpoint`() {
        val gameInput = GameDto(
            gameCode = 6104,
            generalName = null,
            price = 10000
        )

        val gameOutput = GameDto(
            gameCode = 6104,
            generalName = "some game",
            price = 10000,
            isDelete = false
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        // Store game
        restTemplate.postForEntity(
            "http://localhost:$port/api/v1/game",
            gameInput,
            String::class.java
        )

        // Update game
        val entity = HttpEntity<String>(
            "{ \"generalName\": \"some game\", \"price\": 10000, \"isDelete\": false }",
            headers,
        )

        val resultUpdate = restTemplate.exchange(
            "http://localhost:$port/api/v1/game/{gameId}",
            HttpMethod.PUT,
            entity,
            String::class.java,
            6104,
        )
        assertEquals(HttpStatus.OK, resultUpdate.statusCode)

        // Check updating game
        val response =
            restTemplate.getForEntity(
                "http://localhost:$port/api/v1/game/{gameId}",
                GameDto::class.java,
                6104
            )
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(gameOutput, response.body)
    }

    @Test
    fun `should drop game success on delete endpoint`() {
        val gameInput = GameDto(
            gameCode = 6104,
            generalName = null,
            price = 10000
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        // Store game
        restTemplate.postForEntity(
            "http://localhost:$port/api/v1/game",
            gameInput,
            String::class.java
        )

        // Delete game
        val entity = HttpEntity<String>(null, headers)

        val resultDelete = restTemplate.exchange(
            "http://localhost:$port/api/v1/game/{gameId}",
            HttpMethod.DELETE,
            entity,
            ApiError::class.java,
            6104,
        )
        assertEquals(HttpStatus.OK, resultDelete.statusCode)

        // trying to find game
        val response =
            restTemplate.getForEntity(
                "http://localhost:$port/api/v1/game/{gameId}",
                ApiError::class.java,
                6104
            )
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNotNull(response.body)
        assertEquals("GAME_NOT_FOUND", response.body!!.errorCode)
    }

    @Test
    fun `should get game by gameCode`() {
        val gameInput = GameDto(gameCode = 6104, generalName = null, price = 10000)

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        restTemplate.postForEntity(
            "http://localhost:$port/api/v1/game",
            gameInput,
            String::class.java
        )

        val response =
            restTemplate.getForEntity(
                "http://localhost:$port/api/v1/game/{gameId}",
                GameDto::class.java,
                6104
                //gameInput.gameCode
            )
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(gameInput, response.body)
    }

    @Test
    fun `should get all games`() {
        val gamesInput = listOf(
            GameDto(gameCode = 6103, generalName = "Русское лото", price = 10000),
            GameDto(gameCode = 6104, generalName = null, price = 10000),
            GameDto(gameCode = 6105, generalName = "Другое лото", price = 10000),
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        gamesInput.forEach {
            restTemplate.postForEntity(
                "http://localhost:$port/api/v1/game",
                it,
                String::class.java
            )
        }

        val response =
            restTemplate.getForEntity("http://localhost:$port/api/v1/game", GameListDto::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals(3, response.body!!.totalCount)
        assertEquals(3, response.body!!.games.size)
        assertEquals(gamesInput, response.body!!.games)
    }

    @Test
    fun `should get games with pagination`() {
        val gamesInput = listOf(
            GameDto(gameCode = 6103, generalName = "Русское лото", price = 10000),
            GameDto(gameCode = 6104, generalName = null, price = 10000),
            GameDto(gameCode = 6105, generalName = "Другое лото", price = 10000),
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        gamesInput.forEach {
            restTemplate.postForEntity("http://localhost:$port/api/v1/game", it, String::class.java)
        }

        val response =
            restTemplate.getForEntity("http://localhost:$port/api/v1/game?page=2&size=1", GameListDto::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals(3, response.body!!.totalCount)
        assertEquals(1, response.body!!.games.size)
        assertEquals(gamesInput[2], response.body!!.games[0])
    }
}