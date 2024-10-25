package com.halloween.montruoso.services;

import com.halloween.montruoso.dto.DatosRegistroUsuario;
import com.halloween.montruoso.entidades.Usuario;
import com.halloween.montruoso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Usuario registrarUsuario(DatosRegistroUsuario datosRegistroUsuario) {

        Usuario usuario = new Usuario(datosRegistroUsuario);
        return usuarioRepo.save(usuario);
    }

    public Usuario obtenerPorCorreoElectronico(String username) {
        return (Usuario) usuarioRepo.findByCorreoElectronico(username);
    }
}
