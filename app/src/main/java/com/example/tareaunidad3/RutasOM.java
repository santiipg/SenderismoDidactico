package com.example.tareaunidad3;

import java.util.ArrayList;

public class RutasOM {

    public static ArrayList<Ruta> getRutas() {
        ArrayList<Ruta> rutas = new ArrayList<>();
        rutas.add(new Ruta("Matemática", R.mipmap.ic_launcher_matematica_foreground));
        rutas.add(new Ruta("Física", R.mipmap.ic_launcher_fisica_foreground));
        rutas.add(new Ruta("Química", R.mipmap.ic_launcher_quimica_foreground));
        rutas.add(new Ruta("Biología", R.mipmap.ic_launcher_biologia_foreground));
        return rutas;
    }
}
