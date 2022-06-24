package com.example.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "desc")
    private String desc;
    @ColumnInfo(name = "icon")
    private int icon;

    @PrimaryKey(autoGenerate = true)
    private int id;

    public User(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
