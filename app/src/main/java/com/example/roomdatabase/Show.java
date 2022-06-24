package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Show extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<User> userList;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        recyclerView = findViewById(R.id.recycleview);

        userAdapter = new UserAdapter();
        userList = new ArrayList<>();
        userAdapter.setData(userList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);

        userList = UserDatabase.getInstance(this).userDAO().getListUser();
        userAdapter.setData(userList);
    }
}