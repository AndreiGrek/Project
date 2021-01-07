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
import ru.academy.project.activities.fragments.AddContragentFragment73;
import ru.academy.project.activities.fragments.EditContragentFragment;
import ru.academy.project.activities.fragments.EditContragentFragment73;
import ru.academy.project.data.ItemListAdapter73;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;
import ru.academy.project.data.ItemListAdapter;
import ru.academy.project.data.database.Contragent73;


public class Contragents73Activity extends AppCompatActivity {
    private ItemListAdapter73 itemListAdapter;
    final private String POSITION = "POSITION";
    private AppDatabase db;
    private List<Contragent73> itemList;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contragents73);

        db = AppDatabase.getInstance(this);
        itemList = db.contragentDao().getAllFrom73();
        RecyclerView recyclerView = findViewById(R.id.itemList);
        itemListAdapter = new ItemListAdapter73(itemList);
        recyclerView.setAdapter(itemListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        findViewById(R.id.addIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddContragentFragment73 addContragentFragment73 = new AddContragentFragment73();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, addContragentFragment73).commit();
            }
        });

        itemListAdapter.setOnItemClickListener(new ItemListAdapter73.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String name, String data) {
                description = itemList.get(position).getDescription();
                EditContragentFragment73 myFragment = new EditContragentFragment73(name, data, description, position);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, myFragment).commit();
            }
        });
    }

    @Override
    protected void onResume() {
        itemList = db.contragentDao().getAllFrom73();
        super.onResume();
    }
}