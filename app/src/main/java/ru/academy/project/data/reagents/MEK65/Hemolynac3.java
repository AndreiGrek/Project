package ru.academy.project.data.reagents.MEK65;

public class Hemolynac3 {
    private double h3Value = 1000;
    private double h3AllTestPOn = 0;
    private double h3AlltestTests;
    private double h3AlltestOff = 1.2;

    private double h3YearPOn;
    private double h3YearTest;
    private double h3YearPOff;
    private int h3Bottle;

    public int hemolynac3Calc(double days, double analyze) {
        h3AlltestTests = 0.6 * analyze;
        h3YearPOn = h3AllTestPOn * days / h3Value;
        h3YearTest = h3AlltestTests * days / h3Value;
        h3YearPOff = h3AlltestOff * days / h3Value;
        h3Bottle = (int) Math.ceil(h3YearPOn + h3YearTest + h3YearPOff);
        return h3Bottle;
    }
}
