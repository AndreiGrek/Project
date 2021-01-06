package ru.academy.project.data.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contragent {
    @PrimaryKey
    public int id;
    private String name;
    private String data;
    private String description;

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

    public Contragent(int id, String name, String data, String description) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.description = description;
    }
}