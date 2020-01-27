package com.example.pixartinstatutefinal.Courses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pixartinstatutefinal.Adapter.PhotoshopAdapterRecyclerView;
import com.example.pixartinstatutefinal.Model.CourseModel;
import com.example.pixartinstatutefinal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Coreldraw extends AppCompatActivity {

    private Query databaseReference;
    private RecyclerView recyclerView;
    private List<CourseModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreldraw);

        databaseReference = FirebaseDatabase.getInstance().getReference("course").orderByChild("courseName").equalTo("Coreldraw");
        // databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student").orderByChild("id").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());


        recyclerView = findViewById(R.id.recyclerview_coreldraw);
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
                recyclerView.setLayoutManager(new GridLayoutManager(Coreldraw.this, 1));
                recyclerView.setAdapter(photoshopAdapterRecyclerView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
