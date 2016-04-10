package com.example.sebastian.sucapp.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.example.sebastian.sucapp.entities.materias;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastian on 4/9/2016.
 */
public class asignatura {
    public static List<asignatura> getDataSet(Context context){
        List<asignatura> dataSet = new ArrayList<>();
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(".json")));
            String line = "";
            //Se lee el archivo JSON
            while ((line=bufferedReader.readLine()) != null){
                builder.append(line);
            }
            bufferedReader.close();
            String json = builder.toString();
            // Se convierte a un JSONArray
            JSONArray jsonArray = new JSONArray(json);
            for (int index = 0; index < jsonArray.length(); index++) {
                asignatura datos = new asignatura();
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                /*socialNetwork.setId(jsonObject.getInt("id"));
                socialNetwork.setName(jsonObject.getString("name"));
                socialNetwork.setDescription(jsonObject.getString("description"));
                socialNetwork.setIcon(index);
                socialNetwork.setRating((float)jsonObject.getDouble("rating"));
                dataSet.add(datos);*/
            }
        } catch (IOException ex) {
            Toast.makeText(context, "I/O Error", Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            Log.e(asignatura.class.getName(), e.getMessage(), e);
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return dataSet;
    }
}
