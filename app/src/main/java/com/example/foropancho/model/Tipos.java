package com.example.foropancho.model;

public class Tipos {
    String Tipo, Descripcion;

    @Override
    public String toString() {
        return "Tipos{" +
                "Tipo='" + Tipo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Tipos(String tipo, String descripcion) {
        Tipo = tipo;
        Descripcion = descripcion;
    }

    public Tipos() {
    }
}
