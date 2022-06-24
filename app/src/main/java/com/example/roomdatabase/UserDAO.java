package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);
    @Query("SELECT * FROM User")
    List<User> getListUser();

}
