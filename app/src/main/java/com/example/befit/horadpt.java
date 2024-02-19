package com.example.befit;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.Locale;

public class horadpt extends RecyclerView.Adapter<horadpt.Hori> {
    private String []items;
    public String textday;



    public horadpt(String[] items) {
        this.items = items;
    }
    @NonNull
    @Override
    public Hori onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf=LayoutInflater.from(parent.getContext());
        View view=inf.inflate(R.layout.itemlay,parent,false);
        return new Hori(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hori holder, int position) {
holder.txt.setText(items[position]);
String currentday= Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());

    if(holder.txt.getText().equals(currentday)){
        holder.txt.setTextColor(Color.WHITE);
        holder.txt.setBackgroundColor(Color.RED);
    }

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class Hori extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt;
        CardView card;
        public Hori(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            card=(CardView) itemView.findViewById(R.id.moncard);
            txt=(TextView) itemView.findViewById(R.id.Monday);
            txt.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           textday= txt.getText().toString();
           if(textday.equals("Monday")){
              txt.setTextColor(Color.WHITE);
               txt.setBackgroundColor(Color.RED);
               Intent intent=new Intent("DAYNAME");
               intent.putExtra("day",textday);
               Intent intent1=new Intent("DAYNAME2");
               intent1.putExtra("day1",textday);
               LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
               LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

           }
            if(textday.equals("Tuesday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }
            if(textday.equals("Wednesday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }
            if(textday.equals("Thursday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }
            if(textday.equals("Friday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }
            if(textday.equals("Saturday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }
            if(textday.equals("Sunday")){
                txt.setTextColor(Color.WHITE);
                txt.setBackgroundColor(Color.RED);
                Intent intent=new Intent("DAYNAME");
                intent.putExtra("day",textday);
                Intent intent1=new Intent("DAYNAME2");
                intent1.putExtra("day1",textday);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent1);
                LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);

            }

        }
    }


}
