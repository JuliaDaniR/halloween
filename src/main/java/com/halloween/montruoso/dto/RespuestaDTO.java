package com.halloween.montruoso.dto;

import com.halloween.montruoso.entidades.Respuesta;

public record RespuestaDTO(
        Long id,
        String texto,
        boolean esCorrecta
) {
    public RespuestaDTO(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getTexto(),
                respuesta.isEsCorrecta()
        );
    }
}
