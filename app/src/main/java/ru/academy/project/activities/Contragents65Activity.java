package ru.academy.project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.academy.project.R;
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
                Intent intent = new Intent(Contragents65Activity.this, AddContragentActivity.class);
                startActivity(intent);
            }
        });

        itemListAdapter.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String name, String data) {
                Intent intent2 = new Intent(Contragents65Activity.this, EditContragentActivity.class);
                intent2.putExtra(POSITION, position);
                intent2.putExtra("NAME", name);
                intent2.putExtra("DATA", data);
                description = itemList.get(position).getDescription();
                intent2.putExtra("DESCRIPTION", description);
                startActivity(intent2);
            }
        });
    }

    @Override
    protected void onResume() {
        itemList = db.contragentDao().getAll();
        super.onResume();
    }
}