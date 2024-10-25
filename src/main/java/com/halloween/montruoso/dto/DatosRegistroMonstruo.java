package com.halloween.montruoso.dto;

import com.halloween.montruoso.enumerador.Debilidades;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.Poderes;
import com.halloween.montruoso.enumerador.TipoMonstruo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistroMonstruo(

       @NotBlank String nombre,
       @NotBlank TipoMonstruo tipo,
       @NotBlank Integer nivelDeTerror,
       @NotBlank List<Poderes> poderes,
       @NotBlank List<Debilidades> debilidades,
       @NotBlank String descripcion,
       @NotBlank String imagenUrl,
       @NotBlank NivelDePeligro nivelDePeligro,
       @NotBlank List<String> habilidadesEspeciales,
       @NotBlank String historia,
       @NotBlank String apariencia,
       @NotBlank String sonido
) {

    public static record DatosActualizarMonstruo(
            @NotNull Long id,
            String nombre,
            TipoMonstruo tipo,
            int nivelDeTerror,
            List<Poderes> poderes,
            List<Debilidades> debilidades,
            String descripcion,
            String imagenUrl,
            NivelDePeligro nivelDePeligro,
            List<String> habilidadesEspeciales,
            String historia,
            String apariencia,
            String sonido
    ){
    }
}
