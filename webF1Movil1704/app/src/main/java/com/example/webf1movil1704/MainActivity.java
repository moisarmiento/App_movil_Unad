package com.example.webf1movil1704;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irPantalla2(View v){
        Intent intent = new Intent(this, pantalla2.class);
        startActivity(intent);

    }
    public void irAEmpleados(View v){
        Intent intent = new Intent(this, AssEmpleados.class);
        startActivity(intent);

    }

    public void irALlamada (View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+123456789")); // Número de teléfono a marcarstartActivity(intent);
        startActivity(intent);

    }
    public void irAMapa (View v) {
        Uri ubicacion = Uri.parse("https://www.google.com/maps/search/?api=1&query=4.5972,-74.0784");
        Intent interaccionMapa = new Intent(Intent.ACTION_VIEW,ubicacion);
        startActivity(interaccionMapa);
    }
}