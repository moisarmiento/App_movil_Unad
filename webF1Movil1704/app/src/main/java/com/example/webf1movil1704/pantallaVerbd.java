package com.example.webf1movil1704;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pantallaVerbd extends BaseActivityBD {

    ListView listaProductos;
    ArrayList <String> listaInformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_lista_p);
        listaProductos=findViewById(R.id.listaProductos);
        listaInformacion = new ArrayList<String>();
        consultarProductos();
        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listaProductos.setAdapter(adaptador);

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

    /*
    public ArrayList<entidadProductos> mostrarProductos{
        SQLiteDatabase db= admin.getWritableDatabase();
        ArrayList<entidadProductos> listaProductos=new ArrayList<>();
        entidadProductos entidadP =null;
        Cursor cursorP=null;
        //cursorP=db.rawQuery("SELECT * FROM"+"prosuctos",null);
        cursorP = db.rawQuery("SELECT * FROM " + "prosuctos", null);

        if(cursorP.moveToFirst()){
            do {
                entidadP=new entidadProductos();
                entidadP.setIDp(cursorP.getString(0));
                entidadP.setCodigo(cursorP.getString(1));
                entidadP.setNombre(cursorP.getString(2));
                entidadP.setEmoji(cursorP.getString(3));
                entidadP.setPrecio(cursorP.getString(4));

                listaProductos.add(entidadP);

            } while (cursorP.moveToNext());
        }
        cursorP.close();

        return listaProductos;

    }*/


}
