package com.example.examen1;

public class Ejemplo {
    String titulo, img1, img2;

    public Ejemplo(String titulo, String img1, String img2) {
        this.titulo = titulo;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
}
