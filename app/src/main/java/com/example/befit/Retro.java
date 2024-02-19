package com.example.befit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {
    private static Retrofit retrofit;
    private static  final  String  BASEURl="";

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASEURl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
