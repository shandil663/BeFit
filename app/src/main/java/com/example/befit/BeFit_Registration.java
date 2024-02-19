package com.example.befit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.jar.Attributes;

public class BeFit_Registration extends AppCompatActivity {
    EditText name1;
    EditText phone1;
    EditText email1;
    EditText password1;
  public  String m;
Button submit;
    FirebaseAuth mAuth;
    TextView textView;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent =new Intent(getApplicationContext(),BMI.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_fit_registration);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        mAuth=FirebaseAuth.getInstance();
//        ref= FirebaseDatabase.getInstance().getReference().child("User");
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        name1=findViewById(R.id.name);
        phone1=findViewById(R.id.phone);
        email1=findViewById(R.id.email);
        password1=findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        textView=findViewById(R.id.reg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit.startAnimation(animation);
                String email,password,name,phone;
                email=String.valueOf(email1.getText());
                password=String.valueOf(password1.getText());
                name=String.valueOf(name1.getText());
                phone=String.valueOf(phone1.getText());
//                String key=ref.push().getKey();
//                ref.child(key).child("Phone").setValue(phone);
//                ref.child(key).child("Name").setValue(name);
//HashMap hash=new HashMap();
//hash.put("Phone",phone);
//hash.put("Name",name);
//ref.setValue(hash);
//                HashMap hash=new HashMap();
//                hash.put("Name",name);
//                ref.setValue(hash);

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(BeFit_Registration.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(BeFit_Registration.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(BeFit_Registration.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(BeFit_Registration.this, "Enter Phone", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(BeFit_Registration.this, "Registered successfully.",
                                            Toast.LENGTH_SHORT).show();
                                    User  user = new User(name,phone);
                                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Registered Users");

                                    m=mAuth.getUid();
                                    ref.child(m).child("Name").setValue(user);
                                    Intent intent =new Intent(getApplicationContext(),Asking.class);
                                    intent.putExtra("uid",m);
                                    startActivity(intent);
                                    finish();

                                } else if (password.length()<6) {

                                    Toast.makeText(BeFit_Registration.this, "Authentication failed.\nPassword Should have minimum 6 characters",
                                            Toast.LENGTH_LONG).show();


                                } else {

                                    Toast.makeText(BeFit_Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }

}