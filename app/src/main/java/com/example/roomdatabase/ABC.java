package com.example.roomdatabase;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ABC extends Fragment {
    EditText editTextUserName, editTextDes;
    Button btnAdd, btnIntent;

    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a_b_c, container, false);
        editTextUserName = view.findViewById(R.id.edt_name);
        editTextDes = view.findViewById(R.id.edt_desc);
        btnAdd = view.findViewById(R.id.btn_add);
        btnIntent = view.findViewById(R.id.btn_intent);
        userAdapter = new UserAdapter();
        userList = new ArrayList<>();
        userAdapter.setData(userList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Show.class);
                startActivity(intent);
            }
        });
    return view;
    }

    private void addUser() {
        String UserName = editTextUserName.getText().toString().trim();
        String UserDesc = editTextDes.getText().toString().trim();

        if(TextUtils.isEmpty(UserName) || TextUtils.isEmpty(UserDesc)){
            return;
        }
        User  user = new User(UserName, UserDesc);
        UserDatabase.getInstance(getContext()).userDAO().insertUser(user);
        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
        editTextDes.setText("");
        editTextUserName.setText("");
    }
}