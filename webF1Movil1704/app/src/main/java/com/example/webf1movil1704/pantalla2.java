package com.example.webf1movil1704;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantallla2);
    }
    public void irActivityMain (View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    public void irPantalla3 (View v){
        Intent intent = new Intent(this, pantalla3.class);
        startActivity(intent);

    }






}