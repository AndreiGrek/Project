package ru.academy.project.calculators;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.text.DecimalFormat;

import ru.academy.project.activities.calculators.Calculator73Activity;
import ru.academy.project.data.reagents.MEK73.Cleanac;
import ru.academy.project.data.reagents.MEK73.Cleanac3;
import ru.academy.project.data.reagents.MEK73.Hemolynac3;
import ru.academy.project.data.reagents.MEK73.Hemolynac5;
import ru.academy.project.data.reagents.MEK73.Isotonac;

public class Calculator73 {

    private Isotonac isotonac;
    private Cleanac cleanac;
    private Cleanac3 cleanac3;
    private Hemolynac3 hemolynac3;
    private Hemolynac5 hemolynac5;
    private double days, analyze, analyzeCBC, allPrice, allPriceControl;

    private String isoPrice = "Стоимость Isotonac3";
    private String clPrice = "Стоимость Cleanac";
    private String cl3Price = "Стоимость Cleanac3";
    private String h3Price = "Стоимость Hemolynac3";
    private String h5Price = "Стоимость Hemolynac5";
    private String contrPrice = "Стоимость набора контролей 5dif";
    private SharedPreferences sPref;

    private DecimalFormat df = new DecimalFormat("#.##");
    private DecimalFormat df2 = new DecimalFormat("#.###");
    Calculator73Activity calculator73Activity;

    public Calculator73(Calculator73Activity calculator73Activity) {
        this.calculator73Activity = calculator73Activity;
    }

    public void calculateAll() {
        if (!analyzeIsEmpty() && !daysIsEmpty() && !analyzeCBCIsEmpty()) {
            days = Double.parseDouble(calculator73Activity.getEditTextDays().getText().toString());
            analyze = Integer.parseInt(calculator73Activity.getEditTextAnalyze().getText().toString());
            analyzeCBC = Integer.parseInt(calculator73Activity.getEditTextAnalyzeCBC().getText().toString());
            isotonac = new Isotonac();
            cleanac = new Cleanac();
            cleanac3 = new Cleanac3();
            hemolynac3 = new Hemolynac3();
            hemolynac5 = new Hemolynac5();

            sPref = calculator73Activity.getSharedPreferences("PREF", Context.MODE_PRIVATE);

            if (sPref.contains(isoPrice)
                    && sPref.contains(clPrice)
                    && sPref.contains(cl3Price)
                    && sPref.contains(h3Price)
                    && sPref.contains(h5Price)
                    && sPref.contains(contrPrice)) {


                if (!controlIsEmpty()) {
                    calculator73Activity.getTextViewIsoResult().setText("Isotonac:\n" + isotonac.isotonacCalc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(isoPrice, 0) + " BYN = "
                            + df.format((isotonac.isotonacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(isoPrice, 0)) + " BYN");
                    calculator73Activity.getTextViewClResult().setText("Cleanac:\n" + cleanac.cleanacCalc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(clPrice, 0) + " BYN = "
                            + df.format((cleanac.cleanacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(clPrice, 0)) + " BYN");
                    calculator73Activity.getTextViewCl3Result().setText("Cleanac3:\n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок"
                            + " * " + sPref.getFloat(cl3Price, 0) + " BYN = "
                            + df.format((cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)) + " BYN");
                    calculator73Activity.getTextViewH3Result().setText("Hemolynac3:\n" + hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(h3Price, 0) + " BYN = "
                            + df.format((hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC)) * sPref.getFloat(h3Price, 0)) + " BYN");
                    calculator73Activity.getTextViewH5Result().setText("Hemolynac5:\n" + hemolynac5.hemolynac5Calc(days, analyze) + " упаковок"
                            + " * " + sPref.getFloat(h5Price, 0) + " BYN = "
                            + df.format((hemolynac5.hemolynac5Calc(days, analyze)) * sPref.getFloat(h5Price, 0)) + " BYN");
                    allPrice = (isotonac.isotonacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(isoPrice, 0)
                            + (cleanac.cleanacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(clPrice, 0)
                            + (cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)
                            + (hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC)) * sPref.getFloat(h3Price, 0)
                            + (hemolynac5.hemolynac5Calc(days, analyze)) * sPref.getFloat(h5Price, 0);
                    calculator73Activity.getTextViewAllResult().setText("Общая стоимость без контролей: " + df.format(allPrice) + " BYN");
                    calculator73Activity.getTextViewOnePrice().setText("Стоимость одного анализа без контролей: "
                            + df2.format(allPrice / (days * (analyze + analyzeCBC))) + " BYN");

                    allPriceControl = allPrice + sPref.getFloat(contrPrice, 0) * Float.parseFloat(calculator73Activity.getEditTextControl().getText().toString());
                    calculator73Activity.getTextViewOnlyControl().setText("Контроли: \n" + Integer.parseInt(calculator73Activity.getEditTextControl().getText().toString()) + " наборов * "
                            + sPref.getFloat(contrPrice, 0) + " BYN = "
                            + df.format(Integer.parseInt(calculator73Activity.getEditTextControl().getText().toString()) * sPref.getFloat(contrPrice, 0)) + " BYN");
                    calculator73Activity.getTextViewAllResultControl().setText("Общая стоимость с контролями: " + df.format(allPriceControl) + " BYN");
                    calculator73Activity.getTextViewOnePriceControl().setText("Стоимость одного анализа c контролями: "
                            + df2.format(allPriceControl / (days * (analyze + analyzeCBC))) + " BYN");
                    Toast.makeText(calculator73Activity,
                            "Рассчитано успешно", Toast.LENGTH_SHORT).show();

                } else if (controlIsEmpty()) {
                    calculator73Activity.getTextViewIsoResult().setText("Isotonac:\n" + isotonac.isotonacCalc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(isoPrice, 0) + " BYN = "
                            + df.format((isotonac.isotonacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(isoPrice, 0)) + " BYN");
                    calculator73Activity.getTextViewClResult().setText("Cleanac:\n" + cleanac.cleanacCalc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(clPrice, 0) + " BYN = "
                            + df.format((cleanac.cleanacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(clPrice, 0)) + " BYN");
                    calculator73Activity.getTextViewCl3Result().setText("Cleanac3:\n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок"
                            + " * " + sPref.getFloat(cl3Price, 0) + " BYN = "
                            + df.format((cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)) + " BYN");
                    calculator73Activity.getTextViewH3Result().setText("Hemolynac3:\n" + hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC) + " упаковок"
                            + " * " + sPref.getFloat(h3Price, 0) + " BYN = "
                            + df.format((hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC)) * sPref.getFloat(h3Price, 0)) + " BYN");
                    calculator73Activity.getTextViewH5Result().setText("Hemolynac5:\n" + hemolynac5.hemolynac5Calc(days, analyze) + " упаковок"
                            + " * " + sPref.getFloat(h5Price, 0) + " BYN = "
                            + df.format((hemolynac5.hemolynac5Calc(days, analyze)) * sPref.getFloat(h5Price, 0)) + " BYN");
                    allPrice = (isotonac.isotonacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(isoPrice, 0)
                            + (cleanac.cleanacCalc(days, analyze, analyzeCBC)) * sPref.getFloat(clPrice, 0)
                            + (cleanac3.cleanac3Calc(days, analyze)) * sPref.getFloat(cl3Price, 0)
                            + (hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC)) * sPref.getFloat(h3Price, 0)
                            + (hemolynac5.hemolynac5Calc(days, analyze)) * sPref.getFloat(h5Price, 0);
                    calculator73Activity.getTextViewAllResult().setText("Общая стоимость без контролей: " + df.format(allPrice) + " BYN");
                    calculator73Activity.getTextViewOnePrice().setText("Стоимость одного анализа без контролей: " + df2.format(allPrice / (days * (analyze + analyzeCBC)))
                            + " BYN");
                    Toast.makeText(calculator73Activity,
                            "Рассчитано успешно", Toast.LENGTH_SHORT).show();
                }

            } else {
                calculator73Activity.getTextViewIsoResult().setText("Isotonac: \n" + isotonac.isotonacCalc(days, analyze, analyzeCBC) + " упаковок");
                calculator73Activity.getTextViewClResult().setText("Cleanac: \n" + cleanac.cleanacCalc(days, analyze, analyzeCBC) + " упаковок");
                calculator73Activity.getTextViewCl3Result().setText("Cleanac3: \n" + cleanac3.cleanac3Calc(days, analyze) + " упаковок");
                calculator73Activity.getTextViewH3Result().setText("Hemolynac3: \n" + hemolynac3.hemolynac3Calc(days, analyze, analyzeCBC) + " упаковок");
                calculator73Activity.getTextViewH5Result().setText("Hemolynac5: \n" + hemolynac5.hemolynac5Calc(days, analyze) + " упаковок");
                Toast.makeText(calculator73Activity,
                        "Цену одного исследования рассчитать невозможно, так как не введена стоимость реагентов", Toast.LENGTH_SHORT).show();
            }


        } else if (!analyzeIsEmpty() && daysIsEmpty()) {
            Toast.makeText(calculator73Activity, "Введите количество рабочих дней в году", Toast.LENGTH_SHORT).show();
        } else if ((analyzeIsEmpty() || analyzeCBCIsEmpty()) && !daysIsEmpty()) {
            Toast.makeText(calculator73Activity, "Введите количество анализов в день", Toast.LENGTH_SHORT).show();
        } else if (analyzeIsEmpty() && daysIsEmpty()) {
            Toast.makeText(calculator73Activity, "Введите количество рабочих дней и количество анализов в день", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean analyzeIsEmpty() {
        if (calculator73Activity.getEditTextAnalyze().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public boolean daysIsEmpty() {
        if (calculator73Activity.getEditTextDays().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public boolean analyzeCBCIsEmpty() {
        if (calculator73Activity.getEditTextAnalyzeCBC().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

    public boolean controlIsEmpty() {
        if (calculator73Activity.getEditTextControl().getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }

}
