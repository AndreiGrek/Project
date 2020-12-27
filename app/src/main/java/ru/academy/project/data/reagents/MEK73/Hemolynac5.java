package ru.academy.project.data.reagents.MEK73;

public class Hemolynac5 {
    private double h5Value = 1000;
    private double h5AllTestPOn = 1.9;
    private double h5AlltestTests;
    private double h5AlltestOff = 1.85;

    private double h5YearPOn;
    private double h5YearTest;
    private double h5YearPOff;
    private int h5Bottle;

    public int hemolynac5Calc(double days, double analyze) {
        h5AlltestTests = 0.63 * analyze;
        h5YearPOn = h5AllTestPOn * days / h5Value;
        h5YearTest = h5AlltestTests * days / h5Value;
        h5YearPOff = h5AlltestOff * days / h5Value;
        h5Bottle = (int) Math.ceil(h5YearPOn + h5YearTest + h5YearPOff + 2);
        return h5Bottle;
    }
}
