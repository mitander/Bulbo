package sysjm3.bulbo.Bulbo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Card entity object used for the database. This entity is in a table called
 * cards and holds standard getters and setters. It also holds a many to one
 * relationship with the entity Workspace.
 *
 */
@Entity
@Table(name = "cards")
public class Card implements Serializable {

    public Card() {
    }

    public Card(String name, String content, Workspace workspace) {
        this.name = name;
        this.content = content;
        this.workspace = workspace;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name = "workspace_id", referencedColumnName = "ID", nullable = false)
    private Workspace workspace;

    /**
     * Getter for the field id
     *
     * @return long type value of the variable id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for the field id
     *
     * @param id long value to replace the current id value
     */
    public void setId(long id) {
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
     * Getter for the field content
     *
     * @return String type value of the variable content
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter for the field content
     *
     * @param content String value to replace the current content value
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter for the field workspace
     *
     * @return Workspace type value of the variable workspace
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * Setter for the field content
     *
     * @param workspace Workspace value to replace the current workspace value
     */
    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Card other = (Card) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", name=" + name + ", content=" + content + ", workspace=" + workspace + '}';
    }

}
