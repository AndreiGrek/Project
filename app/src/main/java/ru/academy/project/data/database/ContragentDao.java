package ru.academy.project.data.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContragentDao {

    @Query("SELECT * FROM Contragent65")
    List<Contragent65> getAll();

    @Query("SELECT * FROM contragent73")
    List<Contragent73> getAllFrom73();

    @Query("SELECT * FROM Contragent65 WHERE id = :id")
    Contragent65 getById(long id);

    @Insert
    void insert(Contragent65 contragent65);

    @Insert
    void insert73(Contragent73 contragent);

    @Update
    void update(Contragent65 contragent65);

    @Update
    void update73(Contragent73 contragent);

    @Delete
    void delete(Contragent65 contragent65);

    @Delete
    void delete73(Contragent73 contragent);
}