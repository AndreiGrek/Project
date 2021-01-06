package ru.academy.project.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.academy.project.R;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;

public class AddContragentActivity extends AppCompatActivity {
    private String name, phone, description;
    private AppDatabase db;
    private int counter;
    private SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contragent);

        final EditText editText1 = findViewById(R.id.addName);
        final EditText editText2 = findViewById(R.id.addPhone);
        final EditText editText3 = findViewById(R.id.addDescription);
        db = AppDatabase.getInstance(this);

        editText2.setHint(R.string.phoneNumber);


        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSave = new Intent(AddContragentActivity.this, Contragents65Activity.class);
                name = editText1.getText().toString();
                phone = editText2.getText().toString();
                description = editText3.getText().toString();
                loadCounter();
                db.contragentDao().insert(new Contragent(counter, name, phone, description));
                Toast.makeText(AddContragentActivity.this, R.string.addNewContragent, Toast.LENGTH_SHORT).show();
                counter++;
                saveCounter(counter);
                startActivity(intentSave);
                finish();
            }
        });
    }

    void saveCounter(int counter) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt("COUNTER", counter);
        ed.apply();
    }

    public int loadCounter() {
        sPref = getPreferences(MODE_PRIVATE);
        this.counter = sPref.getInt("COUNTER", 0);
        return counter;
    }
}