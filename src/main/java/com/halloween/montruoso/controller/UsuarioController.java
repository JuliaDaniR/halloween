package com.halloween.montruoso.controller;

import com.halloween.montruoso.dto.DatosRegistroUsuario;
import com.halloween.montruoso.dto.DatosRespuestaUsuario;
import com.halloween.montruoso.entidades.Usuario;
import com.halloween.montruoso.services.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity registrarUsuario(@ModelAttribute DatosRegistroUsuario datosRegistroUsuario,
                                           UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioService.registrarUsuario(datosRegistroUsuario);

        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(
                usuario.getNombre(),
                usuario.getCorreoElectronico());

        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }
}