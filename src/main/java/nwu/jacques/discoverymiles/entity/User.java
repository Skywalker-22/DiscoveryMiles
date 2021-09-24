package nwu.jacques.discoverymiles.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    private long id;

    @NotNull(message = "username cannot be null")
    private String username;

    @NotNull(message = "email cannot be null")
    @Email(message = "email should be valid")
    private String email;

    public User() {

    }

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
