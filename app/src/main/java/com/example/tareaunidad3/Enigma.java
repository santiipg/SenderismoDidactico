package com.example.tareaunidad3;

public class Enigma {

    private int id;
    private String titulo;
    private String solucion;

    public Enigma(int id, String titulo, String solucion) {
        this.id = id;
        this.titulo = titulo;
        this.solucion = solucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
}
