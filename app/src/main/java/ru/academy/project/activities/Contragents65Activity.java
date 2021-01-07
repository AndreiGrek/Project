package ru.academy.project.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.academy.project.R;
import ru.academy.project.activities.fragments.AddContragentFragment;
import ru.academy.project.activities.fragments.EditContragentFragment;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;
import ru.academy.project.data.ItemListAdapter;

public class Contragents65Activity extends AppCompatActivity {
    private ItemListAdapter itemListAdapter;
    final private String POSITION = "POSITION";
    private AppDatabase db;
    private List<Contragent> itemList;
    private String description;

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
                AddContragentFragment addContragentFragment = new AddContragentFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, addContragentFragment).commit();
            }
        });

        itemListAdapter.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String name, String data) {
                description = itemList.get(position).getDescription();
                EditContragentFragment myFragment = new EditContragentFragment(name, data, description, position);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, myFragment).commit();
            }
        });
    }

    @Override
    protected void onResume() {
        itemList = db.contragentDao().getAll();
        super.onResume();
    }
}