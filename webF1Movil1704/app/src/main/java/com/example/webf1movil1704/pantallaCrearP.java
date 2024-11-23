package com.example.webf1movil1704;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pantallaCrearP extends BaseActivityBD{

    //dbHelper admin; //*



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crearp); // Layout
        etID=findViewById(R.id.idEditText);
        etCodigo=findViewById(R.id.codeEditText);
        etNombrem=findViewById(R.id.nameEditText);
        etEmoji=findViewById(R.id.emojiSpinner);
        etPrecio=findViewById(R.id.valueEditText);
        //admin=new dbHelper(this,"dbProductos",null,1); //*


    }
    public void IrAmain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Método para agregar un producto
    public void agregarProducto(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();

        // Obtener valores de los campos
        String id = etID.getText().toString();
        String codigo = etCodigo.getText().toString();
        String nombre = etNombrem.getText().toString();
        String emoji = etEmoji.getSelectedItem().toString(); // Obtener selección del Spinner
        String valor = etPrecio.getText().toString();

        // Validar que los campos no estén vacíos
        if (id.isEmpty() || codigo.isEmpty() || nombre.isEmpty() || emoji.isEmpty() || valor.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear registro
        ContentValues registro = new ContentValues();
        registro.put("ID", id);
        registro.put("CodigoP", codigo);
        registro.put("NombreP", nombre);
        registro.put("EmojiP", emoji);
        registro.put("ValorP", valor);

        // Insertar en la base de datos
        long resultado = bd.insert("prosuctos", null, registro);
        bd.close();

        if (resultado != -1) {
            Toast.makeText(this, "Producto agregado correctamente", Toast.LENGTH_SHORT).show();

            // Limpiar los campos
            etID.setText("");
            etCodigo.setText("");
            etNombrem.setText("");
            etPrecio.setText("");
            etEmoji.setSelection(0); // Reiniciar selección del Spinner
        } else {
            Toast.makeText(this, "Error al guardar el producto", Toast.LENGTH_SHORT).show();
        }
    }


}
