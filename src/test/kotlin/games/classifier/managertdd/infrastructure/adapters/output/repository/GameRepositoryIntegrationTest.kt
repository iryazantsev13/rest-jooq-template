package games.classifier.managertdd.infrastructure.adapters.output.repository

import games.classifier.managertdd.AbstractIntegrationTest
import games.classifier.managertdd.application.port.output.GameRepository
import games.classifier.managertdd.domain.model.GameData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired

class GameRepositoryIntegrationTest : AbstractIntegrationTest() {

    @Autowired
    lateinit var gameRepository: GameRepository

    val gameDataInp = GameData(
        gameCode = 6103,
        generalName = "Русское лото",
        price = 10000,
    )

    val gamesData = listOf<GameData>(
        GameData(20514, "Узоры на льду", 5000),
        GameData(6103, "Русское лото", 15000),
        GameData(6105, "Жилищная лотерея", 10000),
        GameData(19105, "Сапер", 2000),
        GameData(19101, "Наперстки", 1000),
    )

    @Test
    fun `save task into database`() {
        val rows = gameRepository.create(gameDataInp)
        assertEquals(1, rows)
    }

    @Test
    fun `should return exception IntegrityConstraintViolationException if creating it twice`() {
        assertThrows<org.jooq.exception.IntegrityConstraintViolationException> {
            gameRepository.create(gameDataInp)
            gameRepository.create(gameDataInp)
        }
    }

    @Test
    fun `get empty games list`() {
        val pagedData = gameRepository.getAll(0, 100)
        assertEquals(0, pagedData.first)
        assertEquals(0, pagedData.second.size)
    }

    @Test
    fun `get some games without pagination`() {
        gamesData.forEach { game ->
            gameRepository.create(game)
        }

        val pagedData = gameRepository.getAll(0, 100)
        assertEquals(gamesData.size, pagedData.first)
        assertEquals(gamesData, pagedData.second)
    }

    @Test
    fun `get couple of games with pagination`() {
        gamesData.forEach { game ->
            gameRepository.create(game)
        }

        val pagedData: Pair<Int, List<GameData>> = gameRepository.getAll(0, 2)
        assertEquals(gamesData.size, pagedData.first) // total count games
        assertEquals(2, pagedData.second.size)
        for (i in 0..1) {
            assertEquals(gamesData[i], pagedData.second[i])
        }
    }

    @Test
    fun `get couple of games with pagination on the second page`() {
        gamesData.forEach { game ->
            gameRepository.create(game)
        }

        val pagedData = gameRepository.getAll(1, 2)
        assertEquals(gamesData.size, pagedData.first) // total count games
        assertEquals(2, pagedData.second.size)
        assertEquals(gamesData[2], pagedData.second[0])
        assertEquals(gamesData[3], pagedData.second[1])
    }

    @Test
    fun `find game by GameCode`() {
        gameRepository.create(gameDataInp)

        val gameOut = gameRepository.findById(gameDataInp.gameCode)
        assertEquals(gameDataInp, gameOut)
    }

    @Test
    fun `trying to find a non-existing game`() {
        assertNull(gameRepository.findById(gameDataInp.gameCode))
    }

    @Test
    fun `test simple update`() {
        val gameDataExpected = GameData(
            gameCode = 6103,
            generalName = "Русское лото",
            price = 10000,
            isDeleted = true,
        )

        gameRepository.create(gameDataInp)

        gameRepository.update(
            gameDataExpected.gameCode,
            gameDataExpected.generalName,
            gameDataExpected.price,
            gameDataExpected.isDeleted
        )
        val gameOut = gameRepository.findById(gameDataInp.gameCode)
        assertEquals(gameDataExpected, gameOut)
    }

    @Test
    fun `test update with name as null`() {
        val gameDataExpected = GameData(
            gameCode = 6103,
            generalName = null,
            price = 10000,
            isDeleted = false,
        )

        gameRepository.create(gameDataInp)

        gameRepository.update(
            gameDataExpected.gameCode,
            gameDataExpected.generalName,
            gameDataExpected.price,
            gameDataExpected.isDeleted
        )
        val gameOut = gameRepository.findById(gameDataInp.gameCode)
        assertEquals(gameDataExpected, gameOut)
    }

    @Test
    fun `trying to update non-existing game`() {
        val countOfUpdatedRecords = gameRepository.update(
            gameDataInp.gameCode,
            gameDataInp.generalName,
            gameDataInp.price,
            true,
        )

        assertEquals(0, countOfUpdatedRecords)
    }

    @Test
    fun `test delete game`() {
        gameRepository.create(gameDataInp)
        val countOfDeletedRecords = gameRepository.delete(gameDataInp.gameCode)
        assertEquals(1, countOfDeletedRecords)
        assertNull(gameRepository.findById(gameDataInp.gameCode))
    }

    @Test
    fun `Trying to delete non-existing game`() {
        val countOfDeletedRecords = gameRepository.delete(gameDataInp.gameCode)
        assertEquals(0, countOfDeletedRecords)
    }
}