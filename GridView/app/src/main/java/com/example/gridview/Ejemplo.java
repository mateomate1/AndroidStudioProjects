package com.example.gridview;

public class Ejemplo {
    private String titulo, subtitulo, urlFoto;
    private int numeroEjemplo;

    public Ejemplo(String titulo, String subtitulo, String urlFoto, int numeroEjemplo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.urlFoto = urlFoto;
        this.numeroEjemplo = numeroEjemplo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getNumeroEjemplo() {
        return numeroEjemplo;
    }

    public void setNumeroEjemplo(int numeroEjemplo) {
        this.numeroEjemplo = numeroEjemplo;
    }
}
