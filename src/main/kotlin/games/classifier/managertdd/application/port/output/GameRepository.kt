package games.classifier.managertdd.application.port.output

import games.classifier.managertdd.domain.model.GameData

interface GameRepository {

    fun getAll(pageIndex: Int, pageSize: Int): Pair<Int, List<GameData>>

    fun findById(gameId: Int): GameData?

    fun create(gameData: GameData): Int

    fun update(gameId: Int, generalName: String?, price: Long, isDeleted: Boolean): Int

    fun delete(gameId: Int): Int
}