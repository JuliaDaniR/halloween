package com.halloween.montruoso.controller;

import com.halloween.montruoso.entidades.Usuario;
import com.halloween.montruoso.enumerador.*;
import com.halloween.montruoso.services.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Arrays;

@Controller
@SecurityRequirement(name = "bearer-key")
public class VistaController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarIndex(Model model) {

        return "index.html";
    }

    @GetMapping("/registrarUsuario")
    public String mostrarRegistro(Model model) {

        return "registro.html";
    }

    @GetMapping("/loguearUsuario")
    public String mostrarLogin(Model model) {

        return "login.html";
    }

    @GetMapping("/inicio")
    public String paginaInicio(Model model, Principal principal, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("No hay sesión activa.");
        } else {
            System.out.println("ID de sesión: " + session.getId());
        }
        System.out.println(session.getId()+ session.getAttributeNames());

//        if (principal == null) {
//            System.out.println("Usuario no autenticado, redirigiendo...");
//            return "redirect:/loguearUsuario";
//        }

        model.addAttribute("tiposMonstruo", Arrays.stream(TipoMonstruo.values()).toList());
        model.addAttribute("poderes", Arrays.stream(Poderes.values()).toList());
        model.addAttribute("debilidades", Arrays.stream(Debilidades.values()).toList());
        model.addAttribute("nivelesDePeligro", Arrays.stream(NivelDePeligro.values()).toList());

        return "inicio";
    }

    @GetMapping("/trivia")
    public String mostrarTrivia(Model model, Principal principal, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("No hay sesión activa.");
        } else {
            System.out.println("ID de sesión: " + session.getId());
        }
//
//        if (principal == null) {
//            System.out.println("Usuario no autenticado, redirigiendo...");
//            return "redirect:/loguearUsuario";
//        }
//
//        System.out.println("Principal " + principal.getName());
        model.addAttribute("dificultades", Arrays.stream(Dificultad.values()).toList());
        model.addAttribute("tipos", Arrays.stream(Tipo.values()).toList());

        return "trivia";
    }


}