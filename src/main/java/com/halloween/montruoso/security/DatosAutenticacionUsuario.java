package com.halloween.montruoso.security;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutenticacionUsuario(String email ,
                                        @JsonAlias({"password","contraseña"})String clave) {
}
