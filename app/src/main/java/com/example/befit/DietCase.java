package com.example.befit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class DietCase extends AppCompatActivity {

    private RecyclerView recycle;
    public String NA,PH,cat,ag,wt,GH,HT,GOAL,DAY="DAY";
    //    public StringBuffer GOAL=new StringBuffer("None");
    private RecyclerView.Adapter adpt;
    private RecyclerView.LayoutManager manger;
    ProgressBar BAR;

    private FirebaseAuth Uauth;

    TextView text,text2,text3,text4,text5,text6,text7,Type,txtcm,txtyr,txtkg,alter2;
    Button work,diet;
    ImageButton setting;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_case);
//        Intent intent=getIntent();
//        DAY=intent.getStringExtra("day");
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("DAYNAME2"));

        work=findViewById(R.id.work1);
        Type=findViewById(R.id.type);
        text=findViewById(R.id.getname);
        text2=findViewById(R.id.getbmi);
        text3=findViewById(R.id.getcat);
        text4=findViewById(R.id.getage);
        text5=findViewById(R.id.getweight);
        text6=findViewById(R.id.getheight);
        text7=findViewById(R.id.getgender);
        BAR=findViewById(R.id.progressBar);
        txtcm=findViewById(R.id.cm1);
        txtyr=findViewById(R.id.Years1);
        txtkg=findViewById(R.id.Kilogram1);
        alter2=findViewById(R.id.alter2);


        getSupportActionBar().hide();
        Uauth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=Uauth.getCurrentUser();
        if(firebaseUser==null){
            Toast.makeText(this, "Data Not Available", Toast.LENGTH_SHORT).show();
        }
        else{
            ShowUser(firebaseUser);
            ShowUSerbmi(firebaseUser);
            ShowUsergoal(firebaseUser);
            GOAL="NONE";
        }
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BAR.setVisibility(View.VISIBLE);
                work.startAnimation(animation);
                Intent itent =new Intent(getApplicationContext(),Case1.class);
                startActivity(itent);
                finish();
            }
        });

    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            DAY = intent.getStringExtra("day1");
            if(GOAL.equals("Gain weight")){
                        Type.setText("Diet Plan");
                        if(DAY.equals("Monday")){
                            ArrayList<customcard> ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 Onion stuffed parantha\n1 Cup curd,Cashews\n4 Almonds,2 Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup mango shake","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup moong dal/Chicken\n1 Cup potato,caulifllower\n3 Chapatti,1/2 cup rice,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pomegranate juice\n2 Butter toasted bread","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup beans potato Veg\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Tuesday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Paneer filled besan cheela\nGreen chutney,1 cup curd\nCashews,Almonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Apple smoothie\nMaple syrup","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masoor dal,calocasia\n3 chapatti,1/2 cup rice\n1 Cup low curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup tomato soup,bread\n1 Cup aloo chaat","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup carrot peas vegetable\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Wednesday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup Veg. bread upma\n1 Cup milk,3 Cashews\nAlmonds and Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup ripe banana with\n2 Tea spoon ghee","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup rajma curry\n1 Cup spinach potato\n3 Chapatti,1/2 cup rice\n","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup vegetable juice,Upma","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup parwal vegetable\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Thursday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cucmber potato sandwich\n1 Tsp green chutney\n1 orange juice,Cashews\nAlmonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup sweet potato chaat\n1 Cup buttermilk ","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup white chana,fish curry\n3 Chapatti,1/2 cup rice","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup almond milk,banana","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Cauliflower potato Veg\n3 chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Friday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cup vegetable poha,Curd\nAlmonds,Cashews,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cups watermelon juice","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Chana dal,Bhindi vegetable\n3 Chapatti,1/2 cup rice","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Potato cheela,green chutney\n1 Cup sprouts salad","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup peas mushroom\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Saturday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 vegetable suji cheela\n1 Cup strawberry shake\nAlmonds,Cashews,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup coconut water\n1 Cup Pomegrate","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup soybean curry\n1 Cup mix dal,3 Chapatti\n1/2 Cup curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"4 Pc vegetable cutlets\n1 Cup fruit salad  ","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup karela vegetable\n3 Chaptti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(DAY.equals("Sunday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Egg brown bread sandwich\nGreen chutney, 1 Cup Milk\nCashews,Almonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup banana shake","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Arhar dal,1 Cup potato\ncurry,3 chapatti,1/2 cup rice\n1/2 Cup low fat curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup strawberry smoothie\n1 Cup vegetable poha","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup chicken curry\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}

            }

          else if(GOAL.equals("Loose Weight")){
                Type.setText("Diet Plan");
                if(DAY.equals("Monday")){
                    ArrayList<customcard> ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Beans and brown bread\nsandwich","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Mutter sabzi and\nMethi roti","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Vegetable or fruit salad\nwith liked seasoning","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Green chana and soya\nstuffed capsicum with\nmillet roti","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));

                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Tuesday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Paneer curry with Rice","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Sauted vegetable with\nminimal oil","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Any fruit intake except\nbanana","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Boiled broccoli and peas","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Wednesday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"2 bananas","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Brown rice and stewed\nchicken","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Suji noodles with\ntomato soup","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 glass of milk","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Thursday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Daliya or Poha","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Sabzi(peas,cauliflower,\ncabbage) Dal,Chawal\n1 Bowl of curd","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Sprouts salad use\nseasoning as liked","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Millet Pulao","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Friday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"3 brown rice idlis","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 roti,dal,brinjal sabzi","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"7 soaked almonds\n2 cashews,2 pistachio","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Mixed vegetable salad\nwith liked seasoning","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Saturday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Oat meal","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Hummus sandwich","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Tofu bhurji sandwich","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Zuchini chickpea burger","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Sunday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Bowl muesli with\nraspberry and banana","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Hard boiled egg with\nsalt and pepper","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 medium apple and\n1 Spoon peanut butter","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Dosa and sambhar with\ncoconut chutney","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}

            }
           else if(GOAL.equals("Normal Exercise")){
                Type.setText("Diet Plan");
                if(DAY.equals("Monday")){
                    ArrayList<customcard> ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup warm water\nwith cinnamon","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup oats  with skimmed\nmilk and walnuts (6 halves)","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup steamed green\npeas and carrot salad","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Thick methi/palak dal\n¾th Cup steamed rice","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Guava","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup curd,apple\nChia seeds smoothie\nPlain lassi","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th cup (paneer)\nDalia/millets pulao","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Tuesday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup veg dalia\nMillets upma,Paneer","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Apple,medium\nWalnut 8 halves","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup peas (matar)\ncottage (paneer) curry\n1 Roti No oil/no ghee","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup curd,apple\nChina seeds smoothie\nPlain lassi","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"2 Besan chila/dal dosa \ntomato, ginger chutney","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Wednesday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"2 Idli with 1/2 bowl sambar","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pomegranate,\nWalnut, sprouts salad","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup peas dalia pulao","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup hung curd,apple,\nChia seeds smoothie\nplain lassi","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"¼th Cup sautéed cottage\nCheese (paneer) with veg","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masala oats\n1 Cup vegetable soup","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Thursday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Omelette with 2 egg whites\nGrated vegetables","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Apple with boiled peas\nWalnuts salad","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Palak/methi paratha\nRaita (1 cup)","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Ginger lemon water \nGreen tea","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup tomato soup","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup masala Oats\nDalia and 200g grilled fish","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Friday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masala oats\nWalnuts","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup chickpea chaat","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pulao(Millets/Dalia\nwith vegetables)","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup apple,curd\nChia seeds smoothie","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 chapati (no oil)\n3/4th cup any vegetables","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Saturday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup poha\n1/4th lime wedge\n1 boiled egg white","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 orange,Walnut (8 halves)","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pulao(Millets/Dalia\nwith vegetables)","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 cup buttermilk with cumin\nChia seeds","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup sprouts chaat\nOnion Tomatoes\nchaat masala","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"200g Chicken sautéed\nBoiled vegetables,pepper","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Sunday")){
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"2 Moong (5 inch) cheelas \nGinger chutney","Breakfast",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"Pomegranate,carrot salad","Mid-Morning",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"2 Chapatti,100g low-fat\nChicken curry","Lunch",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup apple,curd\nChia seeds smoothie","Mid-Evening",R.drawable.diet,"Description"));
                    ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup fried rice with dalia\nEgg,100gm chicken","Dinner",R.drawable.diet,"Description"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(DietCase.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}

            }

        }
    };


    private void ShowUSerbmi(FirebaseUser firebaseUser) {
        String id=firebaseUser.getUid();
        DatabaseReference rt= FirebaseDatabase.getInstance().getReference("Registered Users");
        rt.child(id).child("BMI").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User get =snapshot.getValue(User.class);
                if(get !=null){;
                    PH=get.B1;
                    cat=get.C1;
                    ag=get.A1;
                    wt=get.W1;
                    HT=get.H1;
                    GH=get.G1;
                    text2.setText(PH);
                    text3.setText(cat);
                    text4.setText(ag);
                    text5.setText(wt);
                    text6.setText(HT);
                    text7.setText(GH);
                    text2.setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    text4.setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                    text6.setVisibility(View.VISIBLE);
                    text7.setVisibility(View.VISIBLE);
                    txtcm.setVisibility(View.VISIBLE);
                    txtcm.setText("Cm");
                    txtkg.setVisibility(View.VISIBLE);
                    txtkg.setText("Kg");
                    txtyr.setVisibility(View.VISIBLE);
                    txtyr.setText("Yr.");
                    work.setVisibility(View.VISIBLE);

                }
                else{
                    work.setVisibility(View.VISIBLE);
                    text.setPadding(385,30,385,30);
                    text.setTextSize(22);
                    alter2.setVisibility(View.VISIBLE);
                    alter2.setText("Your Diet Plan");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void ShowUser(@NonNull FirebaseUser firebaseUser) {
        String userid= firebaseUser.getUid();
        DatabaseReference refer=FirebaseDatabase.getInstance().getReference("Registered Users");
        refer.child(userid).child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User getuser =snapshot.getValue(User.class);
                if(getuser !=null){
                    NA=getuser.N1;
                    text.setText(NA);
                    text.setVisibility(View.VISIBLE);


                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ShowUsergoal(@NonNull FirebaseUser firebaseUser) {
        String goals= firebaseUser.getUid();
        DatabaseReference refery=FirebaseDatabase.getInstance().getReference("Registered Users");
        refery.child(goals).child("Goal").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User getusergoal =snapshot.getValue(User.class);

                if(getusergoal !=null){
//                    GOAL.append(getusergoal.Goal);
                    String name= Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
                    GOAL=getusergoal.Goal;
                    RecyclerView list=(RecyclerView) findViewById(R.id.list);
                    list.setLayoutManager(new LinearLayoutManager(DietCase.this,LinearLayoutManager.HORIZONTAL,false));
                    list.setAdapter(new horadpt(new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
                    if(GOAL.equals("Gain weight")){
                        Type.setText("Diet Plan");
                        if(name.equals("Monday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 Onion stuffed parantha\n1 Cup curd,Cashews\n4 Almonds,2 Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup mango shake","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup moong dal/Chicken\n1 Cup potato and caulifllower\n3 Chapatti,1/2 cup rice,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pomegranate juice\n2 Butter toasted bread","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup beans potato vegetable\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 Paneer filled besan cheela\nGreen chutney,1 cup curd\nCashews,Almonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Apple smoothie\nMaple syrup","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masoor dal,calocasia\n3 chapatti,1/2 cup rice\n1 Cup low curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup tomato soup with bread\n1 Cup aloo chaat","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup carrot peas vegetable\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup vegetable bread upma\n1 Cup milk,3 Cashews\nAlmonds and Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup ripe banana with\n2 Tea spoon ghee","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup rajma curry\n1 Cup spinach potato\n3 Chapatti,1/2 cup rice\n","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup vegetable juice,Upma","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup parwal vegetable\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cucmber potato sandwich\n1 Tsp green chutney\n1 orange juice,Cashews\nAlmonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup sweet potato chaat\n1 Cup buttermilk ","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup white chana,fish curry\n3 Chapatti,1/2 cup rice","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup almond milk,banana","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Cauliflower potato Veg\n3 chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cup vegetable poha,Curd\nAlmonds,Cashews,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Cups watermelon juice","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Chana dal,Bhindi vegetable\n3 Chapatti,1/2 cup rice","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Potato cheela,green chutney\n1 Cup sprouts salad","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup peas mushroom\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 vegetable suji cheela\n1 Cup strawberry shake\nAlmonds,Cashews,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup coconut water\n1 Cup Pomegrate","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup soybean curry\n1 Cup mix dal,3 Chapatti\n1/2 Cup curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"4 Pc vegetable cutlets\n1 Cup fruit salad  ","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup karela vegetable\n3 Chaptti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Egg brown bread sandwich\nGreen chutney, 1 Cup Milk\nCashews,Almonds,Walnuts","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup banana shake","Mid-Meal (11:00-11:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Arhar dal,1 Cup potato\ncurry,3 chapatti,1/2 cup rice\n1/2 Cup low fat curd,salad","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup strawberry smoothie\n1 Cup vegetable poha","Evening (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1.5 Cup chicken curry\n3 Chapatti,salad","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}

                   else if(GOAL.equals("Loose Weight")){
                        Type.setText("Diet Plan");
                        if(name.equals("Monday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Beans and brown bread\nsandwich","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Mutter sabzi and\nMethi roti","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Vegetable or fruit salad\nwith liked seasoning","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Green chana and soya\nstuffed capsicum with\nmillet roti","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Paneer curry with Rice","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Sauted vegetable with\nminimal oil","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Any fruit intake except\nbanana","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Boiled broccoli and peas","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 bananas","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Brown rice and stewed\nchicken","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Suji noodles with\ntomato soup","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 glass of milk","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Daliya or Poha","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Sabzi(peas,cauliflower,\ncabbage) Dal,Chawal\n1 Bowl of curd","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Sprouts salad use\nseasoning as liked","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Millet Pulao","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3 brown rice idlis","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 roti,dal,brinjal sabzi","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"7 soaked almonds\n2 cashews,2 pistachio","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Mixed vegetable salad\nwith liked seasoning","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Oat meal","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Hummus sandwich","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Tofu bhurji sandwich","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Zuchini chickpea burger","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Bowl muesli with\nraspberry and banana","Breakfast (8:00-8:30AM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Hard boiled egg with\nsalt and pepper","Lunch (2:00-2:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 medium apple and\n1 Spoon peanut butter","Snacks (4:00-4:30PM)",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Dosa and sambhar with\ncoconut chutney","Dinner (8:00-8:30PM)",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}
                    else if(GOAL.equals("Normal Exercise")){
                        Type.setText("Diet Plan");
                        if(name.equals("Monday")){
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup warm water\nwith cinnamon","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup oats  with skimmed\nmilk and walnuts (6 halves)","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup steamed green\npeas and carrot salad","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Thick methi/palak dal\n¾th Cup steamed rice","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Guava","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup curd,apple\nChia seeds smoothie\nPlain lassi","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th cup (paneer)\nDalia/millets pulao","Dinner",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup veg dalia\nMillets upma,Paneer","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Apple,medium\nWalnut 8 halves","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup peas (matar)\ncottage (paneer) curry\n1 Roti No oil/no ghee","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup curd,apple\nChina seeds smoothie\nPlain lassi","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Besan chila/dal dosa \ntomato, ginger chutney","Dinner",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Idli with 1/2 bowl sambar","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pomegranate,\nWalnut, sprouts salad","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup peas dalia pulao","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup hung curd,apple,\nChia seeds smoothie\nplain lassi","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"¼th Cup sautéed cottage\nCheese (paneer) with veg","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masala oats\n1 Cup vegetable soup","Dinner",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Omelette with 2 egg whites\nGrated vegetables","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Apple with boiled peas\nWalnuts salad","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Palak/methi paratha\nRaita (1 cup)","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Ginger lemon water \nGreen tea","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup tomato soup","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup masala Oats\nDalia and 200g grilled fish","Dinner",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup milk with turmeric\npowder and pepper powder","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup masala oats\nWalnuts","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup chickpea chaat","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pulao(Millets/Dalia\nwith vegetables)","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup apple,curd\nChia seeds smoothie","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 chapati (no oil)\n3/4th cup any vegetables","Dinner",R.drawable.diet,"Description"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup poha\n1/4th lime wedge\n1 boiled egg white","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 orange,Walnut (8 halves)","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup pulao(Millets/Dalia\nwith vegetables)","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 cup buttermilk with cumin\nChia seeds","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"3/4th Cup sprouts chaat\nOnion Tomatoes\nchaat masala","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"200g Chicken sautéed\nBoiled vegetables,pepper","Dinner",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Early Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Moong (5 inch) cheelas \nGinger chutney","Breakfast",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"Pomegranate,carrot salad","Mid-Morning",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"2 Chapatti,100g low-fat\nChicken curry","Lunch",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1/2 Cup masala tea\nCoffee without sugar","Tea Time",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup apple,curd\nChia seeds smoothie","Mid-Evening",R.drawable.diet,"Description"));
                            ExampleItem.add(new customcard(R.drawable.nutrition,"1 Cup fried rice with dalia\nEgg,100gm chicken","Dinner",R.drawable.diet,"Description"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(DietCase.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DietCase.this, "NOTHING", Toast.LENGTH_SHORT).show();
            }
        });
    }
}