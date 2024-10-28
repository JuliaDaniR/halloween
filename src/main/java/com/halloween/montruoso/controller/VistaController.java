package com.halloween.montruoso.controller;

import com.halloween.montruoso.enumerador.Debilidades;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.Poderes;
import com.halloween.montruoso.enumerador.TipoMonstruo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class VistaController {

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
    public String paginaInicio(Model model){
        model.addAttribute("tiposMonstruo", Arrays.stream(TipoMonstruo.values()).toList());
        model.addAttribute("poderes", Arrays.stream(Poderes.values()).toList());
        model.addAttribute("debilidades", Arrays.stream(Debilidades.values()).toList());
        model.addAttribute("nivelesDePeligro", Arrays.stream(NivelDePeligro.values()).toList());

        return  "inicio.html";
    }
}
