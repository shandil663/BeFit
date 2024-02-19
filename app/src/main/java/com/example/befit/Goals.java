package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Goals extends AppCompatActivity {
CardView card1,card2,card3;
String gls,glg,bl;
FirebaseAuth gl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        getSupportActionBar().hide();
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
         card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        Intent intent=getIntent();
        gls= intent.getStringExtra("G");
//        glg=intent.getStringExtra("Choosen");
//        bl=intent.getStringExtra("CHe");

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card1.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),Case1.class);
//                if(glg.equals("GOAL1")){
//                    intent.putExtra("GOALCH",glg);
//                }
//                else if (bl.equals("BMI")){
//                    intent.putExtra("GOALCH",bl);
//                }
                User usey=new User("Gain weight");
                DatabaseReference refy = FirebaseDatabase.getInstance().getReference("Registered Users");
                refy.child(gls).child("Goal").setValue(usey);
                startActivity(intent);
                finish();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card2.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                if(glg.equals("GOAL1")){
//                    intent.putExtra("GOALCH",glg);
//                }
//                else if (bl.equals("BMI")){
//                    intent.putExtra("GOALCH",bl);
//                }
                User usey=new User("Normal Exercise");
                DatabaseReference refy = FirebaseDatabase.getInstance().getReference("Registered Users");
                refy.child(gls).child("Goal").setValue(usey);
                startActivity(intent);
                finish();
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card3.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                if(glg.equals("GOAL1")){
//                    intent.putExtra("GOALCH",glg);
//                }
//                else if (bl.equals("BMI")){
//                    intent.putExtra("GOALCH",bl);
//                }
                User usey=new User("Loose Weight");
                DatabaseReference refy = FirebaseDatabase.getInstance().getReference("Registered Users");
                refy.child(gls).child("Goal").setValue(usey);
                startActivity(intent);
                finish();
            }
        });
    }
}