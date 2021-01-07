package ru.academy.project.presentors;


import java.util.List;

import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent;

public class Presentor {

    public void insertIntoDb (AppDatabase db, int counter, String name, String phone, String description){
        db.contragentDao().insert(new Contragent(counter, name, phone, description));
    }

    public void updateDb (AppDatabase db, int position, String name, String phone, String description){
        db.contragentDao().update(new Contragent(position, name, phone, description));
    }

    public List<Contragent> contragentList (AppDatabase db){
        List<Contragent> contragentList = db.contragentDao().getAll();
        return contragentList;
    }

    public void deleteFromDb (AppDatabase db,  List<Contragent> contragentList, int position){
        db.contragentDao().delete(contragentList.get(position));
    }
}
