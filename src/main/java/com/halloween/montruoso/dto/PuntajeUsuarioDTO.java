package com.halloween.montruoso.dto;

public record PuntajeUsuarioDTO(String nombreUsuario, int puntosFacil, int puntosMedio, int puntosDificil) {
    public int totalPuntos() {
        return puntosFacil + puntosMedio + puntosDificil;
    }
}

