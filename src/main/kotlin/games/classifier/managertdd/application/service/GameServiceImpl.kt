package games.classifier.managertdd.application.service

import games.classifier.managertdd.application.port.input.GameService
import games.classifier.managertdd.application.port.output.GameRepository
import games.classifier.managertdd.domain.exception.GameAlreadyExistsException
import games.classifier.managertdd.domain.exception.GameNotFoundException
import games.classifier.managertdd.domain.model.GameData

class GameServiceImpl(
    private val gameRepository: GameRepository
) : GameService {
    override fun getAll(pageIndex: Int, pageSize: Int): Pair<Int, List<GameData>> {
        return gameRepository.getAll(pageIndex, pageSize)
    }

    override fun getById(gameId: Int): GameData {
        return gameRepository.findById(gameId)
            ?: throw GameNotFoundException(gameId)
    }

    override fun create(gameData: GameData) {
        try {
            gameRepository.create(gameData)
        } catch (e: org.jooq.exception.IntegrityConstraintViolationException) {
            throw GameAlreadyExistsException(gameData.gameCode)
        }
    }

    override fun update(gameId: Int, gameData: GameData) {
        if (gameRepository.update(
                gameId,
                gameData.generalName,
                gameData.price,
                gameData.isDeleted
            ) == 0
        ) {
            throw GameNotFoundException(gameId)
        }
    }

    override fun deleteById(gameId: Int) {
        if (gameRepository.delete(gameId) == 0) {
            throw GameNotFoundException(gameId)
        }
    }
}