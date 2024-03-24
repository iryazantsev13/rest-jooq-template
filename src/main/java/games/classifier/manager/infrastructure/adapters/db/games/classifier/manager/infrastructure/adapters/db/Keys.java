/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db;


import games.classifier.manager.infrastructure.adapters.db.tables.Databasechangeloglock;
import games.classifier.manager.infrastructure.adapters.db.tables.Game;
import games.classifier.manager.infrastructure.adapters.db.tables.Games;
import games.classifier.manager.infrastructure.adapters.db.tables.TGame;
import games.classifier.manager.infrastructure.adapters.db.tables.Tickets;
import games.classifier.manager.infrastructure.adapters.db.tables.records.DatabasechangeloglockRecord;
import games.classifier.manager.infrastructure.adapters.db.tables.records.GameRecord;
import games.classifier.manager.infrastructure.adapters.db.tables.records.GamesRecord;
import games.classifier.manager.infrastructure.adapters.db.tables.records.TGameRecord;
import games.classifier.manager.infrastructure.adapters.db.tables.records.TicketsRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DatabasechangeloglockRecord> DATABASECHANGELOGLOCK_PKEY = Internal.createUniqueKey(Databasechangeloglock.DATABASECHANGELOGLOCK, DSL.name("databasechangeloglock_pkey"), new TableField[] { Databasechangeloglock.DATABASECHANGELOGLOCK.ID }, true);
    public static final UniqueKey<GameRecord> GAME_PKEY = Internal.createUniqueKey(Game.GAME, DSL.name("game_pkey"), new TableField[] { Game.GAME.ID }, true);
    public static final UniqueKey<GamesRecord> GAMES_PKEY = Internal.createUniqueKey(Games.GAMES, DSL.name("games_pkey"), new TableField[] { Games.GAMES.ID }, true);
    public static final UniqueKey<TGameRecord> T_GAME_PKEY = Internal.createUniqueKey(TGame.T_GAME, DSL.name("t_game_pkey"), new TableField[] { TGame.T_GAME.ID }, true);
    public static final UniqueKey<TicketsRecord> TICKETS_PKEY = Internal.createUniqueKey(Tickets.TICKETS, DSL.name("tickets_pkey"), new TableField[] { Tickets.TICKETS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TicketsRecord, GamesRecord> TICKETS__FK_GAME_ID = Internal.createForeignKey(Tickets.TICKETS, DSL.name("fk_game_id"), new TableField[] { Tickets.TICKETS.GAME_ID }, Keys.GAMES_PKEY, new TableField[] { Games.GAMES.ID }, true);
}