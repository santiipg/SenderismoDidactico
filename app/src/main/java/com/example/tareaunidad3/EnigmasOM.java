package com.example.tareaunidad3;

import java.util.ArrayList;

public class EnigmasOM {

    public static ArrayList<Enigma> getEnigmasMatematicos() {
        ArrayList<Enigma> enigmas = new ArrayList<>();
        enigmas.add(new Enigma(1, "4 * 2 + 6", "14"));
        enigmas.add(new Enigma(2, "9 / 3 + 3 * (2)^3", "27"));
        enigmas.add(new Enigma(3, "5 * 6 -14", "26"));
        enigmas.add(new Enigma(4, "2x + 3x -10 = 0", "x = 2"));
        return enigmas;
    }

    public static ArrayList<Enigma> getEnigmasFisicos() {
        ArrayList<Enigma> enigmas = new ArrayList<>();
        enigmas.add(new Enigma(1, "¿Qué es la gravedad?", "Una fuerza"));
        enigmas.add(new Enigma(2, "¿Cuál es la velocidad de la luz?", "300.000.000 m/s"));
        enigmas.add(new Enigma(3, "¿Cuál es la fuerza de la gravedad?", "9.8 m/s^2"));
        enigmas.add(new Enigma(4, "¿Qué produce un imán?", "Una fuerza electromagnética"));
        return enigmas;
    }

    public static ArrayList<Enigma> getEnigmasQuimicos() {
        ArrayList<Enigma> enigmas = new ArrayList<>();
        enigmas.add(new Enigma(1, "¿Cuál es la fórmula química del agua?", "H2O"));
        enigmas.add(new Enigma(2, "¿Cuál es el símbolo químico del oro?", "Au"));
        enigmas.add(new Enigma(3, "¿Cuál es el elemento más abundante en la Tierra?", "Oxígeno"));
        enigmas.add(new Enigma(4, "¿Cuál es el elemento más pesado en la tabla periódica?", "Plomo"));
        return enigmas;
    }

    public static ArrayList<Enigma> getEnigmasBiologicos() {
        ArrayList<Enigma> enigmas = new ArrayList<>();
        enigmas.add(new Enigma(1, "¿Qué es la célula?", "Es la unidad básica de la vida"));
        enigmas.add(new Enigma(2, "¿Cómo se llama el proceso por el cual las plantas producen su alimento?", "Fotosíntesis"));
        enigmas.add(new Enigma(3, "¿Cuál es la molécula que contiene la información genética?", "ADN"));
        enigmas.add(new Enigma(4, "¿Qué órgano bombea la sangre en el cuerpo humano?", "Corazón"));
        return enigmas;
    }
}
