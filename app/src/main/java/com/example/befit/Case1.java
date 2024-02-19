package com.example.befit;


import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.Attributes;

public class Case1 extends AppCompatActivity {

private RecyclerView recycle;
    public String NA,PH,cat,ag,wt,GH,HT,GOAL,DAY="DAY",CHOSE,LINK;
//    public StringBuffer GOAL=new StringBuffer("None");
    private RecyclerView.Adapter adpt;

private RecyclerView.LayoutManager manger;

private FirebaseAuth Uauth;
ProgressBar bar;

TextView text,text2,text3,text4,text5,text6,text7,Type,txtcm,txtyr,txtkg,wait,alter;
Button work,diet;
ImageButton setting;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);
//Intent intentgoal=getIntent();
// CHOSE=intentgoal.getStringExtra("GOALCH");
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver1,
                new IntentFilter("DAYNAME"));
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessage,
                new IntentFilter("Link"));
                work=findViewById(R.id.work);
setting=findViewById(R.id.setting1);
Type=findViewById(R.id.type);
bar=findViewById(R.id.progressBar3);
wait=findViewById(R.id.wait);
        text=findViewById(R.id.getname);
        text2=findViewById(R.id.getbmi);
        text3=findViewById(R.id.getcat);
        text4=findViewById(R.id.getage);
        text5=findViewById(R.id.getweight);
        text6=findViewById(R.id.getheight);
        text7=findViewById(R.id.getgender);
        txtyr=findViewById(R.id.Years);
        txtcm=findViewById(R.id.cm);
        txtkg=findViewById(R.id.Kilogram);
        alter=findViewById(R.id.Alter);


        getSupportActionBar().hide();
        Uauth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=Uauth.getCurrentUser();
        if(firebaseUser==null){
            Toast.makeText(this, "Data Not Available", Toast.LENGTH_SHORT).show();
        }
        else {
            ShowUser(firebaseUser);
            ShowUSerbmi(firebaseUser);
            ShowUsergoal(firebaseUser);

            GOAL="NONE";
        }
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting.setBackgroundColor(Color.RED);
                Intent intent=new Intent(getApplicationContext(),BeFit.class);
                startActivity(intent);
                finish();
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.setVisibility(View.VISIBLE);
                work.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),DietCase.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public BroadcastReceiver mMessage =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          LINK=intent.getStringExtra("link");
          if(LINK.equals("Pull Ups")){
              gotoUrl("https://youtu.be/3YvfRx31xDE");
          }
            if(LINK.equals("Seated Cable Row")){
                gotoUrl("https://youtu.be/oyQAKfv59ww");
            }

            if(LINK.equals("Bench Press")){
                gotoUrl("https://youtu.be/4Y2ZdHCOXok");
            }
            if(LINK.equals("Decline press")){
                gotoUrl("https://youtu.be/7GmVSeVbVEs");
            }
            if(LINK.equals("Seated bench press")){
                gotoUrl("https://youtu.be/xUm0BiZCWlQ");
            }
            if(LINK.equals("Inclined Dumbell press")){
                gotoUrl("https://youtu.be/IP4oeKh1Sd4");
            }
            if(LINK.equals("Push ups")){
                gotoUrl("https://youtu.be/VQKqjHtY8jA");
            }
            if(LINK.equals("Machine T-bar rows")){
                gotoUrl("https://youtu.be/uUBbGZJrvbk");
            }
            if(LINK.equals("Crunches-Bicycle")){
                gotoUrl("https://youtube.com/shorts/6mXfejl7ERk?feature=share");
            }
            if(LINK.equals("Plank")){
                gotoUrl("https://youtu.be/BQu26ABuVS0");
            }
            if(LINK.equals("V Sit")){
                gotoUrl("https://youtu.be/EN4npQCabIw");
            }
            if(LINK.equals("Side Plank")){
                gotoUrl("https://youtu.be/rCxF2nG9vQ0");
            }
            if(LINK.equals("Seated Dumbell Press")){
                gotoUrl("https://youtu.be/b5JzUH8gsOg");
            }

            if(LINK.equals("Single Arm Cable Front")){
                gotoUrl("https://youtube.com/shorts/IIz_2WGzZ7U?feature=share");
            }

            if(LINK.equals("Arnold Press")){
                gotoUrl("https://youtu.be/6Z15_WdXmVw");
            }

            if(LINK.equals("Lateral Raises")){
                gotoUrl("https://youtube.com/shorts/G-piLwLu0d4?feature=share");
            }

            if(LINK.equals("Reverse flies")){
                gotoUrl("https://youtube.com/shorts/-_hx_2fp_Jw?feature=share");
            }
            if(LINK.equals("Calf Raises")){
                gotoUrl("https://youtu.be/eMTy3qylqnE");
            }

            if(LINK.equals("Leg Press")){
                gotoUrl("https://youtu.be/b5EFGXP7XH8");
            }

            if(LINK.equals("Leg Extension")){
                gotoUrl("https://youtu.be/PQRY75OY2TY");
            }

            if(LINK.equals("Weighted Lunges")){
                gotoUrl("https://youtu.be/wrwwXE_x-pQ");
            }

            if(LINK.equals("Squats")){
                gotoUrl("https://youtube.com/shorts/quwVwXQfwpc?feature=share");
            }
            if(LINK.equals("Weighted Squats")){
                gotoUrl("https://youtu.be/gcNh17Ckjgg");
            }
            if(LINK.equals("Box Squats")){
                gotoUrl("https://youtu.be/nBc_2Jyp3tM");
            }

            if(LINK.equals("Romanion Dead Lift")){
                gotoUrl("https://youtube.com/shorts/5rIqP63yWFg?feature=share");
            }

            if(LINK.equals("Glute bridge")){
                gotoUrl("https://youtu.be/OUgsJ8-Vi0E");
            }

            if(LINK.equals("Squats")){
                gotoUrl("https://youtube.com/shorts/LF4zb2SYWjQ?feature=share");
            }

            if(LINK.equals("Hip Extension")){
                gotoUrl("https://youtu.be/6oQvl-loqko");
            }

            if(LINK.equals("Cable Hammer Curl")){
                gotoUrl("https://youtu.be/XSy0cRc-yYQ");
            }

            if(LINK.equals("Diamond Pushups")){
                gotoUrl("https://youtube.com/shorts/ERyWPWWv-pg?feature=share");
            }

            if(LINK.equals("Tricep Dumbell Kickback")){
                gotoUrl("https://youtube.com/shorts/F0hRXsCylig?feature=share");
            }

            if(LINK.equals("Hammer Curl")){
                gotoUrl("https://youtu.be/TwD-YGVP4Bk");
            }

            if(LINK.equals("Tricep Push Down")){
                gotoUrl("https://youtube.com/shorts/ymsc7XYAK2E?feature=share");
            }
            if(LINK.equals("Push Down Workout")){
                gotoUrl("https://youtu.be/coa5cmsaqiw");
            }
            if(LINK.equals("Hurray! Enjoy")){
                gotoUrl("https://www.youtube.com/watch?v=hUWGCv_eOZM&list=PLVNocu2A1SAAgwy9JSXM7k3IoKiuqsTQx");
            }
            if(LINK.equals("High-Intensity Group Fitness\nClass")){
                gotoUrl("https://youtu.be/lqS77csIHTY");
            }
            if(LINK.equals("12,000")){
                gotoUrl("https://youtu.be/DzSU2FiFKTM");
            }
            if(LINK.equals("Moderate pace jog")){
                gotoUrl("https://youtu.be/9L2b2khySLE");
            }
            if(LINK.equals("Full-out sprint")){
                gotoUrl("https://youtu.be/-Ot-dP1xST4");
            }

            if(LINK.equals("Lying Isometric Y")){
                gotoUrl("https://youtube.com/shorts/qDikq9jXb9c?feature=share");
            }
            if(LINK.equals("Dumbbell Row")){
                gotoUrl("https://youtu.be/roCP6wCXPqo");
            }
            if(LINK.equals("Dumbbell Bench Press")){
                gotoUrl("https://youtu.be/QsYre__-aro");
            }
            if(LINK.equals("Bodyweight Squats")){
                gotoUrl("https://youtu.be/HFnSsLIB7a4");
            }
            if(LINK.equals("Pistol squat")){
                gotoUrl("https://youtu.be/vq5-vdgJc0I");
            }
            if(LINK.equals("Jump squat")){
                gotoUrl("https://youtube.com/shorts/nVNrHBwMBGg?feature=share");
            }
            if(LINK.equals("Deadlift")){
                gotoUrl("https://youtube.com/shorts/vfKwjT5-86k?feature=share");
            }
            if(LINK.equals("Leg press")){
                gotoUrl("https://youtu.be/b5EFGXP7XH8");
            }
            if(LINK.equals("Split squat")){
                gotoUrl("https://youtu.be/SGHnCftrZkA");
            }
            if(LINK.equals("Bench press")){
                gotoUrl("https://youtube.com/shorts/i-gLOirnPaU?feature=share");
            }
            if(LINK.equals("Dumbbell floor press")){
                gotoUrl("https://youtu.be/uUGDRwge4F8");
            }
            if(LINK.equals("Tricep dips")){
                gotoUrl("https://youtube.com/shorts/Rp0Qfp4GPho?feature=share");
            }
            if(LINK.equals("Bicep curl")){
                gotoUrl("https://youtu.be/ykJmrZ5v0Oo");
            }
            if(LINK.equals("Pushups")){
                gotoUrl("https://youtube.com/shorts/y7PBQ2fYbxY?feature=share");
            }
            if(LINK.equals("Tricep extensions")){
                gotoUrl("https://youtube.com/shorts/4lWSTusBcmw?feature=share");
            }
            if(LINK.equals("Lateral lunge")){
                gotoUrl("https://youtu.be/gwWv7aPcD88");
            }
            if(LINK.equals("One leg deadlift")){
                gotoUrl("https://youtu.be/sZXQqvrR_F8");
            }
            if(LINK.equals("Hipthrust")){
                gotoUrl("https://youtube.com/shorts/Yhm42i9t9bY?feature=share");
            }
            if(LINK.equals("Step ups")){
                gotoUrl("https://youtube.com/shorts/wOoGczWEUoE?feature=share");
            }
            if(LINK.equals("Jumping squat")){
                gotoUrl("https://youtu.be/roCP6wCXPqo");
            }
            if(LINK.equals("Kettleball Swing")){
                gotoUrl("https://youtube.com/shorts/WM8g4Mlu5Zs?feature=share");
            }
            if(LINK.equals("Lateral Raise(Partials)")){
                gotoUrl("https://youtube.com/shorts/p_d9AsZFlC8?feature=share");
            }
            if(LINK.equals("Weight Plate Front Raise")){
                gotoUrl("https://youtu.be/v7tac1hXOfU");
            }
            if(LINK.equals("Single arm cable\nlateral raise")){
                gotoUrl("https://youtube.com/shorts/p_d9AsZFlC8?feature=share");
            }
            if(LINK.equals("Cable face pull")){
                gotoUrl("https://youtu.be/eIq5CB9JfKE");
            }
            if(LINK.equals("Shoulder Press")){
                gotoUrl("https://youtu.be/qEwKCR5JCog");
            }
            if(LINK.equals("Dumbell Lateral Raise")){
                gotoUrl("https://youtu.be/3VcKaXpzqRo");
            }
            if(LINK.equals("Military lift")){
                gotoUrl("https://youtu.be/2yjwXTZQDDI");
            }
            if(LINK.equals("Mountain Climbers")){
                gotoUrl("https://youtu.be/De3Gl-nC7IQ");
            }
            if(LINK.equals("Reverse Crunch")){
                gotoUrl("https://youtu.be/hyv14e2QDq0");
            }
            if(LINK.equals("Situps")){
                gotoUrl("https://youtube.com/shorts/gI4a1n4eBgw?feature=share");
            }
            if(LINK.equals("Leg Raise")){
                gotoUrl("https://youtu.be/gobteD5GWkE");
            }
            if(LINK.equals("Russian Twist")){
                gotoUrl("https://youtu.be/mGiKe6CYWss");
            }
            if(LINK.equals("Pull up using resistance band")){
                gotoUrl("https://youtube.com/shorts/3kPllU-sBvQ?feature=share");
            }
            if(LINK.equals("Barbell Deadlift")){
                gotoUrl("https://youtube.com/shorts/vfKwjT5-86k?feature=share");
            }
            if(LINK.equals("Hyperextension")){
                gotoUrl("https://youtube.com/shorts/EBui4Bt5N7o?feature=share");
            }
            if(LINK.equals("T bar row")){
                gotoUrl("https://youtube.com/shorts/QobNRRHGHsw?feature=share");
            }
            if(LINK.equals("Bent over row")){
                gotoUrl("https://youtu.be/FWJR5Ve8bnQ");
            }
            if(LINK.equals("Seated cable row")){
                gotoUrl("https://youtube.com/shorts/K5RzNeeJwFI?feature=share");
            }










        }
    };

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public BroadcastReceiver mMessageReceiver1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            DAY = intent.getStringExtra("day");
            if(GOAL.equals("Gain weight")){
                if(DAY.equals("Monday")){
                    Type.setText("Chest Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bench Press","Do 3 sets",R.drawable.youtube,"The bench press is a compound exercise that targets the muscles of the upper body."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Decline press","Do 3 sets",R.drawable.youtube,"In a decline bench press, the bench is set to 15 to 30 degrees on a decline. This angle places your upper body on a downward slope, which activates the lower pectoral muscles as you push weights away from your body."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Seated bench press","Do 3 sets",R.drawable.youtube,"The seated chest press is a fixed weight machine that replicates the movement of a bench press in a seated position. Using the seated chest press works the pectorals, deltoids, and triceps."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Inclined Dumbell press","Do 3 sets",R.drawable.youtube,"The incline dumbbell press is a free weight exercise designed to target the chest, shoulders, and triceps, independently hitting each side of the body."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Push ups","Do 5 sets",R.drawable.youtube,"The push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                    adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Tuesday")){

                    Type.setText("Back And Core");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Pull Ups","15 reps",R.drawable.youtube,"A pullup is a challenging upper body exercise where you grip an overhead bar and lift your body until your chin is above that bar."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Seated Cable Row","12 reps",R.drawable.youtube,"A seated cable row is a compound exercise that utilizes a weighted horizontal cable row machine to work muscle groups in your back and arms."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Machine T-bar rows","12 reps",R.drawable.youtube,"The machine t-bar row is a variation of the bent over row and an exercise used to build back muscle and strength."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Crunches-Bicycle","10 minutes",R.drawable.youtube,"The bicycle crunch is a bodyweight exercise that activates your core muscles. Practice bicycle crunches by lying flat with your lower back pressing into an exercise mat."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Plank","3 Sets 60 Second hold",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"V Sit","45 Seconds 3 Sets",R.drawable.youtube,"The V-sit ab exercise builds core strength by working multiple areas of the core at the same time, while also challenging your balance"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Side Plank","3 sets 60 Seconds each",R.drawable.youtube,"Lie on your side with your knees bent, and prop your upper body up on your elbow. Raise your hips off the floor, and hold for 6 seconds. Rest for 10 seconds."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                    adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                            if(DAY.equals("Wednesday")){

                                Type.setText("Shoulder Workout");
                                Type.setVisibility(View.VISIBLE);
                                ArrayList<customcard>ExampleItem =new ArrayList<>();
                                ExampleItem.add(new customcard(R.drawable.calendar,"Seated Dumbell Press","3 sets 15,12,10 reps",R.drawable.youtube,"The move involves pressing two dumbbells above the head and targets the deltoids and triceps, with further engagement from the upper chest and traps."));
                                ExampleItem.add(new customcard(R.drawable.calendar,"Single Arm Cable Front","Each side 3 sets",R.drawable.youtube,"While maintaining the torso stationary (no swinging), lift the left arm to the front with a slight bend on the elbow and the palms of the hand always faces down."));
                                ExampleItem.add(new customcard(R.drawable.calendar,"Arnold Press","12 reps",R.drawable.youtube,"The Arnold presses is defined by a wrist rotation movement that ends when your palms face forward at the top of the press."));
                                ExampleItem.add(new customcard(R.drawable.calendar,"Lateral Raises","10 reps",R.drawable.youtube,"A lateral raise is a strength training shoulder exercise characterized by lifting a pair of dumbbells away from your body in an external rotation."));
                                ExampleItem.add(new customcard(R.drawable.calendar,"Reverse flies","Hold for 30 seconds",R.drawable.youtube,"The reverse fly is a resistance exercise that works the rear shoulders and major muscles of the upper back."));
                                recycle=findViewById(R.id.view);
                                recycle.setHasFixedSize(true);
                                manger=new LinearLayoutManager(Case1.this);
                                adpt=new ExAdapter(ExampleItem,getApplicationContext());
                                recycle.setLayoutManager(manger);
                                recycle.setAdapter(adpt);}
                if(DAY.equals("Thursday")){

                    Type.setText("Legs Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Calf Raises","15 reps",R.drawable.youtube,"Campbell: To do a calf raise with dumbbells, hold a dumbbell in each hand and stand with your feet about shoulder-width apart."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Squats","12 reps",R.drawable.youtube,"An exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Weighted Squats","12 reps",R.drawable.youtube,"Stand with feet hip-width apart, holding a heavy dumbbell or kettlebell in front of chest with both hands, elbows pointing down."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Weighted Lunges","Hold for 30  seconds",R.drawable.youtube,"Perform dumbbell lunges by holding a dumbbell in each hand as you take a big step forward and lower yourself until your front leg and back leg are both at nearly a 90-degree angle"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Leg Extension","Hold for 30 seconds",R.drawable.youtube,"You sit on the machine with a weighted pad on top of your lower legs. Then you use your quads to repeatedly extend your knees and lift your lower legs."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Leg Press","3X, Rest 1 minute b/w ",R.drawable.youtube,"Leg presses are seated exercises done on a leg press machine To start, sit with your back against a padded backrest and your feet on two large footrests. Your knees are bent to start the exercise."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                    adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Friday")){

                    Type.setText("Biceps And Triceps");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Push Down Workout","3 Sets 15,12,12 reps",R.drawable.youtube,"A push-down is a strength training exercise used for strengthening the triceps muscles in the back of the arm. "));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Tricep Push Down","3 Sets 15,12,12 reps",R.drawable.youtube,"The tricep pushdown is one of the best exercises for tricep development. While the versatile upper-body workout is usually done on a cable machine (a fixture at most gyms)"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hammer Curl","3 Sets 15,12,12 reps",R.drawable.youtube,"Hammer curls are biceps curls performed with your hands facing each other. They're beneficial to add mass to your arms and can help focus more attention on the short head of the biceps."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Tricep Dumbell Kickback","3 Sets 15,12,12 reps",R.drawable.youtube,"Start with dumbbells that are 5 to 10 pounds each and gradually increase the weight as you gain strength. Substitute soup cans or water bottles if you don’t have weights."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Diamond Pushups","3 Sets 15,12,12 reps",R.drawable.youtube,"Diamond push-ups, also known as triangle push-ups,Practice diamond push-ups by bringing your hands close together to form a diamond or triangle shape below your chest."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Cable Hammer Curl","3 Sets 15,12,12 reps",R.drawable.youtube,"The hammer curl may help add mass to your arms because the grip positioning often allows you to lift heavier weight. As a result, it’s a good exercise to build strength in all three muscles that bend your elbow"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Saturday")){

                    Type.setText("Glutes Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hip Extension","15 reps",R.drawable.youtube,"Hip extension occurs when you extend or “open” your hip joint so that the angle between your pelvis and thigh increases."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Squats","Close Legged,Weighted,Wide Legged",R.drawable.youtube,"An exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Glute bridge","45 Second Hold 3 Sets",R.drawable.youtube,"A glute bridge is a physical exercise that helps to strengthen the gluteus muscles (located in your buttocks) and hamstrings."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Romanion Dead Lift","Weight as per Strength",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Box Squats","Hold for 30 seconds",R.drawable.youtube,"The box squat is exactly like a standard squat, except that there is a dedicated pause at the bottom of the movement."));

                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Sunday")){

                    Type.setText("Rest Day");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}

            }

            else if(GOAL.equals("Loose Weight")){
                if(DAY.equals("Monday")){
                    Type.setText("Total-Body Strength Training");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Tuesday")){

                    Type.setText("Sprint Intervals");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Full-out sprint","30 seconds",R.drawable.youtube,"Sprinting is running over a short distance at the top-most speed of the body in a limited period of time. It is used in many sports that incorporate running, typically as a way of quickly reaching a target or goal, or avoiding or catching an opponent"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Moderate pace jog","60 seconds",R.drawable.youtube,"Jogging is slower and less intense than running. The main differences are pace and effort. One definition of jogging speed is 4 to 6 miles per hour (mph), while running can be defined as 6 mph or more."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Do Above Exercises","12 Times",R.drawable.youtube,"Repeat previous Exercises 12 times as Specified."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Wednesday")){

                    Type.setText("Foam Rolling");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"12,000","Steps",R.drawable.youtube,"Perform Foam Rolling And then Complete 12 Thousand Steps."));

                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Thursday")){

                    Type.setText("Total-Body Strength Training");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Friday")){

                    Type.setText("High Intensity Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"High-Intensity Group\nFitness Class","Follow Youtube",R.drawable.youtube,"In this Workout You Should Follow the instruction provided in the Video on youtube."));

                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Saturday")){

                    Type.setText("Total-Body Strength Training");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                    recycle=findViewById(R.id.view);

                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Sunday")){
                    Type.setText("Rest Day");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}

            }
           else  if(GOAL.equals("Normal Exercise")){
                if(DAY.equals("Monday")){
                    Type.setText("Leg Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Calf raises","15 reps 3 sets",R.drawable.youtube,"To do a calf raise with dumbbells, hold a dumbbell in each hand and stand with your feet about shoulder-width apart. Let your arms hang straight below your shoulders"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Split squat","20 reps each\nleg 2 sets each",R.drawable.youtube,"A split squat is a lower body exercise that works one leg at a time. Your legs are split with one leg in front of you and the other behind you on an elevated surface like a bench"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Leg press","15 reps 3 sets each",R.drawable.youtube,"Leg presses are seated exercises done on a leg press machine. To start, sit with your back against a padded backrest and your feet on two large footrests."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Deadlift","10 reps comfortable\nweight 4 sets",R.drawable.youtube,"The deadlift exercise is a relatively simple exercise to perform, a weight is lifted from a resting position on the floor to an upright position"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Jump squat","20 reps 3 sets each",R.drawable.youtube,"Stand with feet shoulder width and knees slightly bent. Bend your knees and descend to a full squat position."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Pistol squat","10 reps each leg 3 sets ",R.drawable.youtube,"Pistol squats are single-legged squats. You perform them with one leg and both arms extended out in front of you."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Tuesday")){

                    Type.setText("Arms Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Tricep extensions","15 reps",R.drawable.youtube," To do a triceps extension, lie on your back with a dumbbell in your hand. Point your upper arm toward the ceiling, with your elbow bent to 90 degrees"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bicep curl","15 reps 3 sets each",R.drawable.youtube,"To do a biceps curl with a dumbbell, hold a dumbbell with your palm facing upward. Slowly curl the weight up by bending your elbow, keeping your elbow close to your body"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Pushups","10 reps each\nDifferent variations",R.drawable.youtube,"The push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Tricep dips","15 reps 3 sets ",R.drawable.youtube,"Stand facing away from a bench, grab it with both hands at shoulder-width. Extend your legs out in front of you."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell floor press","15,12,10 reps\n3 sets total",R.drawable.youtube,"Press the weights to full extension by contracting your triceps and chest"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bench press","15 reps 3 sets",R.drawable.youtube,"The bench press is a compound exercise that targets the muscles of the upper body."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Wednesday")){

                    Type.setText("Glutes Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Romanian deadlift","15 reps 3 sets",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Kettleball Swing","15 reps 3 sets",R.drawable.youtube,"It involves moving the bell in a pendulum motion from between the knees to anywhere between eye level to fully overhead and can be performed either two-handed or using one hand"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Jumping squat","20 reps 3 sets",R.drawable.youtube,"Stand with feet shoulder width and knees slightly bent. Bend your knees and descend to a full squat position."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Step ups","20 reps 3 sets",R.drawable.youtube,"Pushing primarily through your lead foot, lift your body up onto the step. Then step backward to the starting position."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hipthrust","15 reps 3 sets",R.drawable.youtube,"A hip thrust, also called a hip thruster, is a lower body exercise that specifically activates your gluteal muscles, including the gluteus maximus, gluteus medius, and gluteus minimus"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"One leg deadlift","15 reps 3 sets",R.drawable.youtube,"The single-leg deadlift (SLDL) is an exercise characterized by a forward hip-hinge movement while lifting one leg off the ground and extending it backwards"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Lateral lunge","15,12,10 reps\neach leg 3 sets ",R.drawable.youtube,"A lateral lunge, also known as a side lunge, is a bodyweight exercise that works multiple muscle groups throughout your lower body, including your quadriceps, abductors, glutes, and hamstrings"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Thursday")){

                    Type.setText("Shoulder Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Military lift","12 reps 3 sets",R.drawable.youtube,"The basic exercise is simple. You start with the barbell resting on your collarbone, around shoulder height"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Dumbell Lateral Raise","12 reps 3 sets",R.drawable.youtube,"Grab a set of dumbbells and stand straight. 2. With your palms facing down, lift the dumbbells and raise your arms out to the sides"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Shoulder Press","12 reps 3 sets",R.drawable.youtube,"The overhead press, also known as the shoulder press or military press, is an upper-body weight training exercise in which the trainee presses a weight overhead while seated or standing"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Cable face pull","15 reps 3 sets",R.drawable.youtube,"Stand facing a cable pulley gripping the ends of the rope attachment in each hand."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Single arm cable\nlateral raise","15 reps 3 sets",R.drawable.youtube,"Position a cable at the lowest position possible and attach a single handle. Reach across your body and grab the handle with a neutral grip"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Weight Plate Front Raise","15 reps 3 sets",R.drawable.youtube,"The plate front raise is a variation of the dumbbell front raise where the lifter holds a weight plate between two hands, rather than using a dumbbell, barbell, or other weight."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Lateral Raise(Partials)","15 reps 3 sets",R.drawable.youtube,"Take a deep breath and raise the dumbbells to roughly 45 degrees using a neutral grip (palms facing in). "));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Friday")){

                    Type.setText("Full ABS");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bicycle Crunches","20,23,30 reps,2 sets",R.drawable.youtube,"Raise your knees to a 90-degree angle and alternate extending your legs as if pedaling a bike. Twist your body to touch your elbow to the opposite knee with each pedal motion"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Russian Twist","20 reps 3 sets",R.drawable.youtube,"Russian twists are a great core exercise. This move works your obliques while also targeting your shoulders and hips"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Plank","1 min hold 3 sets",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Leg Raise","20 reps 3 sets",R.drawable.youtube,"The leg raise is a strength training exercise which targets the iliopsoas (the anterior hip flexors). Because the abdominal muscles are used isometrically to stabilize the body during the motion."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Situps","20,25,30 sets",R.drawable.youtube,"Situps are classic abdominal exercises done by lying on your back and lifting your torso"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Reverse Crunch","20 reps 3 sets",R.drawable.youtube,"Keep your knees bent at 90 degrees throughout the movement. Tuck your knees toward your face as far as you can comfortably go without lifting your mid-back from the mat."));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Mountain Climbers","20 reps 3 sets",R.drawable.youtube,"A mountain climber is a bodyweight exercise that activates muscles throughout your body. Perform mountain climbers by getting into a high plank position with your hands shoulder-width apart beneath you."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Saturday")){

                    Type.setText("Back Workout");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Seated cable row","12 reps 3 sets",R.drawable.youtube,"Sit on the bench with your knees bent and grasp the cable attachment. It often has a triangle handle, but it may be a bar"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Bent over row","15 reps 3 sets",R.drawable.youtube,"The bent-over row, also known as the barbell row and the barbell bent-over row, is a compound exercise that activates muscles throughout your upper and lower body"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"T bar row","15 reps 3 sets",R.drawable.youtube,"Stand with the barbell between your legs and face the moveable end. Get into the form described above for a barbell-based t-bar row. Bend from your hips and place your hands on opposite sides of the barbell"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hyperextension","10 reps 3 sets",R.drawable.youtube,"Hyperextension means that there's been excessive movement of a joint in one direction (straightening)"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Barbell Deadlift","12,15,20 reps",R.drawable.youtube,"In a deadlift, you lift the weight from the ground to thigh-level using primarily your leg and hip muscles, but with the assistance of most of the large muscle groups of your body"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Pull up using resistance band","20 reps 3 sets",R.drawable.youtube,"Pull up bands are extra long resistance bands that are often made to be one continuous loop"));
                    ExampleItem.add(new customcard(R.drawable.calendar,"Romanian Deadlift","15 reps 3 sets",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent"));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}
                if(DAY.equals("Sunday")){

                    Type.setText("Rest Day");
                    Type.setVisibility(View.VISIBLE);
                    ArrayList<customcard>ExampleItem =new ArrayList<>();
                    ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));
                    recycle=findViewById(R.id.view);
                    recycle.setHasFixedSize(true);
                    manger=new LinearLayoutManager(Case1.this);
                     adpt=new ExAdapter(ExampleItem,getApplicationContext());
                    recycle.setLayoutManager(manger);
                    recycle.setAdapter(adpt);}

            }

        }
    };

    private void ShowUSerbmi(FirebaseUser firebaseUser) {
        String id=firebaseUser.getUid();
        DatabaseReference rt=FirebaseDatabase.getInstance().getReference("Registered Users");
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
                    if(bar!=null){
                        bar.setVisibility(View.GONE);
                    }
                    wait.setVisibility(View.GONE);
                    work.setVisibility(View.VISIBLE);
                    setting.setVisibility(View.VISIBLE);

                }
                else{
                    if(bar!=null){
                        bar.setVisibility(View.GONE);
                    }
                    wait.setVisibility(View.GONE);
                    work.setVisibility(View.VISIBLE);
                    setting.setVisibility(View.VISIBLE);
                    text.setPadding(385,30,385,30);
                    text.setTextSize(22);
                    alter.setVisibility(View.VISIBLE);
                    alter.setText("Your Workout Plan");


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
                    String name= Calendar.getInstance().getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.getDefault());
                    GOAL=getusergoal.Goal;
                    RecyclerView list=(RecyclerView) findViewById(R.id.list);
                    list.setLayoutManager(new LinearLayoutManager(Case1.this,LinearLayoutManager.HORIZONTAL,false));
                    list.setAdapter(new horadpt(new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
                    if(GOAL.equals("Gain weight")){
                        if(name.equals("Monday")){
                            Type.setText("Chest Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bench Press","Do 3 sets",R.drawable.youtube,"The bench press is a compound exercise that targets the muscles of the upper body."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Decline press","Do 3 sets",R.drawable.youtube,"In a decline bench press, the bench is set to 15 to 30 degrees on a decline. This angle places your upper body on a downward slope, which activates the lower pectoral muscles as you push weights away from your body."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Seated bench press","Do 3 sets",R.drawable.youtube,"The seated chest press is a fixed weight machine that replicates the movement of a bench press in a seated position. Using the seated chest press works the pectorals, deltoids, and triceps."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Inclined Dumbell press","Do 3 sets",R.drawable.youtube,"The incline dumbbell press is a free weight exercise designed to target the chest, shoulders, and triceps, independently hitting each side of the body."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Push ups","Do 5 sets",R.drawable.youtube,"The push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){
                            Type.setText("Back And Core");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Pull Ups","15 reps",R.drawable.youtube,"A pullup is a challenging upper body exercise where you grip an overhead bar and lift your body until your chin is above that bar."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Seated Cable Row","12 reps",R.drawable.youtube,"A seated cable row is a compound exercise that utilizes a weighted horizontal cable row machine to work muscle groups in your back and arms."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Machine T-bar rows","12 reps",R.drawable.youtube,"The machine t-bar row is a variation of the bent over row and an exercise used to build back muscle and strength."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Crunches-Bicycle","10 minutes",R.drawable.youtube,"The bicycle crunch is a bodyweight exercise that activates your core muscles. Practice bicycle crunches by lying flat with your lower back pressing into an exercise mat."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Plank","3 Sets 60 Second hold",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"V Sit","45 Seconds 3 Sets",R.drawable.youtube,"The V-sit ab exercise builds core strength by working multiple areas of the core at the same time, while also challenging your balance"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Side Plank","3 sets 60 Seconds each",R.drawable.youtube,"Lie on your side with your knees bent, and prop your upper body up on your elbow. Raise your hips off the floor, and hold for 6 seconds. Rest for 10 seconds."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            Type.setText("Shoulder Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Seated Dumbell Press","3 sets 15,12,10 reps",R.drawable.youtube,"The move involves pressing two dumbbells above the head and targets the deltoids and triceps, with further engagement from the upper chest and traps."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Single Arm Cable Front","Each side 3 sets",R.drawable.youtube,"While maintaining the torso stationary (no swinging), lift the left arm to the front with a slight bend on the elbow and the palms of the hand always faces down."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Arnold Press","12 reps",R.drawable.youtube,"The Arnold presses is defined by a wrist rotation movement that ends when your palms face forward at the top of the press."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lateral Raises","10 reps",R.drawable.youtube,"A lateral raise is a strength training shoulder exercise characterized by lifting a pair of dumbbells away from your body in an external rotation."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Reverse flies","Hold for 30 seconds",R.drawable.youtube,"The reverse fly is a resistance exercise that works the rear shoulders and major muscles of the upper back."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            Type.setText("Legs Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Calf Raises","15 reps",R.drawable.youtube,"Campbell: To do a calf raise with dumbbells, hold a dumbbell in each hand and stand with your feet about shoulder-width apart."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Squats","12 reps",R.drawable.youtube,"An exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Weighted Squats","12 reps",R.drawable.youtube,"Stand with feet hip-width apart, holding a heavy dumbbell or kettlebell in front of chest with both hands, elbows pointing down."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Weighted Lunges","Hold for 30  seconds",R.drawable.youtube,"Perform dumbbell lunges by holding a dumbbell in each hand as you take a big step forward and lower yourself until your front leg and back leg are both at nearly a 90-degree angle"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Leg Extension","Hold for 30 seconds",R.drawable.youtube,"You sit on the machine with a weighted pad on top of your lower legs. Then you use your quads to repeatedly extend your knees and lift your lower legs."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Leg Press","3X, Rest 1 minute b/w ",R.drawable.youtube,"Leg presses are seated exercises done on a leg press machine To start, sit with your back against a padded backrest and your feet on two large footrests. Your knees are bent to start the exercise."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            Type.setText("Biceps And Triceps");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Push Down Workout","3 Sets 15,12,12 reps",R.drawable.youtube,"A push-down is a strength training exercise used for strengthening the triceps muscles in the back of the arm. "));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Tricep Push Down","3 Sets 15,12,12 reps",R.drawable.youtube,"The tricep pushdown is one of the best exercises for tricep development. While the versatile upper-body workout is usually done on a cable machine (a fixture at most gyms)"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hammer Curl","3 Sets 15,12,12 reps",R.drawable.youtube,"Hammer curls are biceps curls performed with your hands facing each other. They're beneficial to add mass to your arms and can help focus more attention on the short head of the biceps."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Tricep Dumbell Kickback","3 Sets 15,12,12 reps",R.drawable.youtube,"Start with dumbbells that are 5 to 10 pounds each and gradually increase the weight as you gain strength. Substitute soup cans or water bottles if you don’t have weights."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Diamond Pushups","3 Sets 15,12,12 reps",R.drawable.youtube,"Diamond push-ups, also known as triangle push-ups,Practice diamond push-ups by bringing your hands close together to form a diamond or triangle shape below your chest."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Cable Hammer Curl","3 Sets 15,12,12 reps",R.drawable.youtube,"The hammer curl may help add mass to your arms because the grip positioning often allows you to lift heavier weight. As a result, it’s a good exercise to build strength in all three muscles that bend your elbow"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            Type.setText("Glutes Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hip Extension","15 reps",R.drawable.youtube,"Hip extension occurs when you extend or “open” your hip joint so that the angle between your pelvis and thigh increases."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Squats","Close Legged,Weighted,Wide Legged",R.drawable.youtube,"An exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Glute bridge","45 Second Hold 3 Sets",R.drawable.youtube,"A glute bridge is a physical exercise that helps to strengthen the gluteus muscles (located in your buttocks) and hamstrings."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Romanion Dead Lift","Weight as per Strength",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Box Squats","Hold for 30 seconds",R.drawable.youtube,"The box squat is exactly like a standard squat, except that there is a dedicated pause at the bottom of the movement."));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            Type.setText("Rest Day");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));


                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}
                   else if(GOAL.equals("Loose Weight")){
                        if(name.equals("Monday")){
                            Type.setText("Total-Body Strength Training");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){
                            Type.setText("Sprint Intervals");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Full-out sprint","30 seconds",R.drawable.youtube,"Sprinting is running over a short distance at the top-most speed of the body in a limited period of time. It is used in many sports that incorporate running, typically as a way of quickly reaching a target or goal, or avoiding or catching an opponent"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Moderate pace jog","60 seconds",R.drawable.youtube,"Jogging is slower and less intense than running. The main differences are pace and effort. One definition of jogging speed is 4 to 6 miles per hour (mph), while running can be defined as 6 mph or more."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Do Above Exercises","12 Times",R.drawable.youtube,"Repeat previous Exercises 12 times as Specified."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            Type.setText("Foam Rolling");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"12,000","Steps",R.drawable.youtube,"Perform Foam Rolling And then Complete 12 Thousand Steps."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            Type.setText("Total-Body Strength Training");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            Type.setText("High Intensity Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"High-Intensity Group\nFitness Class","Follow Youtube",R.drawable.youtube,"In this Workout You Should Follow the instruction provided in the Video on youtube."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            Type.setText("Total-Body Strength Training");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bodyweight Squats","15 reps",R.drawable.youtube,"A fundamental exercise that builds strength in your legs and glutes."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Bench Press","12 reps",R.drawable.youtube,"The dumbbell bench press is a variation of the barbell bench press and an exercise used to build the muscles of the chest"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell Row","12 reps each side",R.drawable.youtube,"The dumbbell row, also known as the bent-over dumbbell row, is a compound back exercise. Perform dumbbell rows by hinging your hips with your back straight and lifting a pair of dumbbells with a neutral grip."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lying Isometric Y","Hold for 30 seconds. ",R.drawable.youtube,"Isometric exercises are exercises in which your muscles are engaged, but they are not changing length."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Plank","Hold for 30 seconds",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            Type.setText("Rest Day");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));;


                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}
                  else if(GOAL.equals("Normal Exercise")){
                        if(name.equals("Monday")){
                            Type.setText("Leg Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Calf raises","15 reps 3 sets",R.drawable.youtube,"To do a calf raise with dumbbells, hold a dumbbell in each hand and stand with your feet about shoulder-width apart. Let your arms hang straight below your shoulders"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Split squat","20 reps each\nleg 2 sets each",R.drawable.youtube,"A split squat is a lower body exercise that works one leg at a time. Your legs are split with one leg in front of you and the other behind you on an elevated surface like a bench"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Leg press","15 reps 3 sets each",R.drawable.youtube,"Leg presses are seated exercises done on a leg press machine. To start, sit with your back against a padded backrest and your feet on two large footrests."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Deadlift","10 reps comfortable\nweight 4 sets",R.drawable.youtube,"The deadlift exercise is a relatively simple exercise to perform, a weight is lifted from a resting position on the floor to an upright position"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Jump squat","20 reps 3 sets each",R.drawable.youtube,"Stand with feet shoulder width and knees slightly bent. Bend your knees and descend to a full squat position."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Pistol squat","10 reps each leg 3 sets ",R.drawable.youtube,"Pistol squats are single-legged squats. You perform them with one leg and both arms extended out in front of you."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Tuesday")){
                            Type.setText("Arms Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Tricep extensions","15 reps",R.drawable.youtube," To do a triceps extension, lie on your back with a dumbbell in your hand. Point your upper arm toward the ceiling, with your elbow bent to 90 degrees"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bicep curl","15 reps 3 sets each",R.drawable.youtube,"To do a biceps curl with a dumbbell, hold a dumbbell with your palm facing upward. Slowly curl the weight up by bending your elbow, keeping your elbow close to your body"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Pushups","10 reps each\nDifferent variations",R.drawable.youtube,"The push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Tricep dips","15 reps 3 sets ",R.drawable.youtube,"Stand facing away from a bench, grab it with both hands at shoulder-width. Extend your legs out in front of you."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbbell floor press","15,12,10 reps\n3 sets total",R.drawable.youtube,"Press the weights to full extension by contracting your triceps and chest"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bench press","15 reps 3 sets",R.drawable.youtube,"The bench press is a compound exercise that targets the muscles of the upper body."));
                            recycle=findViewById(R.id.view);
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Wednesday")){

                            Type.setText("Glutes Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Romanian deadlift","15 reps 3 sets",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Kettleball Swing","15 reps 3 sets",R.drawable.youtube,"It involves moving the bell in a pendulum motion from between the knees to anywhere between eye level to fully overhead and can be performed either two-handed or using one hand"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Jumping squat","20 reps 3 sets",R.drawable.youtube,"Stand with feet shoulder width and knees slightly bent. Bend your knees and descend to a full squat position."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Step ups","20 reps 3 sets",R.drawable.youtube,"Pushing primarily through your lead foot, lift your body up onto the step. Then step backward to the starting position."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hipthrust","15 reps 3 sets",R.drawable.youtube,"A hip thrust, also called a hip thruster, is a lower body exercise that specifically activates your gluteal muscles, including the gluteus maximus, gluteus medius, and gluteus minimus"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"One leg deadlift","15 reps 3 sets",R.drawable.youtube,"The single-leg deadlift (SLDL) is an exercise characterized by a forward hip-hinge movement while lifting one leg off the ground and extending it backwards"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lateral lunge","15,12,10 reps\neach leg 3 sets ",R.drawable.youtube,"A lateral lunge, also known as a side lunge, is a bodyweight exercise that works multiple muscle groups throughout your lower body, including your quadriceps, abductors, glutes, and hamstrings"));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Thursday")){

                            Type.setText("Shoulder Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Military lift","12 reps 3 sets",R.drawable.youtube,"The basic exercise is simple. You start with the barbell resting on your collarbone, around shoulder height"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Dumbell Lateral Raise","12 reps 3 sets",R.drawable.youtube,"Grab a set of dumbbells and stand straight. 2. With your palms facing down, lift the dumbbells and raise your arms out to the sides"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Shoulder Press","12 reps 3 sets",R.drawable.youtube,"The overhead press, also known as the shoulder press or military press, is an upper-body weight training exercise in which the trainee presses a weight overhead while seated or standing"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Cable face pull","15 reps 3 sets",R.drawable.youtube,"Stand facing a cable pulley gripping the ends of the rope attachment in each hand."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Single arm cable\nlateral raise","15 reps 3 sets",R.drawable.youtube,"Position a cable at the lowest position possible and attach a single handle. Reach across your body and grab the handle with a neutral grip"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Weight Plate Front Raise","15 reps 3 sets",R.drawable.youtube,"The plate front raise is a variation of the dumbbell front raise where the lifter holds a weight plate between two hands, rather than using a dumbbell, barbell, or other weight."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Lateral Raise(Partials)","15 reps 3 sets",R.drawable.youtube,"Take a deep breath and raise the dumbbells to roughly 45 degrees using a neutral grip (palms facing in). "));
                            recycle=findViewById(R.id.view);
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Friday")){

                            Type.setText("Full ABS");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bicycle Crunches","20,23,30 reps,2 sets",R.drawable.youtube,"Raise your knees to a 90-degree angle and alternate extending your legs as if pedaling a bike. Twist your body to touch your elbow to the opposite knee with each pedal motion"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Russian Twist","20 reps 3 sets",R.drawable.youtube,"Russian twists are a great core exercise. This move works your obliques while also targeting your shoulders and hips"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Plank","1 min hold 3 sets",R.drawable.youtube,"The plank (also called a front hold, hover, or abdominal bridge) is an isometric core strength exercise that involves maintaining a position similar to a push-up for the maximum possible time"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Leg Raise","20 reps 3 sets",R.drawable.youtube,"The leg raise is a strength training exercise which targets the iliopsoas (the anterior hip flexors). Because the abdominal muscles are used isometrically to stabilize the body during the motion."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Situps","20,25,30 sets",R.drawable.youtube,"Situps are classic abdominal exercises done by lying on your back and lifting your torso"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Reverse Crunch","20 reps 3 sets",R.drawable.youtube,"Keep your knees bent at 90 degrees throughout the movement. Tuck your knees toward your face as far as you can comfortably go without lifting your mid-back from the mat."));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Mountain Climbers","20 reps 3 sets",R.drawable.youtube,"A mountain climber is a bodyweight exercise that activates muscles throughout your body. Perform mountain climbers by getting into a high plank position with your hands shoulder-width apart beneath you."));
                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Saturday")){

                            Type.setText("Back Workout");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Seated cable row","12 reps 3 sets",R.drawable.youtube,"Sit on the bench with your knees bent and grasp the cable attachment. It often has a triangle handle, but it may be a bar"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Bent over row","15 reps 3 sets",R.drawable.youtube,"The bent-over row, also known as the barbell row and the barbell bent-over row, is a compound exercise that activates muscles throughout your upper and lower body"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"T bar row","15 reps 3 sets",R.drawable.youtube,"Stand with the barbell between your legs and face the moveable end. Get into the form described above for a barbell-based t-bar row. Bend from your hips and place your hands on opposite sides of the barbell"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hyperextension","10 reps 3 sets",R.drawable.youtube,"Hyperextension means that there's been excessive movement of a joint in one direction (straightening)"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Barbell Deadlift","12,15,20 reps",R.drawable.youtube,"In a deadlift, you lift the weight from the ground to thigh-level using primarily your leg and hip muscles, but with the assistance of most of the large muscle groups of your body"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Pull up using resistance band","20 reps 3 sets",R.drawable.youtube,"Pull up bands are extra long resistance bands that are often made to be one continuous loop"));
                            ExampleItem.add(new customcard(R.drawable.calendar,"Romanian Deadlift","15 reps 3 sets",R.drawable.youtube,"A Romanian Deadlift (RDL) is a deadlift in which the body is bent at the hips and the knees are not bent"));

                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}
                        if(name.equals("Sunday")){

                            Type.setText("Rest Day");
                            Type.setVisibility(View.VISIBLE);
                            ArrayList<customcard>ExampleItem =new ArrayList<>();
                            ExampleItem.add(new customcard(R.drawable.calendar,"Hurray! Enjoy","Its A Rest Day",R.drawable.youtube,"Enjoy Your Day by Exploring about fitness from youtube video pinned in previous page."));


                            recycle=findViewById(R.id.view);
                            recycle.setHasFixedSize(true);
                            manger=new LinearLayoutManager(Case1.this);
                             adpt=new ExAdapter(ExampleItem,getApplicationContext());
                            recycle.setLayoutManager(manger);
                            recycle.setAdapter(adpt);}}
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Case1.this, "NOTHING", Toast.LENGTH_SHORT).show();
            }
        });
    }
}