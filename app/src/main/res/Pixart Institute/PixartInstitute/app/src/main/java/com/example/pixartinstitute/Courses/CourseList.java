package com.example.pixartinstitute.Courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pixartinstitute.R;

public class CourseList extends AppCompatActivity {

    private ListView listView;
    private String string[] = {"Photoshop", "Illustrator", "Coreldraw", "InDesign", "inDesign", "AfterEffect", "Maya", "Autodesk", "K3D", "MovieMaker", "Cinema4D", "ZBrush"};
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        listView = findViewById(R.id.listOfCourse);
        //   arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, string);
        arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.listview_layout, string);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clsNames = string[position];

                try {
                    Class cls = Class.forName("com.example.pixartinstitute.Courses." + clsNames);
                    Intent intent = new Intent(CourseList.this, cls);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }


}
