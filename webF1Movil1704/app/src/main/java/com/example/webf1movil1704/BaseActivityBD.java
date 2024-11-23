package com.example.webf1movil1704;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BaseActivityBD  extends AppCompatActivity {

    protected EditText etID,etCodigo,etNombrem,etPrecio;
    protected Spinner etEmoji;
    protected dbHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inicializar dbHelper
        admin = new dbHelper(this, "dbProductos", null, 1);
    }


}
