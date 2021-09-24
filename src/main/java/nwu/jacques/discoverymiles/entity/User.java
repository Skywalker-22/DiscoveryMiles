package nwu.jacques.discoverymiles.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "miles", nullable = false)
    private double miles;

    @Column(name = "username", nullable = false)
    @NotNull(message = "username cannot be null")
    private String username;

    @Column(name = "email", nullable = false)
    @NotNull(message = "email cannot be null")
    @Email(message = "email should be valid")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MileTransaction> mileTransactions = new ArrayList<>();

    public User() {

    }

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public double getMiles() { return miles; }
    public void setMiles(double miles) { this.miles = miles; }

    public List<MileTransaction> getMileTransactions () { return this.mileTransactions; }

    public void addMileTransaction(MileTransaction transaction) {
        mileTransactions.add(transaction);
    }
}
