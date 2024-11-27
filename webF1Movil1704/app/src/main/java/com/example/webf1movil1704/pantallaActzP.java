package com.example.webf1movil1704;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.ContentValues;

public class pantallaActzP extends BaseActivityBD{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acualiza_produ);
        String selectedItem = getIntent().getStringExtra("selectedItem");
        ViID = findViewById(R.id.vIdP);
        etCodigo = findViewById(R.id.vCodigo);
        etNombrem = findViewById(R.id.vNombre);
        Viemoji = findViewById(R.id.vEmoji);// este si
        etPrecio = findViewById(R.id.vPrecio);

        miraProducto(Integer.parseInt(selectedItem));

    }

    private void miraProducto(int posicion) {
        SQLiteDatabase bd=admin.getReadableDatabase();
        Cursor fila=bd.rawQuery("SELECT * FROM prosuctos  ",null);

        fila.moveToPosition(posicion);
        ViID.setText(fila.getString(0));
        etCodigo.setText(fila.getString(1));
        etNombrem.setText(fila.getString(2));
        Viemoji.setText(fila.getString(3));
        etPrecio.setText(fila.getString(4));

    }

    public void modificarP(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Obtener los valores de los campos de texto
        String id = ViID.getText().toString();
        String codigo = etCodigo.getText().toString();
        String nombre = etNombrem.getText().toString();
        //String emoji = Viemoji.getText().toString();
        String precio = etPrecio.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("CodigoP", codigo);
        registro.put("NombreP", nombre);
        //registro.put("EmojiP", emoji);
        registro.put("ValorP", precio);

        // Actualizar el registro en la base de datos
        int cant = bd.update("prosuctos", registro, "ID=?", new String[]{id});

        if (cant == 1) {
            Toast.makeText(this, "El producto ha sido modificado", Toast.LENGTH_LONG).show();
            bd.close();
            Intent intent = new Intent(this, pantallaActualiz.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "El producto no se pudo modificar", Toast.LENGTH_LONG).show();
        }

        bd.close();
    }
    public void regresa (View v){
        Intent intent = new Intent(this, pantallaActualiz.class);
        startActivity(intent);
    }


}
