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
        System.out.println("Intentando autenticar usuario: " + datosAutenticacionUsuario.email());
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(), datosAutenticacionUsuario.clave());
        System.out.println("Autenticacion token "+ authenticationToken);
        Authentication usuarioAutenticado = authenticationManager.authenticate(authenticationToken);
        System.out.println("Usuario autenticado "+ usuarioAutenticado);
        String tokenJWT = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        System.out.println("Token JWT" + tokenJWT);
        DatosJWTtoken response = new DatosJWTtoken( ((Usuario) usuarioAutenticado.getPrincipal()).getId(),tokenJWT, ((Usuario) usuarioAutenticado.getPrincipal()).getNombre());
        System.out.println("Response "+response);
        return ResponseEntity.ok(response);
    }

}
