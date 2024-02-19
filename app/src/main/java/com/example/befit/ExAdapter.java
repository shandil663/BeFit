package com.example.befit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ExViewHolder> {
    private ArrayList<customcard>ITEMLIST;
    Context context;

    public static class ExViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
public ImageView image,image1;
public TextView text1,text2;
        final  Animation animation = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.bounce);
public String data;
        public ExViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.case1img);
            image1=itemView.findViewById(R.id.imageView5);
            text1=itemView.findViewById(R.id.ex);
            text2=itemView.findViewById(R.id.count);
            image1.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(itemView.getContext(), "Opening in Youtube", Toast.LENGTH_SHORT).show();
            image1.startAnimation(animation);
            data=text1.getText().toString();
           Intent intent=new Intent("Link");
           intent.putExtra("link",data);
            LocalBroadcastManager.getInstance(itemView.getContext()).sendBroadcast(intent);
        }




    }

public ExAdapter(ArrayList<customcard>ItemList,Context context){
        ITEMLIST=ItemList;
        this.context=context;
}
    @Override
    public ExViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
       ExViewHolder hld=new ExViewHolder(v);
       return hld;
    }

    @Override
    public void onBindViewHolder(@NonNull ExViewHolder holder, int position) {
customcard currentITem=ITEMLIST.get(position);
   holder.image.setImageResource(currentITem.getImagesrc());
   holder.text1.setText(currentITem.getExercise());
   holder.text2.setText(currentITem.getCount());
   holder.image1.setImageResource(currentITem.getImg2());
   holder.text1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           Intent intent=new Intent(context, Info.class);
           intent.putExtra("Imagename",currentITem.getImagesrc());
           intent.putExtra("Exname",currentITem.getExercise());
           intent.putExtra("desc",currentITem.getdesc());
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(intent);
       }
   });
    }

    @Override
    public int getItemCount() {
        return ITEMLIST.size();
    }



}
