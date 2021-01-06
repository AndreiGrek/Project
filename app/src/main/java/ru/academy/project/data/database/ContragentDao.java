package ru.academy.project.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContragentDao {

    @Query("SELECT * FROM contragent")
    List<Contragent> getAll();

    @Query("SELECT * FROM contragent WHERE id = :id")
    Contragent getById(long id);

    @Insert
    void insert(Contragent contragent);

    @Update
    void update(Contragent contragent);

    @Delete
    void delete(Contragent contragent);
}