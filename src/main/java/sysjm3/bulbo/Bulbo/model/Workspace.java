package sysjm3.bulbo.Bulbo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Workspace entity object used for the database. This entity is in a table
 * called workspaces and holds standard getters and setters. It also holds a one
 * to many relationship with the entity Card.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "workspaces")
public class Workspace implements Serializable {

    public Workspace() {
    }

    public Workspace(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "workspace", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Card> cards;

    /**
     * Getter for the field id
     *
     * @return UUID type value of the variable id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Setter for the field id
     *
     * @param id UUID value to replace the current id value
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for the field name
     *
     * @return String type value of the variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the field name
     *
     * @param name String value to replace the current name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the field cards
     *
     * @return List collection of the type Card which holds all the Card
     * relations
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Setter for the field cards
     *
     * @param cards List collection of the type Card which will replace the
     * current Card collection
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Workspace other = (Workspace) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workspace{" + "id=" + id + ", name=" + name + "}";
    }

}
