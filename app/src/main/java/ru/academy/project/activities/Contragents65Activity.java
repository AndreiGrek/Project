package ru.academy.project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.academy.project.R;
import ru.academy.project.activities.fragments.AddContragentFragment65;
import ru.academy.project.activities.fragments.EditContragentFragment65;
import ru.academy.project.data.ItemListAdapter;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent65;

public class Contragents65Activity extends AppCompatActivity {
    private ItemListAdapter itemListAdapter;
    private AppDatabase db;
    private List<Contragent65> itemList;
    private Contragent65 contragent65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contragents65);

        db = AppDatabase.getInstance(this);
        itemList = db.contragentDao().getAll();
        RecyclerView recyclerView = findViewById(R.id.itemList);
        itemListAdapter = new ItemListAdapter(itemList);
        recyclerView.setAdapter(itemListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        findViewById(R.id.addIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContragentFragment65 addContragentFragment65 = new AddContragentFragment65();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, addContragentFragment65).commit();
            }
        });

        itemListAdapter.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String name, String data) {
                contragent65 = itemList.get(position);
                EditContragentFragment65 myFragment = new EditContragentFragment65(contragent65, position);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, myFragment).commit();
            }
        });

        findViewById(R.id.homeIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent toMainActivity = new Intent(Contragents65Activity.this, MainActivity.class);
            startActivity(toMainActivity);
            finish();
            }
        });
    }

    @Override
    protected void onResume() {
        itemList = db.contragentDao().getAll();
        super.onResume();
    }
}