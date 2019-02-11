package com.example.seccion11.API.APIServices;

import com.example.seccion11.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    //forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1
    @GET("weather")
    Call<City> getCity(@Query("id") String city, @Query("appid") String Key);

    @GET("weather")
    Call<City> getCityCelsius(@Query("id") String city, @Query("appid") String Key /*,@Query("units") String value*/ );
}
