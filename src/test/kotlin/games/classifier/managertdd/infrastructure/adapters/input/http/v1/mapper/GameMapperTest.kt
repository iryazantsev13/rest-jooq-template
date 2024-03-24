package games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper

import games.classifier.managertdd.domain.exception.ValidationErrorCode
import games.classifier.managertdd.domain.exception.ValidationException
import games.classifier.managertdd.domain.model.GameData
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.dto.GameParamsDto
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper.GameMapper.Companion.toGameData
import games.classifier.managertdd.infrastructure.adapters.input.http.v1.mapper.GameMapper.Companion.toGameDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GameMapperTest {

    companion object {
        @JvmStatic
        fun gameDtoInputs(): Stream<Arguments> = Stream.of(
            Arguments.of(6103, "Русское лото", 10000, false),
            Arguments.of(6103, null, 10000, true),
        )
    }

    @ParameterizedTest
    @MethodSource("gameDtoInputs")
    fun `should convert GameDto into GameData and back`(gameId: Int, name: String?, price: Long, isDelete: Boolean) {
        val dto = GameDto(gameId, name, price, isDelete)
        val game = GameData(gameId, name, price, isDelete)

        assertEquals(game, toGameData(dto))
        assertEquals(dto, toGameDto(game))
    }

    @Test
    fun `should convert GameParamsDto into GameData`() {
        val dto = GameParamsDto("something", 1000, false)
        val game = GameData(0, "something", 1000)

        assertEquals(game, toGameData(dto))
    }

    @Test
    fun `should throw exception if gameCode too short`() {
        val dto = GameDto(10, null, 100)

        val exception = assertThrows<ValidationException>{
            toGameData(dto)
        }
        assertEquals("GAME_CODE_TOO_SHORT", exception.errorCode)
    }

    @Test
    fun `should throw exception if gameCode too long`() {
        val dto = GameDto(100000, null, 100)

        val exception = assertThrows<ValidationException>{
            toGameData(dto)
        }
        assertEquals("GAME_CODE_TOO_LONG", exception.errorCode)
    }
}