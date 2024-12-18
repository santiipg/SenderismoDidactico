package com.example.tareaunidad3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarMenu;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    ArrayList<Ruta> rutas;
    RecyclerView recyclerView;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rutas = RutasOM.getRutas();
        loadAdapterRecyclerView();
        menuItemSelected();

    }
    public void loadAdapterRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyReclyclerViewAdapter adapter = new MyReclyclerViewAdapter(this, rutas, this);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View activista, int position) {
        Toast.makeText(this, "Has seleccionado el elemento" + position, Toast.LENGTH_SHORT).show();
        if(position == 0){
            Intent intent = new Intent(this, MainActivityEnigma.class);
            intent.putExtra("enigmas", "mates");
            startActivity(intent);
        } else if (position == 1) {
            Intent intent = new Intent(this, MainActivityEnigma.class);
            intent.putExtra("enigmas", "fisica");
            startActivity(intent);
        } else if (position == 2) {
            Intent intent = new Intent(this, MainActivityEnigma.class);
            intent.putExtra("enigmas", "quimica");
            startActivity(intent);
        } else if (position == 3) {
            Intent intent = new Intent(this, MainActivityEnigma.class);
            intent.putExtra("enigmas", "biologia");
            startActivity(intent);
        }
    }

    public void menuItemSelected(){
        bottomNavigationView = findViewById(R.id.menuNavigation);
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.info){
                    Intent intent = new Intent(MainActivity.this, MainActivityInfo.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.ruta) {
                    Intent intent = new Intent(MainActivity.this, MainActivityRuta.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.salir) {
                    Intent intent = new Intent(MainActivity.this, MainActivityInicioSesion.class);
                    startActivity(intent);
                }
            }
        });

    }
}