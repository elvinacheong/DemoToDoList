package com.myapplicationdev.android.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myapplicationdev.android.demotodolist.R;
import com.myapplicationdev.android.demotodolist.ToDoItem;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoItemList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects) {
        super (context, resource, objects);

        parent_context = context;
        layout_id = resource;
        toDoItemList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvCalendar = rowView.findViewById(R.id.textViewCalendar);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = toDoItemList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());

        Calendar calendar = Calendar.getInstance();
        tvCalendar.setText(currentVersion.toString());

        return rowView;
    }
}
