package sysjm3.bulbo.bulbo.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name="users")
public class User implements Serializable {

    public User() {
    }

    public User(String username, String forename, String surname, String email, String password) {
        this.username = username;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.password = password;
        //this.registerDate = registerDate;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "forename", nullable = true)
    private String forename;

    @Column(name = "surname", nullable = true)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "registerDate", nullable = false)
    private Date registerDate;

    @ManyToMany(targetEntity = Workspace.class, fetch = FetchType.EAGER)
    @Column(name = "workspaces", nullable = true)
    private List<Workspace> workspaces;

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
     * Getter for the field username
     *
     * @return String type value of the variable username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for the field username
     *
     * @param username value to replace the current username value
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for the field forename
     *
     * @return String type value of the variable forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * Setter for the field forename
     *
     * @param forename value to replace the current forename value
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * Getter for the field surname
     *
     * @return String type value of the variable surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter for the field surname
     *
     * @param surname value to replace the current surname value
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter for the field email
     *
     * @return String type value of the variable email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the field email
     *
     * @param email value to replace the current email value
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * TODO: Encrypt password Getter for the field password
     *
     * @return String type value of the variable password
     */
    public String getPassword() {
        return password;
    }

    /**
     * TODO: Encrypt password Setter for the field password
     *
     * @param password value to replace the current password value
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for the field registerDate
     *
     * @return String type value of the variable registerDate
     */
    public String getRegisterDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(registerDate);
    }

    /**
     * Setter for the field registerDate
     *
     * @param registerDate value to replace the current registerDate value
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Getter for the field workspaces
     *
     * @return List collection of type Workspace
     */
    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    /**
     * Setter for the field workspaces
     *
     * @param workspaces value to replace the current workspaces value
     */
    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username
                + ", forename=" + forename + ", surname=" + surname
                + ", email=" + email + ", password=" + password
                + ", registerDate=" + registerDate
                + ", workspaces=" + workspaces + '}';
    }

}
