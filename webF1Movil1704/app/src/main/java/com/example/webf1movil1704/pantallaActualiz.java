package com.example.webf1movil1704;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class pantallaActualiz extends BaseActivityBD {

    ListView listaProductos;
    ArrayList<String> listaInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar_bd);
        listaProductos=findViewById(R.id.listaProductosB);
        listaInformacion = new ArrayList<String>();
        consultarProductos();
        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listaProductos.setAdapter(adaptador);

        listaProductos.setOnItemClickListener((parent, view, position, id) -> {
            // Obtén el ítem seleccionado
            int selectedItem = Integer.parseInt(id+"");

            // Crea el Intent para ir al nuevo Activity
            Intent intent = new Intent(this,pantallaActzP.class);

            // Envía el dato seleccionado al segundo Activity
            intent.putExtra("selectedItem", selectedItem+"");
            startActivity(intent);
        });


    }
    private void consultarProductos(){
        SQLiteDatabase bd=admin.getReadableDatabase();
        Cursor fila=bd.rawQuery("SELECT * FROM prosuctos ",null);
        fila.moveToFirst();
        int c=0;
        while (c<fila.getCount()){
            String lista=fila.getString(0)+" - "+fila.getString(1)+" - "+fila.getString(2)+" - "+fila.getString(3)+" - "+fila.getString(4);
            listaInformacion.add(lista);
            fila.moveToNext();
            c++;
        }

    }
}
