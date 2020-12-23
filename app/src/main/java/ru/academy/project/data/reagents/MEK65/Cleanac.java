package ru.academy.project.data.reagents.MEK65;

public class Cleanac {
    private double clValue = 5000;
    private double clAllTestPOn = 2.5;
    private double clAlltestTests;
    private double clAlltestOff = 24;

    private double clYearPOn;
    private double clYearTest;
    private double clYearPOff;
    private int clBottle;

    public int cleanacCalc(double days, double analyze) {
        clAlltestTests = 0.8 * analyze;
        clYearPOn = clAllTestPOn * days / clValue;
        clYearTest = clAlltestTests * days / clValue;
        clYearPOff = clAlltestOff * days / clValue;
        clBottle = (int) Math.ceil(clYearPOn + clYearTest + clYearPOff);
        return clBottle;
    }
}
