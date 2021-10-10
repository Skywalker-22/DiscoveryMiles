package nwu.jacques.discoverymiles.model;

import java.util.Date;

public class UserMilesModel {
    private double currentMileBalance;
    public Date lastMileTransaction;
    public String username;

    public UserMilesModel(double currentMileBalance, Date lastMileTransaction, String username) {
        this.currentMileBalance = currentMileBalance;
        this.username = username;
        this.lastMileTransaction = lastMileTransaction;
    }

    public UserMilesModel() {
    }

    public Date getLastMileTransaction() {
        return lastMileTransaction;
    }

    public double getCurrentMileBalance() {
        return currentMileBalance;
    }

    public void setCurrentMileBalance(double currentMileBalance) {
        this.currentMileBalance = currentMileBalance;
    }

    public void setLastMileTransaction(Date lastMileTransaction) {
        this.lastMileTransaction = lastMileTransaction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
