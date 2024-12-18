package com.example.tareaunidad3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivityRuta extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ruta);
        menuItemSelected();
    }

    public void menuItemSelected(){
        bottomNavigationView = findViewById(R.id.menuNavigation);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.info){
                    Intent intent = new Intent(MainActivityRuta.this, MainActivityInfo.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.ruta) {
                    Toast.makeText(MainActivityRuta.this, "Ya estás aquí", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.salir) {
                    Intent intent = new Intent(MainActivityRuta.this, MainActivityInicioSesion.class);
                    startActivity(intent);
                }
            }
        });

    }
}