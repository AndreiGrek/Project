package ru.academy.project.activities.prices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ru.academy.project.R;
import ru.academy.project.activities.calculators.Calculator73Activity;

public class Price73Activity extends AppCompatActivity {

    private EditText isotonacPrice;
    private EditText cleanacPrice;
    private EditText cleanac3Price;
    private EditText hemolynac3Price;
    private EditText hemolynac5Price;
    private EditText controlPrice;
    private SharedPreferences sharedPreferences;
    private String isoPrice = "Стоимость Isotonac3";
    private String clPrice = "Стоимость Cleanac";
    private String cl3Price = "Стоимость Cleanac3";
    private String h3Price = "Стоимость Hemolynac3";
    private String h5Price = "Стоимость Hemolynac5";
    private String contrPrice = "Стоимость набора контролей 5dif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price73);

        isotonacPrice = findViewById(R.id.isotonacPrice73);
        cleanacPrice = findViewById(R.id.cleanacPrice73);
        cleanac3Price = findViewById(R.id.cleanac3Price73);
        hemolynac3Price = findViewById(R.id.hemolynac3Price73);
        hemolynac5Price = findViewById(R.id.hemolynac5Price73);
        controlPrice = findViewById(R.id.controlPrice73);


        findViewById(R.id.saveReagentsButton73).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPriceEmpty()) {
                    savePrice();
                    Intent toMainIntent = new Intent(Price73Activity.this, Calculator73Activity.class);
                    startActivity(toMainIntent);
                    Toast.makeText(Price73Activity.this, "Стоимость реагентов успешно сохранена", Toast.LENGTH_SHORT).show();
                    finish();
                } else if (isPriceEmpty()) {
                    Toast.makeText(Price73Activity.this, "Введите стоимость всех реагентов", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void savePrice() {
        sharedPreferences = getSharedPreferences("PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putFloat(isoPrice, Float.parseFloat(isotonacPrice.getText().toString()));
        ed.putFloat(clPrice, Float.parseFloat(cleanacPrice.getText().toString()));
        ed.putFloat(cl3Price, Float.parseFloat(cleanac3Price.getText().toString()));
        ed.putFloat(h3Price, Float.parseFloat(hemolynac3Price.getText().toString()));
        ed.putFloat(h5Price, Float.parseFloat(hemolynac5Price.getText().toString()));
        ed.putFloat(contrPrice, Float.parseFloat(controlPrice.getText().toString()));
        ed.apply();
    }

    public boolean isPriceEmpty() {
        if (isotonacPrice.getText().toString().trim().length() == 0 ||
                cleanacPrice.getText().toString().trim().length() == 0 ||
                cleanac3Price.getText().toString().trim().length() == 0 ||
                hemolynac3Price.getText().toString().trim().length() == 0 ||
                hemolynac5Price.getText().toString().trim().length() == 0 ||
                controlPrice.getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }
}