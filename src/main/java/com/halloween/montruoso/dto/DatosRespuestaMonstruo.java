package com.halloween.montruoso.dto;

import com.halloween.montruoso.entidades.Monstruo;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.TipoMonstruo;

public record DatosRespuestaMonstruo(
        Long id,
        String nombre,
        TipoMonstruo tipo,
        int nivelDeTerror,
        String poderes,
        String debilidades,
        String descripcion,
        String imagenUrl,
        NivelDePeligro nivelDePeligro,
        String habilidadesEspeciales,
        String historia,
        String apariencia,
        String sonido
) {
    public DatosRespuestaMonstruo(Monstruo monstruo) {
        this(
                monstruo.getId(),
                monstruo.getNombre(),
                monstruo.getTipo(),
                monstruo.getNivelDeTerror(),
                String.join(", ", monstruo.getPoderes().stream().map(Enum::name).toList()),
                String.join(", ", monstruo.getDebilidades().stream().map(Enum::name).toList()),
                monstruo.getDescripcion(),
                monstruo.getImagenUrl(),
                monstruo.getNivelDePeligro(),
                String.join(", ", monstruo.getHabilidadesEspeciales()),
                monstruo.getHistoria(),
                monstruo.getApariencia(),
                monstruo.getSonido()
        );
    }
}
