package com.example.sebastian.sucapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.example.sebastian.sucapp.entities.Asignatura;
import com.example.sebastian.sucapp.webService.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class index extends AppCompatActivity {
    CardView tarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        tarjeta = (CardView)findViewById(R.id.card_view);

        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultaMaterias();
            }
        });
    }

    public void consultaMaterias() {
        JSONObject jsonObject = null;
        String line;

        List<Asignatura> Asignaturas = null;
        try {
            SharedPreferences preferencias = getSharedPreferences("user", Context.MODE_PRIVATE);
            String username = preferencias.getString("name","0");
            URL link = new URL(Constantes.IP + Constantes.MODULE_ALUMNOS + "getAsignaturas.php" + "?username=" + username);
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();

            StringBuilder result = new StringBuilder();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            jsonObject = new JSONObject(result.toString());

            if (jsonObject != null) {
                Asignaturas = new ArrayList<Asignatura>();

                JSONArray jsonArray = new JSONArray("asignaturas");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject asignatura = jsonArray.getJSONObject(i);
                    Asignatura as = new Asignatura(asignatura);
                    Asignaturas.add(as);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(index.this, "datos: " + Asignaturas.get(0).getId(), Toast.LENGTH_SHORT).show();

    }

}
