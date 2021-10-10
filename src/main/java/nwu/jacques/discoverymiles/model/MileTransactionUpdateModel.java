package nwu.jacques.discoverymiles.model;

import javax.validation.constraints.Positive;

public class MileTransactionUpdateModel {
    @Positive
    private double value;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return Math.abs(this.value);
    }
}
