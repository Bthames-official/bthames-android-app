package com.example.b_thames.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b_thames.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class otp_page extends AppCompatActivity {
    TextView welcome;
    EditText phone_number;
    Button submit;
    private final FirebaseAuth pAuth=FirebaseAuth.getInstance();
    @Override
    public void onStart() {
        super.onStart();
//         Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = pAuth.getCurrentUser();

        if(currentUser!=null){
          Intent intent = new Intent(this, home_screen.class);
            startActivity(intent);
            finish();
       }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otp_page);
        welcome=findViewById(R.id.textView);
        phone_number=findViewById(R.id.editTextPhone);
        welcome.animate().alpha(1).setDuration(2000);
        submit=findViewById(R.id.button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=phone_number.getText().toString();

                Pattern mPattern = Pattern.compile("^[6-9]{1}[0-9]{9}$");

                Matcher matcher = mPattern.matcher(phone);
                if(matcher.matches()) {
                    Intent intent = new Intent(otp_page.this, otp_verify.class);
                    intent.putExtra("mobile", "+91" + phone);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(otp_page.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}