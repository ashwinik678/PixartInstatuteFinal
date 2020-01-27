package com.example.pixartinstatutefinal.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.pixartinstatutefinal.Adapter.ProfileAdapterRecyclerView;
import com.example.pixartinstatutefinal.Model.ModelSignUp;
import com.example.pixartinstatutefinal.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    //    ListView listView;
//    List<ModelSignUp> list;

    Query databaseReference;
    RecyclerView recyclerView;
    List<ModelSignUp> list;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student").orderByChild("email").equalTo(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        // databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student").orderByChild("id").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());


        recyclerView = view.findViewById(R.id.recyclerview_profile);
        list = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list.clear();

                for (DataSnapshot userSnap : dataSnapshot.getChildren()) {
                    ModelSignUp user = userSnap.getValue(ModelSignUp.class);
                    list.add(user);
                }
                ProfileAdapterRecyclerView profileAdapter = new ProfileAdapterRecyclerView(getActivity(), list);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                recyclerView.setAdapter(profileAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        listView = view.findViewById(R.id.list_profile);
//
//        list = new ArrayList<>();
//        databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student").orderByChild("email").equalTo(FirebaseAuth.getInstance().getCurrentUser().getEmail());
//
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                list.clear();
//
//                for (DataSnapshot userSnap : dataSnapshot.getChildren()) {
//                    ModelSignUp user = userSnap.getValue(ModelSignUp.class);
//                    list.add(user);
//                }
//                ProfileAdapter profileAdapter = new ProfileAdapter(getActivity(), list);
//                listView.setAdapter(profileAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        return view;
    }

}
