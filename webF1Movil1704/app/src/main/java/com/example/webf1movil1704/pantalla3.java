package com.example.webf1movil1704;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pantalla3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla3);
    }
    public void irPantalla2(View v){
        Intent intent = new Intent(this, pantalla2.class);
        startActivity(intent);

    }
    public void irPantalla4(View v){
        Intent intent = new Intent(this, pantalla4.class);
        startActivity(intent);

    }

}