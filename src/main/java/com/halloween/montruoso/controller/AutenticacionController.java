package com.halloween.montruoso.controller;


import com.halloween.montruoso.entidades.Usuario;
import com.halloween.montruoso.security.DatosAutenticacionUsuario;
import com.halloween.montruoso.security.DatosJWTtoken;
import com.halloween.montruoso.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTtoken> autenticarUsuario(@RequestBody DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(), datosAutenticacionUsuario.clave());
        Authentication usuarioAutenticado = authenticationManager.authenticate(authenticationToken);
        String tokenJWT = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        DatosJWTtoken response = new DatosJWTtoken(tokenJWT, ((Usuario) usuarioAutenticado.getPrincipal()).getNombre());
        return ResponseEntity.ok(response);
    }

}
