package com.halloween.montruoso.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutenticacionUsuario(String login ,
                                        @JsonAlias({"password","contraseña"})String clave) {
}
