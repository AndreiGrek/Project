package ru.academy.project.calculators;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.text.DecimalFormat;

import ru.academy.project.activities.calculators.Calculator65Activity;
import ru.academy.project.data.reagents.MEK65.Cleanac;
import ru.academy.project.data.reagents.MEK65.Cleanac3;
import ru.academy.project.data.reagents.MEK65.Hemolynac3;
import ru.academy.project.data.reagents.MEK65.Isotonac;

public class Calculator65 {

    private Isotonac isotonac;
    private Cleanac cleanac;
    private Cleanac3 cleanac3;
    private Hemolynac3 hemolynac3;
    private double days, analyze, allPrice, allPriceControl;

    private String isoPrice = "Стоимость Isotonac3";
    private String clPrice = "Стоимость Cleanac";
    private String cl3Price = "Стоимость Cleanac3";
    private String h3Price = "Стоимость Hemolynac3";
    private String contrPrice = "Стоимость набора контролей 3dif";
    private SharedPreferences sPref;

    private DecimalFormat df = new DecimalFormat("#.##");
    private DecimalFormat df2 = new DecimalFormat("#.###");
    Calculator65Activity calculator65Activity;

    public Calculator65(Calculator65Activity calculator65Activity) {
        this.calculator65Activity = calculator65Activity;
    }

    public void calculateAll() {

        if (!analyzeIsEmpty() && !daysIsEmpty()) {
            days = Double.parseDouble(calculator65Activity.getEditTextDays().getText().toString());
            analyze = Integer.parseInt(calculator65Activity.getEditTextAnalyze().getText().toString());
            isotonac = new Isotonac();
            cleanac = new Cleanac();
            cleanac3 = new Cleanac3();
            hemolynac3 = new Hemolynac3();
            sPref = calculator65Activity.getSharedPreferences("PREF", Context.MODE_PRIVATE);

            if (sPref.contains(isoPrice)
                    && sPref.contains(clPrice)
                    && sPref.contains(cl3Price)
                    && sPref.contains(h3Price)
                    && sPref.contains(contrPrice)) {
                if (!controlIsEmpty()) {
                    calculateWithControls();

                } else if (controlIsEmpty()) {
                    calculateWithoutControls();
                }

            } else {
                calculateWithoutPrice();
            }

        } else if (!analyzeIsEmpty() && daysIsEmpty()) {
            Toast.makeText(calculator65Activity, "Введите количество рабочих дней в году", Toast.LENGTH_SHORT).show();
        } else if (analyzeIsEmpty() && !daysIsEmpty()) {
            Toast.makeText(calculator65Activity, "Введите количество анализов в день", Toast.LENGTH_SHORT).show();
        } else if (analyzeIsEmpty() && daysIsEmpty()) {
            Toast.makeText(calculator65Activity, "Введите количество рабочих дней и количество анализов в день", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean analyzeIsEmpty() {
        if (calculator65Activity.getEditTextAnalyze().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public boolean daysIsEmpty() {
        if (calculator65Activity.getEditTextDays().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public boolean controlIsEmpty() {
        if (calculator65Activity.getEditTextControl().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public void calculateWithControls() {
        calculator65Activity.getTextViewIsoResult().setText("Isotonac:\n" + isotonac.isotonacCalc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(isoPrice, 0) + " BYN = "
                + df.format((isotonac.isotonacCalc(days, analyze)) * sPref.getFloat(isoPrice, 0)) + " BYN");
        calculator65Activity.getTextViewClResult().setText("Cleanac:\n" + cleanac.cleanacCalc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(clPrice, 0) + " BYN = "
                + df.format((cleanac.cleanacCalc(days, analyze)) * sPref.getFloat(clPrice, 0)) + " BYN");
        calculator65Activity.getTextViewCl3Result().setText("Cleanac3:\n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(cl3Price, 0) + " BYN = "
                + df.format((cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)) + " BYN");
        calculator65Activity.getTextViewH3Result().setText("Hemolynac3:\n" + hemolynac3.hemolynac3Calc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(h3Price, 0) + " BYN = "
                + df.format((hemolynac3.hemolynac3Calc(days, analyze)) * sPref.getFloat(h3Price, 0)) + " BYN");
        allPrice = (isotonac.isotonacCalc(days, analyze)) * sPref.getFloat(isoPrice, 0)
                + (cleanac.cleanacCalc(days, analyze)) * sPref.getFloat(clPrice, 0)
                + (cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)
                + (hemolynac3.hemolynac3Calc(days, analyze)) * sPref.getFloat(h3Price, 0);
        calculator65Activity.getTextViewAllResult().setText("Общая стоимость без контролей: " + df.format(allPrice) + " BYN");
        calculator65Activity.getTextViewOnePrice().setText("Стоимость одного анализа без контролей: " +
                df2.format(allPrice / (days * analyze)) + " BYN");
        allPriceControl = allPrice + sPref.getFloat(contrPrice, 0) * Float.parseFloat(calculator65Activity.getEditTextControl().getText().toString());
        calculator65Activity.getTextViewOnlyControl().setText("Контроли: \n"
                + Integer.parseInt(calculator65Activity.getEditTextControl().getText().toString()) + " наборов * "
                + sPref.getFloat(contrPrice, 0) + " BYN = "
                + df.format(Integer.parseInt(calculator65Activity.getEditTextControl().getText().toString())
                * sPref.getFloat(contrPrice, 0)) + " BYN");
        calculator65Activity.getTextViewAllResultControl().setText("Общая стоимость с контролями: "
                + df.format(allPriceControl) + " BYN");
        calculator65Activity.getTextViewOnePriceControl().setText("Стоимость одного анализа c контролями: "
                + df2.format(allPriceControl / (days * analyze)) + " BYN");
        Toast.makeText(calculator65Activity,
                "Рассчитано успешно", Toast.LENGTH_SHORT).show();
    }

    public void calculateWithoutControls() {
        calculator65Activity.getTextViewIsoResult().setText("Isotonac:\n" + isotonac.isotonacCalc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(isoPrice, 0) + " BYN = "
                + df.format((isotonac.isotonacCalc(days, analyze)) * sPref.getFloat(isoPrice, 0)) + " BYN");
        calculator65Activity.getTextViewClResult().setText("Cleanac:\n" + cleanac.cleanacCalc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(clPrice, 0) + " BYN = "
                + df.format((cleanac.cleanacCalc(days, analyze)) * sPref.getFloat(clPrice, 0)) + " BYN");
        calculator65Activity.getTextViewCl3Result().setText("Cleanac3:\n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(cl3Price, 0) + " BYN = "
                + df.format((cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)) + " BYN");
        calculator65Activity.getTextViewH3Result().setText("Hemolynac3:\n" + hemolynac3.hemolynac3Calc(days, analyze) + " упаковок"
                + " * " + sPref.getFloat(h3Price, 0) + " BYN = "
                + df.format((hemolynac3.hemolynac3Calc(days, analyze)) * sPref.getFloat(h3Price, 0)) + " BYN");
        allPrice = (isotonac.isotonacCalc(days, analyze)) * sPref.getFloat(isoPrice, 0)
                + (cleanac.cleanacCalc(days, analyze)) * sPref.getFloat(clPrice, 0)
                + (cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)
                + (hemolynac3.hemolynac3Calc(days, analyze)) * sPref.getFloat(h3Price, 0);
        calculator65Activity.getTextViewAllResult().setText("Общая стоимость без контролей: " + df.format(allPrice) + " BYN");
        calculator65Activity.getTextViewOnePrice().setText("Стоимость одного анализа без контролей: " + df2.format(allPrice / (days * analyze)) + " BYN");
        Toast.makeText(calculator65Activity,
                "Рассчитано успешно", Toast.LENGTH_SHORT).show();
    }

    public void calculateWithoutPrice() {
        calculator65Activity.getTextViewIsoResult().setText("Isotonac: \n" + isotonac.isotonacCalc(days, analyze) + " упаковок");
        calculator65Activity.getTextViewClResult().setText("Cleanac: \n" + cleanac.cleanacCalc(days, analyze) + " упаковок");
        calculator65Activity.getTextViewCl3Result().setText("Cleanac3: \n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок");
        calculator65Activity.getTextViewH3Result().setText("Hemolynac3: \n" + hemolynac3.hemolynac3Calc(days, analyze) + " упаковок");
        Toast.makeText(calculator65Activity,
                "Цену одного исследования рассчитать невозможно, так как не введена стоимость реагентов", Toast.LENGTH_SHORT).show();
    }

}

