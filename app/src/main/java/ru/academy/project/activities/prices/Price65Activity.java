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
import ru.academy.project.activities.calculators.Calculator65Activity;

public class Price65Activity extends AppCompatActivity {
    EditText isotonacPrice;
    EditText cleanacPrice;
    EditText cleanac3Price;
    EditText hemolynac3Price;
    EditText controlPrice;
    SharedPreferences sharedPreferences;
    String isoPrice = "Стоимость Isotonac3";
    String clPrice = "Стоимость Cleanac";
    String cl3Price = "Стоимость Cleanac3";
    String h3Price = "Стоимость Hemolynac3";
    String contrPrice = "Стоимость набора контролей 3dif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price65);

        isotonacPrice = findViewById(R.id.isotonacPrice);
        cleanacPrice = findViewById(R.id.cleanacPrice);
        cleanac3Price = findViewById(R.id.cleanac3Price);
        hemolynac3Price = findViewById(R.id.hemolynac3Price);
        controlPrice = findViewById(R.id.controlPrice);


        findViewById(R.id.saveReagentsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPriceEmpty()) {
                    savePrice();
                    Intent toMainIntent = new Intent(Price65Activity.this, Calculator65Activity.class);
                    startActivity(toMainIntent);
                    Toast.makeText(Price65Activity.this, "Стоимость реагентов успешно сохранена", Toast.LENGTH_SHORT).show();
                    finish();
                } else if (isPriceEmpty()) {
                    Toast.makeText(Price65Activity.this, "Введите стоимость всех реагентов", Toast.LENGTH_SHORT).show();
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
        ed.putFloat(contrPrice, Float.parseFloat(controlPrice.getText().toString()));
        ed.apply();
    }

    public boolean isPriceEmpty() {
        if (isotonacPrice.getText().toString().trim().length() == 0 ||
                cleanacPrice.getText().toString().trim().length() == 0 ||
                cleanac3Price.getText().toString().trim().length() == 0 ||
                hemolynac3Price.getText().toString().trim().length() == 0 ||
                controlPrice.getText().toString().trim().length() == 0) {
            return true;
        } else return false;
    }
}