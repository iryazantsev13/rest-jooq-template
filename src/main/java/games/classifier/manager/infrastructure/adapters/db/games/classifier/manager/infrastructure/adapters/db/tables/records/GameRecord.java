/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db.tables.records;


import games.classifier.manager.infrastructure.adapters.db.tables.Game;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class GameRecord extends UpdatableRecordImpl<GameRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.game.id</code>.
     */
    public GameRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.game.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.game.game_id</code>.
     */
    public GameRecord setGameId(Short value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.game.game_id</code>.
     */
    public Short getGameId() {
        return (Short) get(1);
    }

    /**
     * Setter for <code>public.game.name</code>.
     */
    public GameRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.game.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.game.legal_name</code>.
     */
    public GameRecord setLegalName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.game.legal_name</code>.
     */
    public String getLegalName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.game.price_default</code>.
     */
    public GameRecord setPriceDefault(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.game.price_default</code>.
     */
    public Long getPriceDefault() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.game.count_mls</code>.
     */
    public GameRecord setCountMls(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.game.count_mls</code>.
     */
    public Integer getCountMls() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GameRecord
     */
    public GameRecord() {
        super(Game.GAME);
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(Long id, Short gameId, String name, String legalName, Long priceDefault, Integer countMls) {
        super(Game.GAME);

        setId(id);
        setGameId(gameId);
        setName(name);
        setLegalName(legalName);
        setPriceDefault(priceDefault);
        setCountMls(countMls);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised GameRecord
     */
    public GameRecord(games.classifier.manager.infrastructure.adapters.db.tables.pojos.Game value) {
        super(Game.GAME);

        if (value != null) {
            setId(value.getId());
            setGameId(value.getGameId());
            setName(value.getName());
            setLegalName(value.getLegalName());
            setPriceDefault(value.getPriceDefault());
            setCountMls(value.getCountMls());
            resetChangedOnNotNull();
        }
    }
}
