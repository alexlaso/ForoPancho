package com.example.foropancho.model;

public class Post {
    String Creador;
    String Tipo;
    String TituloPost, Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Creador=" + Creador +
                ", Tipos=" + Tipo +
                ", TituloPost='" + TituloPost + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
    public String getTituloPost() {
        return TituloPost;
    }

    public void setTituloPost(String tituloPost) {
        TituloPost = tituloPost;
    }

    public Post(String creador, String tipo, String tituloPost, String descripcion) {
        this.Creador = creador;
        Tipo = tipo;
        TituloPost = tituloPost;
        Descripcion = descripcion;
    }

    public String getCreador() {
        return Creador;
    }

    public void setCreador(String creador) {
        this.Creador = creador;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Post() {
    }
}
