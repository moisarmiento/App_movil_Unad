package com.example.webf1movil1704;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class pantallaBusca extends BaseActivityBD {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscarp);


        etCodigo=findViewById(R.id.etBusqueda);
        ViNombrem=findViewById(R.id.vnombre);
        Viemoji=findViewById(R.id.vEmoji);
        ViPrecio=findViewById(R.id.vPrecio);

    }
    public void busca(View v){
        String Codigo=etCodigo.getText().toString();
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("SELECT NombreP,EmojiP,ValorP FROM prosuctos where CodigoP='"+Codigo+"'",null);
        if (fila.moveToFirst()){
            ViNombrem.setText(fila.getString(0));
            Viemoji.setText(fila.getString(1));
            ViPrecio.setText(fila.getString(2));
        }else{
            Toast.makeText(this, "el vehiculo con esa placa no existe", Toast.LENGTH_LONG).show();

        }
        bd.close();
    }

}
