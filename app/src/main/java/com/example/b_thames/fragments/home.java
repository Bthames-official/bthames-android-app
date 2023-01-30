package com.example.b_thames.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b_thames.R;
import com.example.b_thames.activity.home_screen;
import com.example.b_thames.adapter.Slideradapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {
    Button logout;
   ProgressBar pbBar;
    String img_url;
    ImageView imgWelcome,ac,homeClean,carClean,plumbing,electrician;
    TextView welcomeWish;
    //    ImageSlider slider;
//    ViewFlipper flip;
//    final List<SlideModel> list = new ArrayList<>();
    ArrayList<String> list = new ArrayList<String>();
    List<String> imglist=new ArrayList<String>();
    List<String> aclist=new ArrayList<String>();
    SliderView sliderView,sliderView_ac;


    public home() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);

//       slider=findViewById(R.id.image_slider);

//        flip = findViewById(R.id.flip);
        sliderView =view.findViewById(R.id.slider);
        imgWelcome=view.findViewById(R.id.welcomeImg);
        ac=view.findViewById(R.id.ac);
        homeClean=view.findViewById(R.id.homeClean);
        carClean=view.findViewById(R.id.carClean);
        plumbing=view.findViewById(R.id.plumbing);
        electrician=view.findViewById(R.id.eletrician);
        pbBar=view.findViewById(R.id.pgBar);
        welcomeWish=view.findViewById(R.id.welcomeWish);
        sliderView_ac = view.findViewById(R.id.sliderservices1);
        pbBar.setVisibility(View.VISIBLE);

//        welcome.setText(" Welcome ");
        LocalTime myObj = LocalTime.now();
        int time=Integer.parseInt(((myObj.toString()).substring(0,2)));
        if(time<12){
            welcomeWish.setText("Good Morning");
        }
        else if(time>=12&&time<17){
            welcomeWish.setText("Good Afternoon");
        }
        else{
            welcomeWish.setText("Good Evening");
        }



        FirebaseFirestore.getInstance().collection("thoughts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for( QueryDocumentSnapshot ds:task.getResult()){
                    list.add(ds.getString("url"));
                }
            }
        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                pbBar.setVisibility(View.GONE);
                img_url= list.get(0);
                imglist=list.subList(6,11);
                Slideradapter adapter =new Slideradapter(getActivity(),imglist);
                sliderView.setSliderAdapter(adapter);
                scrollefect(sliderView);
                aclist=list.subList(11,15);
                Slideradapter adapter_ac =new Slideradapter(getActivity(),aclist);
                sliderView_ac.setSliderAdapter(adapter_ac);
                scrollefect(sliderView_ac);
                Picasso.get().load(img_url).fit().into(imgWelcome);
                Picasso.get().load(list.get(1)).fit().into(ac);
                Picasso.get().load(list.get(2)).fit().into(homeClean);
                Picasso.get().load(list.get(3)).fit().into(carClean);
                Picasso.get().load(list.get(4)).fit().into(plumbing);
                Picasso.get().load(list.get(5)).fit().into(electrician);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void scrollefect(SliderView sliderView) {
        sliderView.setScrollTimeInSec(2);
        sliderView.setAutoCycle(true);
    }
}