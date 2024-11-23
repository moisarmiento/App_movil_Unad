/*
package com.example.webf1movil1704;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class sqlite extends AppCompatActivity {
    EditText etPlaca,etMarca, etModelo, etPrecio;
    adminSqliteOpenHelper admin;
    final int CAPTURA_IMAGEN=1;
    ImageView imagV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        etPlaca=findViewById(R.id.txtPlaca);
        etMarca=findViewById(R.id.txtMarca);
        etModelo=findViewById(R.id.txtModelo);
        etPrecio=findViewById(R.id.txtPrecio);
        admin= new adminSqliteOpenHelper(this, "bdprueba", null,1);
        imagV=findViewById(R.id.ivFotoV);
    }
    public void agregar(View v){
        SQLiteDatabase bd=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("placa", etPlaca.getText().toString());
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());
        registro.put("nomArchivo", etPlaca.getText().toString());
        bd.insert( "vehiculos", null, registro);
        imagV.setDrawingCacheEnabled(true);
        Bitmap imagenV = Bitmap.createBitmap(imagV.getDrawingCache());
        guardarImagenEnMemoria(imagenV,etPlaca.getText().toString());
        etPlaca.setText("");
        etMarca.setText("");
        etModelo.setText("");
        etPrecio.setText("");
        imagV.setImageDrawable(null);
        bd.close();
        Toast.makeText(this, "el vehiculo se ha guardado correctamente", Toast.LENGTH_LONG).show();

    }
    public void consultarPlaca(View v){
        String placa=etPlaca.getText().toString();
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("SELECT marca,modelo,precio,nomArchivo FROM vehiculos where placa='"+placa+"'",null);
        if (fila.moveToFirst()){
            etMarca.setText(fila.getString(0));
            etModelo.setText(fila.getString(1));
            etPrecio.setText(fila.getString(2));
            Bitmap imagenCargada = cargarImagenDesdeMemoria(fila.getString(3));
            imagV.setImageBitmap(imagenCargada);
        }else{
            Toast.makeText(this, "el vehiculo con esa placa no existe", Toast.LENGTH_LONG).show();

        }
        bd.close();
    }
    public void borrar(View v){
        SQLiteDatabase bd=admin.getWritableDatabase();
        String placa=etPlaca.getText().toString();

        int cant=bd.delete("vehiculos","placa='"+placa+"'",null);
        if (cant==1){
            etPlaca.setText("");
            etMarca.setText("");
            etModelo.setText("");
            etPrecio.setText("");
            Toast.makeText(this, "el vehiculo ha sido borrado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "el vehiculo no existe", Toast.LENGTH_LONG).show();
        }
        bd.close();
    }
    public void modificar(View v){
        SQLiteDatabase bd=admin.getWritableDatabase();
        String placa=etPlaca.getText().toString();
        ContentValues registro=new ContentValues();
        registro.put("marca", etMarca.getText().toString());
        registro.put("modelo", etModelo.getText().toString());
        registro.put("precio", etPrecio.getText().toString());

        int cant=bd.update("vehiculos", registro, "placa='"+placa+"'",null);
        if (cant==1){
            imagV.setDrawingCacheEnabled(true);
            Bitmap imagenV = Bitmap.createBitmap(imagV.getDrawingCache());
            guardarImagenEnMemoria(imagenV,etPlaca.getText().toString());
            etPlaca.setText("");
            etMarca.setText("");
            etModelo.setText("");
            etPrecio.setText("");
            imagV.setImageDrawable(null);
            Toast.makeText(this, "el vehiculo ha sido modificado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "el vehiculo no existe", Toast.LENGTH_LONG).show();
        }
        bd.close();
    }
    public void verTodos(View v){
        Intent intent = new Intent(this, listaVehiculos.class);
        startActivity(intent);
    }
    public void tomarFoto(View v){
        Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(in,CAPTURA_IMAGEN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAPTURA_IMAGEN && resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap bit1=(Bitmap)extras.get("data");
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            Bitmap bitmapRotado = Bitmap.createBitmap(bit1, 0, 0, bit1.getWidth(), bit1.getHeight(), matrix, true);
            imagV.setImageBitmap(bitmapRotado);


        }
    }
    public void guardarImagenEnMemoria(Bitmap imagenBitmap, String nombreArchivo) {
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File archivoImagen = new File(directorio, nombreArchivo + ".jpg");

        try (FileOutputStream fos = new FileOutputStream(archivoImagen)) {
            imagenBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
             fos.flush();

            Toast.makeText(this, "Imagen guardada en: " + archivoImagen.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar la imagen", Toast.LENGTH_SHORT).show();
        }

    }

    public Bitmap cargarImagenDesdeMemoria(String nombreArchivo) {
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File archivoImagen = new File(directorio, nombreArchivo + ".jpg");

        if (archivoImagen.exists()) {
            return BitmapFactory.decodeFile(archivoImagen.getAbsolutePath());
        } else {
            Toast.makeText(this, "Imagen no encontrada", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
 */