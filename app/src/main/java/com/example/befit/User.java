package com.example.befit;

public class User {
public String N1,P1,B1,W1,A1,C1,H1,G1,Goal;
    public User(){}

    public User( String name, String phone){
this.N1=name;
this.P1=phone;

    }
    public User(String bmi,String wght,String age,String cat,String hght,String gndr){
        this.B1=bmi;
        this.W1=wght;
        this.A1=age;
        this.C1=cat;
        this.H1=hght;
        this.G1=gndr;
    }

    public User(String goal) {
        Goal = goal;
    }
}
