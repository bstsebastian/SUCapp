package com.example.sebastian.sucapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        recyclerView = (RecyclerView)findViewById(R.id.Rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(index.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        consultaMaterias();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

                JSONArray jsonArray = jsonObject.optJSONArray("asignaturas");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject asignatura = jsonArray.getJSONObject(i);
                    Asignatura as = new Asignatura(asignatura);
                    Asignaturas.add(as);
                }

                adapter = new RecyclerAdapter(Asignaturas);
                recyclerView.setAdapter(adapter);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
