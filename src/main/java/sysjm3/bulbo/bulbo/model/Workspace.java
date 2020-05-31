package sysjm3.bulbo.bulbo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
        this.created = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Workspace(String name, User user) {
        this.name = name;
        this.user = user;
        this.created = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "workspace_id", columnDefinition = "UUID", insertable = false, updatable = false, nullable = false)
    private UUID UUID;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "workspace", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Card> cards;
    
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, optional = false)
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "created", updatable = false)
    private final String created;
    
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

    /**
     * Getter for the field user
     *
     * @return User entity
     */
    public User getUsers() {
        return user;
    }

    /**
     * Setter for the field users
     *
     * @param user User entity which will replace the current User
     */
    public void setUsers(User user) {
        this.user = user;
    }
    

    public String getCreated() {
        return created;
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
        return this.UUID == other.UUID;
    }

    @Override
    public String toString() {
        return "Workspace{" + "UUID=" + UUID + ", name=" + name + ", cards=" + cards + '}';
    }

}
