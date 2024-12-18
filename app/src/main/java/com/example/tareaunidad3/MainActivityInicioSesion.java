package com.example.tareaunidad3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivityInicioSesion extends AppCompatActivity {
    EditText usuario, contrasena;
    Button iniciar, registrar;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio_sesion);

        usuario = (EditText) findViewById(R.id.editTextTextUsuarioInicio);
        contrasena = findViewById(R.id.editTextTextPasswordInicio);
        iniciar = findViewById(R.id.buttonIniciar);
        registrar = findViewById(R.id.buttonRegistrarse);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String string = prefs.getString("correo", "");

        usuario.setText(string);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean iniciar = iniciarSesion(usuario.getText().toString(), contrasena.getText().toString());
                if (iniciar) {
                    SharedPreferences.Editor editor = prefs.edit();
                    correo = usuario.getText().toString();
                    editor.putString("correo", correo);
                    editor.apply();
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityInicioSesion.this, MainActivityRegistro.class);
                startActivity(intent);
            }
        });
    }

    private boolean iniciarSesion(String usuario, String contrasena) {
        String usuarioArchivo = "";
        String contrasenaArchivo = "";
        try {
            // Abrir el archivo para lectura
            InputStreamReader in = new InputStreamReader(openFileInput("registro.txt"));
            BufferedReader reader = new BufferedReader(in);

            // Leer el contenido del archivo línea por línea
            StringBuilder stringBuilder = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                stringBuilder.append(linea).append("\n");
                String[] split = linea.split(";");
                usuarioArchivo = split[0];
                contrasenaArchivo = split[1];
                if(usuarioArchivo.equals(usuario) && contrasenaArchivo.equals(contrasena)){
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    return false;
                }

            }
            // Cerrar el archivo
            in.close();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe
            Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_SHORT).show();
            return false;
        } catch (IOException e) {
            // Si ocurre un error durante la lectura
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
            return false;
        }
        return false;
    }
}