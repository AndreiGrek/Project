package ru.academy.project.data.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contragent65")
public class Contragent65 {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String data;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Contragent65(String name, String data, String description) {
        this.name = name;
        this.data = data;
        this.description = description;
    }
}