package com.example.tareaunidad3;

import android.content.Intent;
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

import java.io.OutputStreamWriter;

public class MainActivityRegistro extends AppCompatActivity {
    EditText usuario, contrasena;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);

        usuario = findViewById(R.id.editTextTextUsuarioRegistro);
        contrasena = findViewById(R.id.editTextTextPasswordRegistro);
        registrar = findViewById(R.id.buttonRegistro2);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().isEmpty() || contrasena.getText().toString().isEmpty()){
                    Toast.makeText(MainActivityRegistro.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    registrarArchivo();
                    if(registrarArchivo()){
                        Intent intent = new Intent(MainActivityRegistro.this, MainActivityInicioSesion.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivityRegistro.this, "Error al registrarse", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    private boolean registrarArchivo() {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("registro.txt", MODE_PRIVATE));
            archivo.write(usuario.getText().toString()+";"+contrasena.getText().toString());
            archivo.close();
            return true;

        }catch (Exception e){
            Toast.makeText(this, "Exception "+e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}