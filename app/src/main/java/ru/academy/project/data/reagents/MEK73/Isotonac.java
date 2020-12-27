package ru.academy.project.data.reagents.MEK73;

public class Isotonac {
    private double isoValue = 20000;
    private double isoAllTestPOn = 141.24;
    private double isoAlltestTests;
    private double isoAlltestCBCOnly;
    private double isoAlltestOff = 395.29;

    private double isoYearPOn;
    private double isoYearTest;
    private double isoYearTestCBC;
    private double isoYearPOff;
    private int isoBottle;

    public int isotonacCalc(double days, double analyze, double analyzeCBC) {
        isoAlltestTests = 59.59 * analyze;
        isoAlltestCBCOnly = 40.31 * analyzeCBC;
        isoYearPOn = isoAllTestPOn * days / isoValue;
        isoYearTest = isoAlltestTests * days / isoValue;
        isoYearTestCBC = isoAlltestCBCOnly * days / isoValue;
        isoYearPOff = isoAlltestOff * days / isoValue;
        isoBottle = (int) Math.ceil(isoYearPOn + isoYearTest + isoYearTestCBC + isoYearPOff);
        return isoBottle;
    }
}
