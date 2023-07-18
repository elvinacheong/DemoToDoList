package com.myapplicationdev.android.demotodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvToDoItem;
    ArrayList<ToDoItem> alToDoItem;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvToDoItem = findViewById(R.id.lv);
        alToDoItem = new ArrayList<>();

        ToDoItem item1 = new ToDoItem("Go home", Calendar.getInstance());

        alToDoItem.add(item1);

        adapter = new CustomAdapter(this, R.layout.row, alToDoItem);
        lvToDoItem.setAdapter(adapter);
    }
}