package com.example.webf1movil1704;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class pantallaMensaje extends BaseActivityBD{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensaje_borrar);
        String selectedItem = getIntent().getStringExtra("selectedItem");
        ViID = findViewById(R.id.vIdP);
        ViCodigo = findViewById(R.id.vCodigo);
        ViNombrem = findViewById(R.id.vNombre);
        Viemoji = findViewById(R.id.vEmoji);
        ViPrecio = findViewById(R.id.vPrecio);

        miraProducto(Integer.parseInt(selectedItem));

    }

    private void miraProducto(int posicion) {
        SQLiteDatabase bd=admin.getReadableDatabase();
        Cursor fila=bd.rawQuery("SELECT * FROM prosuctos  ",null);

        fila.moveToPosition(posicion);
        ViID.setText(fila.getString(0));
        ViCodigo.setText(fila.getString(1));
        ViNombrem.setText(fila.getString(2));
        Viemoji.setText(fila.getString(3));
        ViPrecio.setText(fila.getString(4));

    }

    public void BorrarItem(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        int posicion = Integer.parseInt(getIntent().getStringExtra("selectedItem"));

        Cursor fila = bd.rawQuery("SELECT id FROM prosuctos", null);

        if (fila.moveToPosition(posicion)) {
            String idProducto = fila.getString(0);

            // Ejecutar la eliminación
            int cant = bd.delete("prosuctos", "ID = ?", new String[]{idProducto});

            if (cant == 1) { // Verificar si se eliminó algún registro
                Toast.makeText(this, "El producto ha sido borrado", Toast.LENGTH_LONG).show();
                ViID.setText("");
                ViCodigo.setText("");
                ViNombrem.setText("");
                Viemoji.setText("");
                ViPrecio.setText("");
            } else {
                Toast.makeText(this, "Error al eliminar el producto", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No se encontró el producto", Toast.LENGTH_LONG).show();
        }

        fila.close();
        bd.close();
    }

    public void IraPantllaB (View v){
        Intent intent = new Intent(this, pantallaBorrarP.class);
        startActivity(intent);
    }

}
