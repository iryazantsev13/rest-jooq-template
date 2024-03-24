package games.classifier.managertdd.infrastructure.adapters.output.repository.mapper

import games.classifier.manager.infrastructure.adapters.db.Tables
import games.classifier.managertdd.domain.model.GameData
import org.jooq.Record4

interface GameRecordMapper {
    companion object {
        fun Record4<Int, String, Long, Boolean>.toGameItem(): GameData {
            val gameId = this[Tables.T_GAME.GAME_ID]!!
            val name = this[Tables.T_GAME.NAME]
            val price = this[Tables.T_GAME.PRICE_DEFAULT]!!
            val isLocked = this[Tables.T_GAME.DELETED]!!
            return GameData(gameId, name, price, isLocked)
        }
    }
}