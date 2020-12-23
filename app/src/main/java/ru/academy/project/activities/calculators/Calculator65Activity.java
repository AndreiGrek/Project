package ru.academy.project.activities.calculators;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.academy.project.R;
import ru.academy.project.activities.prices.Price65Activity;
import ru.academy.project.calculators.Calculator65;


public class Calculator65Activity extends AppCompatActivity {

    private EditText editTextDays, editTextAnalyze, editTextControl;
    private TextView textViewIsoResult, textViewClResult, textViewCl3Result, textViewH3Result, textViewAllResult,
            textViewOnePrice, textViewOnlyControl, textViewAllResultControl, textViewOnePriceControl;

    public EditText getEditTextDays() {
        return editTextDays;
    }

    public EditText getEditTextAnalyze() {
        return editTextAnalyze;
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
        setContentView(R.layout.activity_calculator65);

        editTextDays = findViewById(R.id.days);
        editTextAnalyze = findViewById(R.id.analyze);
        editTextControl = findViewById(R.id.control);
        textViewIsoResult = findViewById(R.id.isoResult);
        textViewClResult = findViewById(R.id.clResult);
        textViewCl3Result = findViewById(R.id.cl3Result);
        textViewH3Result = findViewById(R.id.h3Result);
        textViewAllResult = findViewById(R.id.allResult);
        textViewOnePrice = findViewById(R.id.onePrice);
        textViewOnlyControl = findViewById(R.id.onlyControl);
        textViewAllResultControl = findViewById(R.id.allResultControl);
        textViewOnePriceControl = findViewById(R.id.onePriceControl);

        findViewById(R.id.calcButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator65 presenter = new Calculator65(Calculator65Activity.this);
                presenter.calculateAll();
            }
        });

        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDays.setText("");
                editTextAnalyze.setText("");
                editTextControl.setText("");
                textViewIsoResult.setText("");
                textViewClResult.setText("");
                textViewCl3Result.setText("");
                textViewH3Result.setText("");
                textViewAllResult.setText("");
                textViewOnePrice.setText("");
                textViewOnlyControl.setText("");
                textViewAllResultControl.setText("");
                textViewOnePriceControl.setText("");
            }
        });

        findViewById(R.id.toPriceButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculator65Activity.this, Price65Activity.class);
                startActivity(intent);
            }
        });
    }

}