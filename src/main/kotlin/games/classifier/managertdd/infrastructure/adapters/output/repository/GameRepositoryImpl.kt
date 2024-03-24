package games.classifier.managertdd.infrastructure.adapters.output.repository

import games.classifier.manager.infrastructure.adapters.db.Tables.T_GAME
import games.classifier.managertdd.application.port.output.GameRepository
import games.classifier.managertdd.domain.model.GameData
import games.classifier.managertdd.infrastructure.adapters.output.repository.mapper.GameRecordMapper.Companion.toGameItem
import org.jooq.DSLContext
import java.time.LocalDate
import java.time.LocalDateTime

class GameRepositoryImpl(
    private val dsl: DSLContext
) : GameRepository {

    override fun getAll(pageIndex: Int, pageSize: Int): Pair<Int, List<GameData>> =
        Pair(
            totalCountGames(),
            loadGamesWithPagination(pageIndex, pageSize)
        )

    override fun findById(gameId: Int): GameData? =
        dsl.select(T_GAME.GAME_ID, T_GAME.NAME, T_GAME.PRICE_DEFAULT, T_GAME.DELETED)
            .from(T_GAME)
            .where(T_GAME.GAME_ID.eq(gameId))
            .fetchOne()
            ?.toGameItem()

    override fun create(gameData: GameData): Int =
        dsl.insertInto(T_GAME)
            .columns(T_GAME.GAME_ID, T_GAME.NAME, T_GAME.PRICE_DEFAULT, T_GAME.UPDATED_AT)
            .values(gameData.gameCode, gameData.generalName, gameData.price, LocalDateTime.now())
            .execute()

    override fun update(gameId: Int, generalName: String?, price: Long, isDeleted: Boolean): Int =
        dsl.update(T_GAME)
            .set(T_GAME.NAME, generalName)
            .set(T_GAME.UPDATED_AT, LocalDateTime.now())
            .set(T_GAME.PRICE_DEFAULT, price)
            .set(T_GAME.DELETED, isDeleted)
            .where(T_GAME.GAME_ID.eq(gameId))
            .execute()

    override fun delete(gameId: Int): Int =
        dsl.deleteFrom(T_GAME).where(T_GAME.GAME_ID.eq(gameId)).execute()

    // ------------------------------------------------------------------------
    private fun totalCountGames(): Int {
        return dsl.fetchCount(dsl.selectFrom(T_GAME))
    }

    private fun loadGamesWithPagination(pageIndex: Int, pageSize: Int): List<GameData> {
        return dsl.select(T_GAME.GAME_ID, T_GAME.NAME, T_GAME.PRICE_DEFAULT, T_GAME.DELETED)
            .from(T_GAME)
            .orderBy(T_GAME.ID)
            .limit(pageSize)
            .offset(pageIndex * pageSize)
            .fetch()
            .map { record ->
                record.toGameItem()
            }
    }
}