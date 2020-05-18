package sysjm3.bulbo.bulbo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Column(name = "workspace_id", columnDefinition = "UUID", insertable = false, updatable = false, nullable = false)
    private UUID UUID;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = Card.class, mappedBy = "workspace", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Card> cards;

    /**
     * Getter for the field UUID
     *
     * @return UUID type value of the variable UUID
     */
    public UUID getUUID() {
        return UUID;
    }

    /**
     * Setter for the field UUID
     *
     * @param UUID UUID value to replace the current UUID value
     */
    public void setUUID(UUID UUID) {
        this.UUID = UUID;
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
        hash = 97 * hash + Objects.hashCode(this.UUID);
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
        if (this.UUID != other.UUID) {
            return false;
        }
        return true;
    }

@Override
public String toString() {
    return String.format("Workspace{ uuid=%s, name=%s, Cards=%s }",
            UUID.toString(),
            name,
            cards.hashCode());
}

}
