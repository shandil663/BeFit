package com.example.befit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Info extends AppCompatActivity {
ImageView image;
TextView txt,DESC,exd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncorner));
        image=(ImageView) findViewById(R.id.infoimage);
        txt=(TextView) findViewById(R.id.infotxt);
        DESC=(TextView)findViewById(R.id.DESC);
        exd=(TextView)findViewById(R.id.infodesc);
        image.setImageResource(getIntent().getIntExtra("Imagename",0));
        txt.setText(getIntent().getStringExtra("Exname"));
        if(getIntent().getStringExtra("desc").equals("Description")){
            DESC.setVisibility(View.GONE);
            exd.setVisibility(View.GONE);

        }
        else{
        DESC.setText(getIntent().getStringExtra("desc"));

    }}
}