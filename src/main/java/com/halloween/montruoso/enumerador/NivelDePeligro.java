package com.halloween.montruoso.enumerador;

public enum NivelDePeligro {
    BAJO("Bajo"),
    MEDIO("Medio"),
    ALTO("Alto"),
    EXTREMO("Extremo");

    private String nombre;

    NivelDePeligro(String nombre){
        this.nombre = nombre;
    }
}
