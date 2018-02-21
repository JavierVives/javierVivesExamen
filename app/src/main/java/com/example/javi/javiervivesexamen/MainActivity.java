package com.example.javi.javiervivesexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPaises;

    //private static final String URL="http://restcountries.eu/rest/v2/all";
    private static final String URL="http://192.168.31.44/Paises/paises.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lvPaises = findViewById(R.id.lvPaises);

        RequestQueue request = Volley.newRequestQueue(this);

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>(){


            public void onResponse(JSONArray response){

            ArrayList<DatosPais> listaPaises=new ArrayList<DatosPais>();

                try {

                JSONObject jsonArrayRequest=new JSONObject(response.toString(0));

                JSONArray JSONList=jsonArrayRequest.getJSONArray("");

                //Saco todos los datos de cada Pais
                for(int i=0; i<JSONList.length(); i++){

                    String nombre = JSONList.getJSONObject(i).getString("name");
                    String clave = JSONList.getJSONObject(i).getString("alpha2Code");
                    String capital = JSONList.getJSONObject(i).getString("capital");
                    String region = JSONList.getJSONObject(i).getString("region");
                    String poblacion = JSONList.getJSONObject(i).getString("population");

                    String latlng = JSONList.getJSONObject(i).getJSONArray("latlng").getJSONObject(0).getString("sinnombre"); //Prueba
                    String fronteras = JSONList.getJSONObject(i).getJSONArray("borders").getJSONObject(0).getString("sinnombre"); //Prueba


                    DatosPais registro=new DatosPais(nombre, clave, capital, region, poblacion, latlng, fronteras);

                    //Con la linea siguiente cargo el ArrayList de forma que ya podré intentar mostrar todos los datos a través de un ListView
                    listaPaises.add(registro);

                }

                /// SACO EL LIST VIEW

                AdaptadorPais adaptador = new AdaptadorPais(getApplicationContext(), listaPaises);
                lvPaises.setAdapter(adaptador);


            } catch (JSONException e) {
                e.printStackTrace();
            }
         }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }

        });
        request.add(jsonArrayRequest);

        //Probando al clickar en cada objeto del listview
        /*lvPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "PRUEBA DEL ON CLICK", Toast.LENGTH_SHORT).show();

            }
        });*/

    }
}
