package com.example.webf1movil1704;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pantalla4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla4);

        }

    public void irPantalla3(View v){
        Intent intent = new Intent(this, pantalla3.class);
        startActivity(intent);

    }

    public void irPantalla5(View v){
        Intent intent = new Intent(this, pantalla5.class);
        startActivity(intent);

    }

}