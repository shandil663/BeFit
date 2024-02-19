package com.example.befit;

import android.widget.Button;

public class customcard {
    private int Imagesrc;
    private String exercise;
    private String count,DESC;

    private  int img2;
    private String Day;



    public customcard(int image, String exer, String coun, int butt,String desc){
        Imagesrc=image;
        exercise=exer;
        count=coun;
        img2=butt;
       DESC=desc;


    }

    public customcard(String day) {
        Day=day;
    }

    public String getDay() {
        return Day;
    }

    public int getImagesrc() {
        return Imagesrc;
    }

    public String getCount() {
        return count;
    }

    public String getExercise() {
        return exercise;
    }

    public int getImg2() {
        return img2;
    }
    public String getdesc() {
        return DESC;
    }
}
