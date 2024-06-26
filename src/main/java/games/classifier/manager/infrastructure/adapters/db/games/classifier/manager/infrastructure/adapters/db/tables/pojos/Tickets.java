/*
 * This file is generated by jOOQ.
 */
package games.classifier.manager.infrastructure.adapters.db.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final Long gameId;
    private final String barcode;
    private final Short status;

    public Tickets(Tickets value) {
        this.id = value.id;
        this.gameId = value.gameId;
        this.barcode = value.barcode;
        this.status = value.status;
    }

    public Tickets(
        Long id,
        Long gameId,
        String barcode,
        Short status
    ) {
        this.id = id;
        this.gameId = gameId;
        this.barcode = barcode;
        this.status = status;
    }

    /**
     * Getter for <code>public.tickets.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.tickets.game_id</code>.
     */
    public Long getGameId() {
        return this.gameId;
    }

    /**
     * Getter for <code>public.tickets.barcode</code>.
     */
    public String getBarcode() {
        return this.barcode;
    }

    /**
     * Getter for <code>public.tickets.status</code>.
     */
    public Short getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Tickets other = (Tickets) obj;
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
        if (this.barcode == null) {
            if (other.barcode != null)
                return false;
        }
        else if (!this.barcode.equals(other.barcode))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.gameId == null) ? 0 : this.gameId.hashCode());
        result = prime * result + ((this.barcode == null) ? 0 : this.barcode.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tickets (");

        sb.append(id);
        sb.append(", ").append(gameId);
        sb.append(", ").append(barcode);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }
}
