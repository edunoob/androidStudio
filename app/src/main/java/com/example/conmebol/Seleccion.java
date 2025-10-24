package com.example.conmebol;

public class Seleccion {
    private String nombre;
    private String info;
    private int imagenId;

    // Constructor
    public Seleccion(String nombre, String info, int imagenId) {
        this.nombre = nombre;
        this.info = info;
        this.imagenId = imagenId;
    }

    // Métodos para acceder a los datos
    public String getNombre() {
        return nombre;
    }

    public String getInfo() {
        return info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public int getIdLogo() {
        return imagenId;
    }


}
