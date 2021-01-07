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

import java.util.List;

import ru.academy.project.R;
import ru.academy.project.activities.Contragents65Activity;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;
import ru.academy.project.presentors.Presentor;

public class EditContragentFragment extends Fragment {

    private String name, phone, description;
    private int position;
    private AppDatabase db;
    private List<Contragent> contragentList;
    private Presentor presentor;

    public EditContragentFragment(String name, String phone, String description, int position) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_edit_contragent, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final EditText editName = view.findViewById(R.id.editName);
        final EditText editData = view.findViewById(R.id.editPhone);
        final EditText editDescription = view.findViewById(R.id.editDescription);

        editName.setText(name);
        editData.setText(phone);
        editDescription.setText(description);
        db = AppDatabase.getInstance(this.getActivity());

        view.findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaved = new Intent(EditContragentFragment.this.getActivity(), Contragents65Activity.class);
                name = editName.getText().toString();
                phone = editData.getText().toString();
                description = editDescription.getText().toString();
                presentor = new Presentor();
                presentor.updateDb(db, position, name, phone, description );
                Toast.makeText(EditContragentFragment.this.getActivity(), R.string.editContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentSaved);
            }
        });

        view.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(EditContragentFragment.this.getActivity(), Contragents65Activity.class);
                presentor = new Presentor();
                contragentList = presentor.contragentList(db);
                presentor.deleteFromDb(db, contragentList, position);
                Toast.makeText(EditContragentFragment.this.getActivity(), R.string.deleteContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentDelete);
            }
        });
    }
}