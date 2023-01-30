package com.example.b_thames.activity;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.b_thames.R;
import com.example.b_thames.adapter.Slideradapter;

import com.example.b_thames.fragments.booking;
import com.example.b_thames.fragments.home;
import com.example.b_thames.fragments.profile;
import com.example.b_thames.fragments.shorts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.common.primitives.Shorts;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class home_screen extends AppCompatActivity {

    BottomNavigationView bnView;
//    Button logout;
//    Toolbar toolbar;
//    TextView welcome;
//    //    ImageSlider slider;
////    ViewFlipper flip;
////    final List<SlideModel> list = new ArrayList<>();
//    ArrayList<String> list = new ArrayList<String>();
//    List<String> imglist=new ArrayList<String>();
//    List<String> aclist=new ArrayList<String>();
//    SliderView sliderView,sliderView_ac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
//            getWindow().setNavigationBarColor(getResources().getColor(R.color.bnView));
//        }
        bnView = findViewById(R.id.bnView);

//        toolbar = findViewById(R.id.toolbar);
////        slider=findViewById(R.id.image_slider);
//        sliderView = findViewById(R.id.slider);
//        sliderView_ac = findViewById(R.id.sliderservices1);
//        welcome = findViewById(R.id.welcome_name);
////        flip = findViewById(R.id.flip);
//        setSupportActionBar(toolbar);
//        welcome.setText(" Welcome ");
//
//
//        FirebaseFirestore.getInstance().collection("thoughts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                for( QueryDocumentSnapshot ds:task.getResult()){
//                    list.add(ds.getString("url"));
//                }
//            }
//        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                imglist=list.subList(0,5);
//                Slideradapter adapter =new Slideradapter(home_screen.this,imglist);
//                sliderView.setSliderAdapter(adapter);
//                scrollefect(sliderView);
//                aclist=list.subList(5,9);
//                Slideradapter adapter_ac =new Slideradapter(home_screen.this,aclist);
//                sliderView_ac.setSliderAdapter(adapter_ac);
//                scrollefect(sliderView_ac);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(home_screen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void scrollefect(SliderView sliderView) {
//        sliderView.setScrollTimeInSec(2);
//        sliderView.setAutoCycle(true);

       bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               int id=item.getItemId();
              if(id==R.id.home){
                  loadFrag(new home());
              }
              else if(id==R.id.shorts){
                  loadFrag(new shorts());
              }
              else if(id==R.id.booking){
                  loadFrag(new booking());
              }
              else {
                  loadFrag(new profile());
              }
               return true;
           }
       });
    }

    private void loadFrag(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.frame,fragment);
        ft.commit();

    }


}
