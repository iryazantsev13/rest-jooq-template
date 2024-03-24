/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db;


import games.classifier.manager.infrastructure.adapters.db.tables.Game;
import games.classifier.manager.infrastructure.adapters.db.tables.TGame;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index GAMEUK = Internal.createIndex(DSL.name("gameUK"), Game.GAME, new OrderField[] { Game.GAME.GAME_ID }, true);
    public static final Index UKGAMEID = Internal.createIndex(DSL.name("ukGameId"), TGame.T_GAME, new OrderField[] { TGame.T_GAME.GAME_ID }, true);
}