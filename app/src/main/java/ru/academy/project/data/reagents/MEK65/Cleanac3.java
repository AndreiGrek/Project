package ru.academy.project.data.reagents.MEK65;

public class Cleanac3 {
    private double cl3Value = 1000;
    private double cl3AllTestPOn = 4;
    private double cl3AlltestOff = 57.7;

    private double cl3YearPOn;
    private double cl3YearTest;
    private double cl3YearPOff;
    private int cl3Bottle;

    public int cleanac3Calc(double days, double analyze) {
        cl3YearPOn = cl3AllTestPOn * days / cl3Value;
        cl3YearPOff = cl3AlltestOff * days / cl3Value;
        cl3Bottle = (int) Math.ceil(cl3YearPOn + cl3YearTest + cl3YearPOff);
        return cl3Bottle;
    }
}
