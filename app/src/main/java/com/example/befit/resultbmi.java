package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class resultbmi extends AppCompatActivity {
Button btn;
//FirebaseAuth Auther;
TextView bmires,bmicat,bmigender,todo;
Intent intent;
ImageView imageView;
static String bmi;
float intbmi;

String height,weight,age,gl,cho;
float intheight,intweight;
    //Testing
//    public static String getbmi(){
//        String BMI;
//        BMI=bmi;
//        return BMI;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultbmi);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        bmires=findViewById(R.id.bmires);
        bmicat=findViewById(R.id.cat);
        bmigender=findViewById(R.id.Gen);
        imageView=findViewById(R.id.tick);
        todo=findViewById(R.id.todo);

        intent =getIntent();
//        cho=intent.getStringExtra("CHOSE");
        gl=intent.getStringExtra("GL");
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");
        age=intent.getStringExtra("age");
        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);
        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);
        DecimalFormat df =new DecimalFormat("0.00");
        df.format(intbmi);
        bmi=Float.toString(intbmi);
        if(intbmi<18.5){

            bmicat.setText("You are underweight!");
            todo.setText("You Should Gain Weight!");
            todo.setTextColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        } else if (intbmi>=18.5&&intbmi<=24.9) {
            bmicat.setText("You are heavyweight! ");
            todo.setText("You Should Do Normal Workout");
            todo.setTextColor(getResources().getColor(R.color.green1,null));
            imageView.setImageResource(R.drawable.tick);
        } else if (intbmi>=25.0&&intbmi<=29.9) {
            bmicat.setText("You are Overweight!");
            todo.setText("You Should Loose Weight!");
            todo.setTextColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }
        else if (intbmi>=30.0) {
            bmicat.setText("You are Obese!");
            todo.setText("You Must Loose Weight!");
            todo.setTextColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }

        bmigender.setText(intent.getStringExtra("gender"));
        bmires.setText(bmi);


        //testing
     btn=findViewById(R.id.test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.startAnimation(animation);
                Intent inty=new Intent(getApplicationContext(),Goals.class);
                inty.putExtra("G",gl);
//                inty.putExtra("CHe",cho);
                startActivity(inty);
                finish();
            }
        });



    }
}