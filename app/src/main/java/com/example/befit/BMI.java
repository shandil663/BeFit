package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BMI extends AppCompatActivity {
    Button button;
    TextView counter , weightcount, agecount;
    ImageView minus,add,minusage,addage;
    SeekBar seek;
    CardView cardView,cardView4;
    Intent intent;
    ImageView male,female;
    int Age=19;
    FirebaseAuth Arthur;
    int Weight=50;
    int currentprogress;
    String progress1="170";
    String typeofuser="0";
    String weight1="50";
    String age1="19",bmi,k,CHO;

    float intheight;
    float intweight,intbmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        counter=findViewById(R.id.counter);
        weightcount=findViewById(R.id.weightcount);
        agecount=findViewById(R.id.agecount);
        minus=findViewById(R.id.minus);
        add=findViewById(R.id.add);
        addage=findViewById(R.id.addage);
        minusage=findViewById(R.id.minusage);
        seek=findViewById(R.id.seekBar2);
        cardView=findViewById(R.id.cardView);
        cardView4=findViewById(R.id.cardView4);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        button=findViewById(R.id.calbmi);


        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           male.setImageResource(R.drawable.malefocus);
           female.setImageResource(R.drawable.female);
           typeofuser="Male";
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setImageResource(R.drawable.femalefocus);
                male.setImageResource(R.drawable.male);
                typeofuser="Female";

            }
        });
        seek.setMax(300);
        seek.setProgress(150);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                progress1=String.valueOf(currentprogress);
                counter.setText(progress1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        addage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Age=Age+1;
                age1=String.valueOf(Age);
                agecount.setText(age1);
            }
        });

        minusage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Age=Age-1;
                age1=String.valueOf(Age);
                agecount.setText(age1);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Weight=Weight+1;
                weight1=String.valueOf(Weight);
                weightcount.setText(weight1);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Weight=Weight-1;
                weight1=String.valueOf(Weight);
                weightcount.setText(weight1);
            }
        });
        intent=getIntent();
        k=intent.getStringExtra("UID");
//        CHO=intent.getStringExtra("Choosen");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.startAnimation(animation);
                if(typeofuser.equals("0")){
                    Toast.makeText(BMI.this, "Select Gender", Toast.LENGTH_SHORT).show();
                } else if (progress1.equals("0")) {
                    Toast.makeText(BMI.this, "Choose Correct Height", Toast.LENGTH_SHORT).show();
                    
                } else if (Age<=0) {
                    Toast.makeText(BMI.this, "Enter correct Age", Toast.LENGTH_SHORT).show();
                    
                } else if (Weight<=0) {
                    Toast.makeText(BMI.this, "Enter correct  Weight", Toast.LENGTH_SHORT).show();

                }
                else {
                    intheight=Float.parseFloat(progress1);
                    intweight=Float.parseFloat(weight1);
                    intheight=intheight/100;
                    intbmi=intweight/(intheight*intheight);
                    bmi=Float.toString(intbmi);
                    if(intbmi<18.5){
                        String km="You are underweight";
                        User use= new User(bmi,weight1,age1,km,progress1,typeofuser);
                        DatabaseReference refer  = FirebaseDatabase.getInstance().getReference("Registered Users");
                        refer.child(k).child("BMI").setValue(use);

                    } else if (intbmi>=18.5&&intbmi<=24.9) {
                        String km="You are Normal";
                        User use= new User(bmi,weight1,age1,km,progress1,typeofuser);
                        DatabaseReference refer  = FirebaseDatabase.getInstance().getReference("Registered Users");
                        refer.child(k).child("BMI").setValue(use);
                    } else if (intbmi>=25.0&&intbmi<=29.9) {
                        String km="You are Heavyweight";
                        User use= new User(bmi,weight1,age1,km,progress1,typeofuser);
                        DatabaseReference refer  = FirebaseDatabase.getInstance().getReference("Registered Users");
                        refer.child(k).child("BMI").setValue(use);
                    }
                    else if (intbmi>=30.0) {
                        String km="You are Obese";
                        User use= new User(bmi,weight1,age1,km,progress1,typeofuser);
                        DatabaseReference refer  = FirebaseDatabase.getInstance().getReference("Registered Users");
                        refer.child(k).child("BMI").setValue(use);
                    }
                    Intent intent=new Intent(getApplicationContext(),resultbmi.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",progress1);
                    intent.putExtra("weight",weight1);
                    intent.putExtra("age",age1);
                    intent.putExtra("GL",k);
//                    intent.putExtra("CHOSE",CHO);
                    startActivity(intent);
                    finish();
                }



//                String km="You are underweight";
//                User use= new User(bmi,weight1,age1,km,progress1,typeofuser);
//                DatabaseReference refer  = FirebaseDatabase.getInstance().getReference("Registered Users");
//                 refer.child(k).child("BMI").setValue(use);


            }
        });
    }
}