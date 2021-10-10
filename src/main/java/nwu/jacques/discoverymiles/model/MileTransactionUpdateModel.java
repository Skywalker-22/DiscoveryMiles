package nwu.jacques.discoverymiles.model;

import javax.validation.constraints.Positive;
import java.util.Date;

public class MileTransactionUpdateModel {
    @Positive
    private double value;
    private Date transactionDate;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return Math.abs(this.value);
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
