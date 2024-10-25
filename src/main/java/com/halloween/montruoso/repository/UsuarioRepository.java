package com.halloween.montruoso.repository;

import com.halloween.montruoso.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public UserDetails findByCorreoElectronico(String username);
}