package com.example.webf1movil1704;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class pantallaM  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ir_producto_bd); // Layout correcto
    }
    public void irACrearP(View v){
        Intent intent = new Intent(this, pantallaCrearP.class);
        startActivity(intent);
    }
    public void irAverBD(View v){
        Intent intent = new Intent(this, pantallaVerbd.class);//cambiar
        startActivity(intent);
    }
    public void irEliminarBD(View v){
        Intent intent = new Intent(this, pantallaBorrarP.class);//cambiar
        startActivity(intent);
    }

}
