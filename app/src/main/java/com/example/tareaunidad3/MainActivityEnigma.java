package com.example.tareaunidad3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivityEnigma extends AppCompatActivity {

    Button button;
    LinearLayout layout1, layout2, layout3, layout4;
    int contador=0;
    Button botonEnviar;
    ImageButton botonVolver;
    TextView textView, contadorView;
    EditText respuesta;
    ArrayList<Enigma> enigmas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_enigma_matematico);

        contadorView = findViewById(R.id.textView16);

        Intent intent = getIntent();
        String enigmasString = intent.getStringExtra("enigmas");
        if(enigmasString.equals("mates")){
            enigmas = EnigmasOM.getEnigmasMatematicos();
        } else if (enigmasString.equals("fisica")) {
            enigmas = EnigmasOM.getEnigmasFisicos();
        } else if (enigmasString.equals("quimica")) {
            enigmas = EnigmasOM.getEnigmasQuimicos();
        } else if (enigmasString.equals("biologia")) {
            enigmas = EnigmasOM.getEnigmasBiologicos();
        }


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.INVISIBLE);
                layout1 = findViewById(R.id.enigmaMates1);
                layout1.setVisibility(View.VISIBLE);
                textView = findViewById(R.id.textView4);
                respuesta = findViewById(R.id.editTextText);
                textView.setText(enigmas.get(0).getTitulo());

                botonEnviar = findViewById(R.id.button2);
                botonEnviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        layout1.setVisibility(View.INVISIBLE);
                        if(respuesta.getText().toString().equals(enigmas.get(0).getSolucion())){
                            contador++;
                        }
                        layout2 = findViewById(R.id.enigmaMates2);
                        layout2.setVisibility(View.VISIBLE);
                        textView = findViewById(R.id.textView8);
                        textView.setText(enigmas.get(1).getTitulo());
                        respuesta = findViewById(R.id.editTextText2);

                        botonEnviar = findViewById(R.id.button4);
                        botonEnviar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                layout2.setVisibility(View.INVISIBLE);
                                if(respuesta.getText().toString().equals(enigmas.get(1).getSolucion())){
                                    contador++;
                                }
                                layout3 = findViewById(R.id.enigmaMates3);
                                layout3.setVisibility(View.VISIBLE);
                                textView = findViewById(R.id.textView12);
                                textView.setText(enigmas.get(2).getTitulo());
                                respuesta = findViewById(R.id.editTextText3);
                                botonEnviar=findViewById(R.id.button3);
                                botonEnviar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layout3.setVisibility(View.INVISIBLE);
                                        if(respuesta.getText().toString().equals(enigmas.get(2).getSolucion())){
                                            contador++;
                                        }
                                        layout4 = findViewById(R.id.enigmaMates4);
                                        layout4.setVisibility(View.VISIBLE);
                                        textView = findViewById(R.id.textView14);
                                        textView.setText(enigmas.get(3).getTitulo());
                                        respuesta = findViewById(R.id.editTextText4);
                                        botonEnviar=findViewById(R.id.button6);
                                        botonEnviar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                layout4.setVisibility(View.INVISIBLE);
                                                if(respuesta.getText().toString().equals(enigmas.get(3).getSolucion())){
                                                    contador++;
                                                }
                                                contadorView.setText("Has acertado "+contador+" de 4");

                                            }
                                        });

                                    }
                                });

                            }
                        });
                    }
                });



            }
        });
        botonVolver = findViewById(R.id.imageButton2);
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}