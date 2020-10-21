package com.example.controldeseleccion3;

public class Titular {
    private String titulo1;
    private String titulo2;
    private int img;


    public Titular (String titulo1, String titulo2,int img){
        this.titulo1=titulo1;
        this.titulo2=titulo2;
        this.img = img;
    }


    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
