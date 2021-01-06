package ru.academy.project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ru.academy.project.R;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;

public class EditContragentActivity extends AppCompatActivity {

    private String name, phone, description;
    private int position;
    private AppDatabase db;
    private List<Contragent> contragentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contragent);

        final EditText editName = findViewById(R.id.editName);
        final EditText editData = findViewById(R.id.editPhone);
        final EditText editDescription = findViewById(R.id.editDescription);

        Intent intentPosition = getIntent();
        position = intentPosition.getIntExtra("POSITION", 0);
        name = intentPosition.getStringExtra("NAME");
        phone = intentPosition.getStringExtra("DATA");
        description = intentPosition.getStringExtra("DESCRIPTION");
        editName.setHint(name);
        editData.setHint(phone);
        editDescription.setHint(description);
        db = AppDatabase.getInstance(this);

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaved = new Intent(EditContragentActivity.this, Contragents65Activity.class);
                name = editName.getText().toString();
                phone = editData.getText().toString();
                description = editData.getText().toString();
                db.contragentDao().update(new Contragent(position, name, phone, description));
                Toast.makeText(EditContragentActivity.this, R.string.editContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentSaved);
                finish();
            }
        });


        findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(EditContragentActivity.this, Contragents65Activity.class);
                contragentList = db.contragentDao().getAll();
                db.contragentDao().delete(contragentList.get(position));
                Toast.makeText(EditContragentActivity.this, R.string.deleteContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentDelete);
                finish();

            }
        });
    }
}