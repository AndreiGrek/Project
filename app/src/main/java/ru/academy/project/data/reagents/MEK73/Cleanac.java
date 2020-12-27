package ru.academy.project.data.reagents.MEK73;

public class Cleanac {
    private double clValue = 5000;
    private double clAllTestPOn = 22.97;
    private double clAlltestTests;
    private double clAlltestOff = 84.33;

    private double clYearPOn;
    private double clYearTest;
    private double clYearPOff;
    private int clBottle;

    public int cleanacCalc(double days, double analyze, double analyzeCBC) {
        clAlltestTests = 1.99 * (analyze + analyzeCBC);
        clYearPOn = clAllTestPOn * days / clValue;
        clYearTest = clAlltestTests * days / clValue;
        clYearPOff = clAlltestOff * days / clValue;
        clBottle = (int) Math.ceil(clYearPOn + clYearTest + clYearPOff);
        return clBottle;
    }
}
