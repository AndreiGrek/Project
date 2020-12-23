package ru.academy.project.data.reagents.MEK65;

public class Isotonac {
    private double isoValue = 20000;
    private double isoAllTestPOn = 38;
    private double isoAlltestTests;
    private double isoAlltestOff = 142.64;

    private double isoYearPOn;
    private double isoYearTest;
    private double isoYearPOff;
    private int isoBottle;

    public int isotonacCalc(double days, double analyze) {
        isoAlltestTests = 37 * analyze;
        isoYearPOn = isoAllTestPOn * days / isoValue;
        isoYearTest = isoAlltestTests * days / isoValue;
        isoYearPOff = isoAlltestOff * days / isoValue;
        isoBottle = (int) Math.ceil(isoYearPOn + isoYearTest + isoYearPOff);
        return isoBottle;
    }
}
