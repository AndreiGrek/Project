package ru.academy.project.activities.calculators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import ru.academy.project.R;
import ru.academy.project.activities.prices.Price73Activity;
import ru.academy.project.calculators.Calculator73;
import ru.academy.project.data.reagents.MEK73.Cleanac;
import ru.academy.project.data.reagents.MEK73.Cleanac3;
import ru.academy.project.data.reagents.MEK73.Hemolynac3;
import ru.academy.project.data.reagents.MEK73.Hemolynac5;
import ru.academy.project.data.reagents.MEK73.Isotonac;

public class Calculator73Activity extends AppCompatActivity {

    private EditText editTextDays, editTextAnalyze, editTextAnalyzeCBC, editTextControl;
    private TextView textViewIsoResult, textViewClResult, textViewCl3Result, textViewH3Result, textViewH5Result, textViewAllResult,
            textViewOnePrice, textViewOnlyControl, textViewAllResultControl, textViewOnePriceControl;

    public EditText getEditTextDays() {
        return editTextDays;
    }

    public EditText getEditTextAnalyze() {
        return editTextAnalyze;
    }

    public EditText getEditTextAnalyzeCBC() {
        return editTextAnalyzeCBC;
    }

    public EditText getEditTextControl() {
        return editTextControl;
    }

    public TextView getTextViewIsoResult() {
        return textViewIsoResult;
    }

    public TextView getTextViewClResult() {
        return textViewClResult;
    }

    public TextView getTextViewCl3Result() {
        return textViewCl3Result;
    }

    public TextView getTextViewH3Result() {
        return textViewH3Result;
    }

    public TextView getTextViewH5Result() {
        return textViewH5Result;
    }

    public TextView getTextViewAllResult() {
        return textViewAllResult;
    }

    public TextView getTextViewOnePrice() {
        return textViewOnePrice;
    }

    public TextView getTextViewOnlyControl() {
        return textViewOnlyControl;
    }

    public TextView getTextViewAllResultControl() {
        return textViewAllResultControl;
    }

    public TextView getTextViewOnePriceControl() {
        return textViewOnePriceControl;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator73);

        editTextDays = findViewById(R.id.days73);
        editTextAnalyze = findViewById(R.id.analyze73);
        editTextAnalyzeCBC = findViewById(R.id.analyzeCBC73);
        editTextControl = findViewById(R.id.control73);
        textViewIsoResult = findViewById(R.id.isoResult73);
        textViewClResult = findViewById(R.id.clResult73);
        textViewCl3Result = findViewById(R.id.cl3Result73);
        textViewH3Result = findViewById(R.id.h3Result73);
        textViewH5Result = findViewById(R.id.h5Result73);
        textViewAllResult = findViewById(R.id.allResult73);
        textViewOnePrice = findViewById(R.id.onePrice73);
        textViewOnlyControl = findViewById(R.id.onlyControl73);
        textViewAllResultControl = findViewById(R.id.allResultControl73);
        textViewOnePriceControl = findViewById(R.id.onePriceControl73);

        findViewById(R.id.calcButton73).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Calculator73 presenter = new Calculator73(Calculator73Activity.this);
                presenter.calculateAll();
            }
        });

        findViewById(R.id.clearButton73).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDays.setText("");
                editTextAnalyze.setText("");
                editTextAnalyzeCBC.setText("");
                editTextControl.setText("");
                textViewIsoResult.setText("");
                textViewClResult.setText("");
                textViewCl3Result.setText("");
                textViewH3Result.setText("");
                textViewH5Result.setText("");
                textViewAllResult.setText("");
                textViewOnePrice.setText("");
                textViewOnlyControl.setText("");
                textViewAllResultControl.setText("");
                textViewOnePriceControl.setText("");
            }
        });

        findViewById(R.id.toPriceButton73).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculator73Activity.this, Price73Activity.class);
                startActivity(intent);
            }
        });
    }
}