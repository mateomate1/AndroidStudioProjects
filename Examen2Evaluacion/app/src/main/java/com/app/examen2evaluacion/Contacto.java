package com.app.examen2evaluacion;

public class Contacto {
private String nombre, telefono, email;
private int resource;
    public Contacto(String nombre, String telefono, String email, int resource) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.resource = resource;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
