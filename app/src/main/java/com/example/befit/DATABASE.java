package com.example.befit;

public class DATABASE {
    private String exercise;
    private String count;

    public DATABASE( String exercise, String count) {
        this.exercise = exercise;
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    public String getExercise() {
        return exercise;
    }


}
