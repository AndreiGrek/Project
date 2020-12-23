package ru.academy.project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.academy.project.R;
import ru.academy.project.activities.calculators.Calculator65Activity;

public class MEK65Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mek_65);

        findViewById(R.id.toCalculator65Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MEK65Activity.this, Calculator65Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}