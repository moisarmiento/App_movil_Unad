package com.example.webf1movil1704;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AssEmpleados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceso_control_m); // Layout correcto
    }

    // Método que se llama al hacer clic en el botón
    public void irAControlM(View v) {
        // Referencias a los campos de texto
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        // Obtén el texto ingresado
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validar credenciales
        if (username.equals("controlm") && password.equals("43210")) {
            // Credenciales correctas, redirige a otra actividad
            Intent intent = new Intent(this, pantallaM.class); // Asegúrate de que esta clase exista
            startActivity(intent);
        } else {
            // Credenciales incorrectas, muestra un mensaje de error
            Toast.makeText(this, "Usuario o contraseña inválida", Toast.LENGTH_SHORT).show();
        }
    }
}



