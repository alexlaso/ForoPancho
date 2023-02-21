package com.example.foropancho.model;

public class Users {
    String Correo, Nombre, Nickname;

    @Override
    public String toString() {
        return "Users{" +
                "Correo='" + Correo + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Nickname='" + Nickname + '\'' +
                '}';
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public Users(String correo, String nombre, String nickname) {
        Correo = correo;
        Nombre = nombre;
        Nickname = nickname;
    }

    public Users() {
    }
}
