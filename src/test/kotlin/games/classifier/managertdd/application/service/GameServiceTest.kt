package games.classifier.managertdd.application.service

import games.classifier.managertdd.application.port.output.GameRepository
import games.classifier.managertdd.domain.exception.GameAlreadyExistsException
import games.classifier.managertdd.domain.exception.GameNotFoundException
import games.classifier.managertdd.domain.model.GameData
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameServiceTest {

    lateinit var gameServiceTest: GameServiceImpl
    lateinit var mockGameRepository: GameRepository

    @BeforeEach
    fun init() {
        mockGameRepository = mockk()
        gameServiceTest = GameServiceImpl(mockGameRepository)
    }

    @Test
    fun `call repository to find all Games`() {
        val returnGameData = GameData(
            gameCode = 6103,
            generalName = "Русское лото",
            price = 10000,
            isDeleted = true,
        )

        every { mockGameRepository.getAll(0, 100) } returns Pair(1, listOf(returnGameData))

        val gamesPaged = gameServiceTest.getAll(0, 100)
        Assertions.assertEquals(returnGameData, gamesPaged.second[0])
    }

    @Test
    fun `call repository for trying to find non-existing game`() {
        every { mockGameRepository.findById(6103) } returns null

        assertThrows<GameNotFoundException> {
            gameServiceTest.getById(6103)
        }
    }

    @Test
    fun `call repository for trying create game second time`() {
        val gameDataInp = GameData(
            gameCode = 6103,
            generalName = "Русское лото",
            price = 10000,
        )
        every { mockGameRepository.create(gameDataInp) }.answers {
            throw org.jooq.exception.IntegrityConstraintViolationException("")
        }
        assertThrows<GameAlreadyExistsException> {
            gameServiceTest.create(gameDataInp)
        }
    }

    @Test
    fun `call repository for trying to update non-existing game`() {
        val gameDataInp = GameData(
            gameCode = 0,
            generalName = null,
            price = 10000,
            isDeleted = false
        )
        every {
            mockGameRepository.update(
                6103,
                gameDataInp.generalName,
                gameDataInp.price,
                gameDataInp.isDeleted,
            )
        } returns 0

        assertThrows<GameNotFoundException> {
            gameServiceTest.update(6103, gameDataInp)
        }
    }

    @Test
    fun `call repository for trying to delete non-existing game`() {
        every { mockGameRepository.delete(6103) } returns 0

        assertThrows<GameNotFoundException> {
            gameServiceTest.deleteById(6103)
        }
    }
}