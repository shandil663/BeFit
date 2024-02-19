package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class BeFit extends AppCompatActivity {
    Button button;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_fit);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        button=findViewById(R.id.logout);
        auth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.startAnimation(animation);
               FirebaseAuth.getInstance().signOut();
                Toast.makeText(BeFit.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}