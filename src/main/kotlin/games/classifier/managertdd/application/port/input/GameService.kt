package games.classifier.managertdd.application.port.input

import games.classifier.managertdd.domain.model.GameData

interface GameService {

    fun getAll(pageIndex: Int, pageSize: Int): Pair<Int, List<GameData>>

    fun getById(gameId: Int): GameData

    fun create(gameData: GameData)

    fun update(gameId: Int, gameData: GameData)

    fun deleteById(gameId: Int)
}