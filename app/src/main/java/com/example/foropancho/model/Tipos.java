package com.example.foropancho.model;

public class Tipos {
    String Titulo, Descripcion;

    @Override
    public String toString() {
        return "Tipos{" +
                "Titulo='" + Titulo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Tipos(String titulo, String descripcion) {
        Titulo = titulo;
        Descripcion = descripcion;
    }

    public Tipos() {
    }
}
