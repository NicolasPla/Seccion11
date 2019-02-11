package com.example.seccion11.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.seccion11.API.API;
import com.example.seccion11.Models.City;
import com.example.seccion11.R;
import com.example.seccion11.API.APIServices.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherService service = API.getApi().create(WeatherService.class);

        Call<City> cityCall = service.getCityCelsius("Seville,ES",API.APPKEY /*, "metric"*/);

        // ASYNC
        cityCall.enqueue(new Callback<City>() {
            // CONNECTED
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();
            }
            // ERROR
            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

