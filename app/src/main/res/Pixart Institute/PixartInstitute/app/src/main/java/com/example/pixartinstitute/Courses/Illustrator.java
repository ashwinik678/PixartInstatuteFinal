package com.example.pixartinstitute.Courses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pixartinstitute.Adapter.PhotoshopAdapterRecyclerView;
import com.example.pixartinstitute.Model.CourseModel;
import com.example.pixartinstitute.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Illustrator extends AppCompatActivity {

    private Query databaseReference;
    private RecyclerView recyclerView;
    private List<CourseModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illustrator);

        databaseReference = FirebaseDatabase.getInstance().getReference("course").orderByChild("courseName").equalTo("Illustrator");
        // databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student").orderByChild("id").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());


        recyclerView = findViewById(R.id.recyclerview_illustrator);
        list = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list.clear();

                for (DataSnapshot userSnap : dataSnapshot.getChildren()) {
                    CourseModel user = userSnap.getValue(CourseModel.class);
                    list.add(user);
                }
                PhotoshopAdapterRecyclerView photoshopAdapterRecyclerView = new PhotoshopAdapterRecyclerView(getApplicationContext(), list);
                recyclerView.setLayoutManager(new GridLayoutManager(Illustrator.this, 1));
                recyclerView.setAdapter(photoshopAdapterRecyclerView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
