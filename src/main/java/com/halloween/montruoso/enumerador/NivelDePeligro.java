package com.halloween.montruoso.enumerador;

import java.util.Comparator;

public enum NivelDePeligro {
    BAJO("Bajo", 1),
    MEDIO("Medio", 2),
    ALTO("Alto", 3),
    EXTREMO("Extremo", 4);

    private String nombre;
    private int orden;

    NivelDePeligro(String nombre, int orden) {
        this.nombre = nombre;
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOrden() {
        return orden;
    }

    public static Comparator<NivelDePeligro> comparadorPorOrden() {
        return Comparator.comparingInt(NivelDePeligro::getOrden);
    }
}
