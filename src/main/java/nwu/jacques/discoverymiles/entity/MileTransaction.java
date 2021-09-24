package nwu.jacques.discoverymiles.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mile_transactions")
public class MileTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "runningBalance", nullable = false)
    private double runningBalance;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public MileTransaction() {
    }

    public MileTransaction(long id, double value, Date date, User user, double runningBalance) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.user = user;
        this.runningBalance = runningBalance;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public double getRunningBalance() {
        return runningBalance;
    }
    public void setRunningBalance(double runningBalance) {
        this.runningBalance = runningBalance;
    }
}
