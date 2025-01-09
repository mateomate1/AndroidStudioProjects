package com.app.routetogether;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ruta {
    String imgpath, nombre, direccionRecogida, direccionFinal;
    boolean[] dias;
    String hora;

    public Ruta(){}

    public Ruta(String imgpath, String nombre, String direccionRecogida, String direccionFinal, boolean[] dias, String hora) {
        this.imgpath = imgpath;
        this.nombre = nombre;
        this.direccionRecogida = direccionRecogida;
        this.direccionFinal = direccionFinal;
        this.dias = dias;
        this.hora = hora;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionRecogida() {
        return direccionRecogida;
    }

    public void setDireccionRecogida(String direccionRecogida) {
        this.direccionRecogida = direccionRecogida;
    }

    public String getDireccionFinal() {
        return direccionFinal;
    }

    public void setDireccionFinal(String direccionFinal) {
        this.direccionFinal = direccionFinal;
    }

    public boolean[] getDias() {
        return dias;
    }

    public void setDias(boolean[] dias) {
        this.dias = dias;
    }
    public String getHora() {return hora;}
    public void setHora(String hora) {
        this.hora = hora;
    }
}
