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
import ru.academy.project.activities.Contragents73Activity;
import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent73;
import ru.academy.project.presentors.Presentor;

public class EditContragentFragment73 extends Fragment {

    private String name, phone, description;
    private int position;
    private AppDatabase db;
    private List<Contragent73> contragentList;
    private Presentor presentor;
    private Contragent73 contragent73;
    private int id;

    public EditContragentFragment73(Contragent73 contragent73, int position) {
        this.contragent73 = contragent73;
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

        editName.setText(contragent73.getName());
        editData.setText(contragent73.getData());
        editDescription.setText(contragent73.getDescription());
        db = AppDatabase.getInstance(this.getActivity());

        view.findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSaved = new Intent(EditContragentFragment73.this.getActivity(), Contragents73Activity.class);
                name = editName.getText().toString();
                phone = editData.getText().toString();
                description = editDescription.getText().toString();
                presentor = new Presentor();
                id = contragent73.getId();
                contragent73 = new Contragent73(name, phone, description);
                presentor.updateDb73(db, contragent73, id);
                Toast.makeText(EditContragentFragment73.this.getActivity(), R.string.editContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentSaved);
                getActivity().getSupportFragmentManager().beginTransaction().remove(EditContragentFragment73.this).commit();
            }
        });

        view.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(EditContragentFragment73.this.getActivity(), Contragents73Activity.class);
                presentor = new Presentor();
                contragentList = presentor.contragentList73(db);
                presentor.deleteFromDb73(db, contragentList, position);
                Toast.makeText(EditContragentFragment73.this.getActivity(), R.string.deleteContragent, Toast.LENGTH_SHORT).show();
                startActivity(intentDelete);
                getActivity().getSupportFragmentManager().beginTransaction().remove(EditContragentFragment73.this).commit();
            }
        });
    }
}