package com.example.tareaunidad3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivityInfo extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        menuItemSelected();
    }


    public void menuItemSelected(){
        bottomNavigationView = findViewById(R.id.menuNavigation);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.info){
                    Toast.makeText(MainActivityInfo.this, "Ya estás aquí", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.ruta) {
                    Intent intent = new Intent(MainActivityInfo.this, MainActivityRuta.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.salir) {
                    Intent intent = new Intent(MainActivityInfo.this, MainActivityInicioSesion.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.llamar) {
            Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:924281040"));
            startActivity(intento);
            return true;
        } else if (item.getItemId() == R.id.pagina) {
            Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iesocuatroabril.educarex.es/"));
            startActivity(intento);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}