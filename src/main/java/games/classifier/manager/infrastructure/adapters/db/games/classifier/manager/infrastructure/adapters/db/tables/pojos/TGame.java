/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TGame implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer id;
    private final Integer gameId;
    private final String name;
    private final Long priceDefault;
    private final LocalDateTime updatedAt;
    private final Boolean deleted;

    public TGame(TGame value) {
        this.id = value.id;
        this.gameId = value.gameId;
        this.name = value.name;
        this.priceDefault = value.priceDefault;
        this.updatedAt = value.updatedAt;
        this.deleted = value.deleted;
    }

    public TGame(
        Integer id,
        Integer gameId,
        String name,
        Long priceDefault,
        LocalDateTime updatedAt,
        Boolean deleted
    ) {
        this.id = id;
        this.gameId = gameId;
        this.name = name;
        this.priceDefault = priceDefault;
        this.updatedAt = updatedAt;
        this.deleted = deleted;
    }

    /**
     * Getter for <code>public.t_game.id</code>. PK
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.t_game.game_id</code>. Идентификатор игры
     */
    public Integer getGameId() {
        return this.gameId;
    }

    /**
     * Getter for <code>public.t_game.name</code>. Наименование игры
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>public.t_game.price_default</code>. Стоимость МЛС по
     * умолчанию
     */
    public Long getPriceDefault() {
        return this.priceDefault;
    }

    /**
     * Getter for <code>public.t_game.updated_at</code>. Время последнего
     * изменения свойств игры
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for <code>public.t_game.deleted</code>. Блокировка игры
     */
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TGame other = (TGame) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.gameId == null) {
            if (other.gameId != null)
                return false;
        }
        else if (!this.gameId.equals(other.gameId))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.priceDefault == null) {
            if (other.priceDefault != null)
                return false;
        }
        else if (!this.priceDefault.equals(other.priceDefault))
            return false;
        if (this.updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        }
        else if (!this.updatedAt.equals(other.updatedAt))
            return false;
        if (this.deleted == null) {
            if (other.deleted != null)
                return false;
        }
        else if (!this.deleted.equals(other.deleted))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.gameId == null) ? 0 : this.gameId.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.priceDefault == null) ? 0 : this.priceDefault.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        result = prime * result + ((this.deleted == null) ? 0 : this.deleted.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TGame (");

        sb.append(id);
        sb.append(", ").append(gameId);
        sb.append(", ").append(name);
        sb.append(", ").append(priceDefault);
        sb.append(", ").append(updatedAt);
        sb.append(", ").append(deleted);

        sb.append(")");
        return sb.toString();
    }
}
