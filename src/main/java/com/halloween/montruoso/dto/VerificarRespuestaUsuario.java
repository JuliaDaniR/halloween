package com.halloween.montruoso.dto;

import com.halloween.montruoso.entidades.Usuario;

public record VerificarRespuestaUsuario(Long preguntaId, Long respuestaId, Usuario usuarioAutenticado) {
}
