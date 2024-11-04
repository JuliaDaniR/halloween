package com.halloween.montruoso.services;

import com.halloween.montruoso.dto.PuntajeUsuarioDTO;
import com.halloween.montruoso.repository.PuntajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuntajeService {

    @Autowired
    private PuntajeRepository puntajeRepository;

    public List<PuntajeUsuarioDTO> obtenerPuntajesPorDificultad() {
        return puntajeRepository.obtenerPuntajePorDificultad();
    }
    @Transactional(readOnly = true)
    public List<PuntajeUsuarioDTO> obtenerPuntajesPorIdUsuario(Long id) {
        return puntajeRepository.obtenerPuntajesPorIdUsuario(id);
    }
}
