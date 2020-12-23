package ru.academy.project.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.academy.project.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.to6500button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to6500Intent = new Intent(MainActivity.this, MEK65Activity.class);
                startActivity(to6500Intent);
            }
        });

        findViewById(R.id.to7300button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to7300Intent = new Intent(MainActivity.this, MEK73Activity.class);
                startActivity(to7300Intent);
            }
        });
    }
}