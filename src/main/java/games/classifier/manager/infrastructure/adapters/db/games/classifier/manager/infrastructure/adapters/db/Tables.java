/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db;


import games.classifier.manager.infrastructure.adapters.db.tables.Databasechangelog;
import games.classifier.manager.infrastructure.adapters.db.tables.Databasechangeloglock;
import games.classifier.manager.infrastructure.adapters.db.tables.Game;
import games.classifier.manager.infrastructure.adapters.db.tables.Games;
import games.classifier.manager.infrastructure.adapters.db.tables.TGame;
import games.classifier.manager.infrastructure.adapters.db.tables.Tickets;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Tables {

    /**
     * The table <code>public.databasechangelog</code>.
     */
    public static final Databasechangelog DATABASECHANGELOG = Databasechangelog.DATABASECHANGELOG;

    /**
     * The table <code>public.databasechangeloglock</code>.
     */
    public static final Databasechangeloglock DATABASECHANGELOGLOCK = Databasechangeloglock.DATABASECHANGELOGLOCK;

    /**
     * The table <code>public.game</code>.
     */
    public static final Game GAME = Game.GAME;

    /**
     * The table <code>public.games</code>.
     */
    public static final Games GAMES = Games.GAMES;

    /**
     * The table <code>public.t_game</code>.
     */
    public static final TGame T_GAME = TGame.T_GAME;

    /**
     * The table <code>public.tickets</code>.
     */
    public static final Tickets TICKETS = Tickets.TICKETS;
}
