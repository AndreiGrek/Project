package ru.academy.project.activities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.academy.project.R;
import ru.academy.project.activities.Contragents73Activity;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.presentors.Presentor;

public class AddContragentFragment73 extends Fragment {
    private String name, phone, description;
    private AppDatabase db;
    private Presentor presentor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_contragent, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final EditText editName = view.findViewById(R.id.addName);
        final EditText editData = view.findViewById(R.id.addPhone);
        final EditText editDescription = view.findViewById(R.id.addDescription);
        db = AppDatabase.getInstance(this.getActivity());

        view.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSave = new Intent(AddContragentFragment73.this.getActivity(), Contragents73Activity.class);
                name = editName.getText().toString();
                phone = editData.getText().toString();
                description = editDescription.getText().toString();
                presentor = new Presentor();
                presentor.insertIntoDb73(db, name, phone, description);
                Toast.makeText(AddContragentFragment73.this.getActivity(), R.string.addNewContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentSave);
                getActivity().getSupportFragmentManager().beginTransaction().remove(AddContragentFragment73.this).commit();
            }
        });
    }
}