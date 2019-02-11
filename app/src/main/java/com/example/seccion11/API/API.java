package com.example.seccion11.API;

import com.example.seccion11.API.Deserializers.MyDeserializer;
import com.example.seccion11.Models.City;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final  String BASE_URL = "https://samples.openweathermap.org/data/2.5/";
    public static final String APPKEY = "b1b15e88fa797225412429c1c50c122a1";

    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if (retrofit == null){

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class, new MyDeserializer());

             retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create() ))
                    .build();
        }

        return retrofit;
    }

     

}
