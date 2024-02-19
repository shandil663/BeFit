package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Asking extends AppCompatActivity {
TextView chgoal;
String a;
Intent intent ;
TextView bmicl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        getSupportActionBar().hide();
        chgoal=findViewById(R.id.chgoal);
        bmicl=findViewById(R.id.bmicl);
        intent = getIntent();
        a=intent.getStringExtra("uid");
        chgoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chgoal.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),Goals.class);

                intent.putExtra("G",a);
                startActivity(intent);
                finish();
            }
        });

        bmicl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmicl.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),BMI.class);
                intent.putExtra("UID",a);
                startActivity(intent);
                finish();
            }
        });

    }
}