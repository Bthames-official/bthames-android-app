package com.example.b_thames.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.b_thames.R;
import com.example.b_thames.adapter.shorts_adapter;
import com.example.b_thames.model.shorts_model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class shorts extends Fragment {
    ViewPager2 viewPager;
    shorts_adapter adapter;

    public shorts() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shorts, container, false);
        viewPager=view.findViewById(R.id.viewPager);

        FirebaseRecyclerOptions<shorts_model> options =
                new FirebaseRecyclerOptions.Builder<shorts_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("shorts"), shorts_model.class)
                        .build();
        adapter=new shorts_adapter(options);
        viewPager.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}