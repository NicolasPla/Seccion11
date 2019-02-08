package com.example.seccion11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String json = "{" +
                "id: 0," +
                "ciudades: ["+
                "{" +
                    "id: '1'," +
                    "name: 'London'" +
                "},"+
                "{" +
                    "id: '2'," +
                    "name: 'Seville'" +
                "}]"+
                "}";


        // Libreria Gson // Como parsear con Gson

        Gson gson = new GsonBuilder().create();
        Town town = gson.fromJson(json, Town.class);

    }
}


// FORMA NATIVA DE PARSEAR JSON

/*        City city = null;

        try{
            JSONObject mJson = new JSONObject(json);

            int id = mJson.getInt("id");
            String name = mJson.getString("name");

            // Otra forma de conseguir el string
            //String name = (String) mJson.get("name");

            city = new City(id, name);
        }catch (JSONException e){
            e.printStackTrace();
        }

       // Toast.makeText(this, city.getId() + " -- " + city.getName(), Toast.LENGTH_LONG).show();
*/
