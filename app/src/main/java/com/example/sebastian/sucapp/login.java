package com.example.sebastian.sucapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastian.sucapp.webService.Constantes;

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
import java.net.URLConnection;

public class login extends AppCompatActivity {
    Button controlerbtnLogin;
    EditText editUser, editPass;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        controlerbtnLogin = (Button)findViewById(R.id.btnLogin);
        editUser = (EditText) findViewById(R.id.editUser);
        editPass = (EditText) findViewById(R.id.editPass);
        textView2 = (TextView) findViewById(R.id.textView2);

        controlerbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    public void attemptLogin() {
        JSONObject jsonObject = null;
        String line;
        String status = "3";

        try {
            Toast.makeText(login.this, "Prueba2", Toast.LENGTH_SHORT).show();
            URL link = new URL(Constantes.IP + Constantes.MODULE_CREDENTIALS + "login.php" + "?username=" + editUser.getText().toString() + "&password=" + editPass.getText().toString());
            HttpURLConnection connection = (HttpURLConnection) link.openConnection();

            StringBuilder result = new StringBuilder();
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while((line = bufferedReader.readLine()) != null)
            {
                result.append(line);
            }

            jsonObject = new JSONObject(result.toString());
            status = jsonObject.getString("status");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(login.this, "Estatus: " + status, Toast.LENGTH_SHORT).show();
    }
}
