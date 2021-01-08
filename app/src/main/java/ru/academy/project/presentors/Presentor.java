package ru.academy.project.presentors;


import java.util.List;

import ru.academy.project.data.database.AppDatabase;
import ru.academy.project.data.database.Contragent65;
import ru.academy.project.data.database.Contragent73;

public class Presentor {

    public void insertIntoDb(AppDatabase db, String name, String phone, String description) {
        db.contragentDao().insert(new Contragent65(name, phone, description));
    }

    public void insertIntoDb73(AppDatabase db, String name, String phone, String description) {
        db.contragentDao().insert73(new Contragent73(name, phone, description));
    }

    public void updateDb(AppDatabase db, Contragent65 contragent65, int id) {
        contragent65.setId(id);
        db.contragentDao().update(contragent65);
    }

    public void updateDb73(AppDatabase db, Contragent73 contragent, int id) {
        contragent.setId(id);
        db.contragentDao().update73(contragent);
    }

    public List<Contragent65> contragentList(AppDatabase db) {
        List<Contragent65> contragent65List = db.contragentDao().getAll();
        return contragent65List;
    }

    public List<Contragent73> contragentList73(AppDatabase db) {
        List<Contragent73> contragentList = db.contragentDao().getAllFrom73();
        return contragentList;
    }

    public void deleteFromDb(AppDatabase db, List<Contragent65> contragent65List, int position) {
        db.contragentDao().delete(contragent65List.get(position));
    }

    public void deleteFromDb73(AppDatabase db, List<Contragent73> contragentList, int position) {
        db.contragentDao().delete73(contragentList.get(position));
    }
}
