package ru.academy.project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.academy.project.R;
import ru.academy.project.activities.calculators.Calculator65Activity;
import ru.academy.project.activities.calculators.Calculator73Activity;

public class MEK73Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mek_73);

        findViewById(R.id.toCalculator73Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MEK73Activity.this, Calculator73Activity.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.toContragents73Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MEK73Activity.this, Contragents73Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}