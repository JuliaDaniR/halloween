package com.halloween.montruoso.services;

import com.halloween.montruoso.dto.DatosRegistroMonstruo;
import com.halloween.montruoso.dto.DatosRespuestaMonstruo;
import com.halloween.montruoso.entidades.Monstruo;
import com.halloween.montruoso.enumerador.Debilidades;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.Poderes;
import com.halloween.montruoso.enumerador.TipoMonstruo;
import com.halloween.montruoso.repository.MonstruoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MonstruoService {

    @Autowired
    private MonstruoRepository monstruoRepo;

    public DatosRespuestaMonstruo registrarMonstruo(DatosRegistroMonstruo datosRegistroMonstruo) {
        Monstruo monstruo = monstruoRepo.save(new Monstruo(datosRegistroMonstruo));
        return new DatosRespuestaMonstruo(monstruo);
    }

    public Page<DatosRespuestaMonstruo> listarMonstruos(Pageable paginacion) {
        Page<Monstruo> monstruos = monstruoRepo.findAll(paginacion);
        return monstruos.map(DatosRespuestaMonstruo::new);
    }

    public DatosRespuestaMonstruo actualizarMonstruo(Long id, DatosRegistroMonstruo.DatosActualizarMonstruo datosActualizarMonstruo) {
        Monstruo monstruo = monstruoRepo.getReferenceById(id);
        monstruo.actualizarDatos(datosActualizarMonstruo);
        return new DatosRespuestaMonstruo(monstruo);
    }

    public boolean eliminarMonstruo(Long id) {
        Optional<Monstruo> monstruo = monstruoRepo.findById(id);
        if (monstruo.isEmpty()) {
            return false;
        }
        monstruoRepo.delete(monstruo.get());
        return true;
    }

    public DatosRespuestaMonstruo retornarDatosMonstruo(Long id) {
        Optional<Monstruo> optionalMonstruo = monstruoRepo.findById(id);
        return optionalMonstruo.map(DatosRespuestaMonstruo::new).orElse(null);
    }

    public Page<DatosRespuestaMonstruo> listarMonstruosPorNivelDePeligro(Pageable pageable, String orden) {
        Page<Monstruo> listaMonstruos;

        if ("desc".equalsIgnoreCase(orden)) {
            listaMonstruos = monstruoRepo.findAllByOrderByNivelDePeligroDesc(pageable);
        } else {
            listaMonstruos = monstruoRepo.findAllByOrderByNivelDePeligroAsc(pageable);
        }

        return listaMonstruos.map(DatosRespuestaMonstruo::new);
    }

    public Page<Monstruo> buscarMonstruosPorAtributos(String nombre, TipoMonstruo tipo, NivelDePeligro nivelDePeligro, Debilidades debilidad, Poderes poder, Pageable paginacion) {
        Specification<Monstruo> specs = Specification.where(null);

        if (nombre != null && !nombre.isEmpty()) {
            specs = specs.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
        }
        if (tipo != null) {
            specs = specs.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("tipo"), tipo));
        }
        if (nivelDePeligro != null) {
            specs = specs.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("nivelDePeligro"), nivelDePeligro));
        }
        if (debilidad != null) {
            specs = specs.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.isMember(debilidad, root.get("debilidades")));
        }
        if (poder != null) {
            specs = specs.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.isMember(poder, root.get("poderes")));
        }
        return monstruoRepo.findAll(specs, paginacion);
    }

    public Map<String, Long> obtenerEstadisticasPorNivelDePeligro() {
        List<Object[]> resultados = monstruoRepo.contarMonstruosPorNivelDePeligro();
        Map<String, Long> estadisticas = new HashMap<>();
        for (Object[] resultado : resultados) {
            NivelDePeligro nivel = (NivelDePeligro) resultado[0];
            Long cantidad = (Long) resultado[1];
            estadisticas.put(nivel.getNombre(), cantidad);
        }
        return estadisticas;
    }

    public Map<String, Long> obtenerEstadisticasPorTipo() {
        List<Object[]> resultados = monstruoRepo.contarMonstruosPorTipo();
        Map<String, Long> estadisticas = new HashMap<>();
        for (Object[] resultado : resultados) {
            TipoMonstruo tipo = (TipoMonstruo) resultado[0];
            Long cantidad = (Long) resultado[1];
            estadisticas.put(tipo.getNombre(), cantidad);
        }
        return estadisticas;
    }
    public Map<String, Long> obtenerEstadisticasPorPoder() {
        List<Object[]> resultados = monstruoRepo.contarMonstruosPorPoder();
        Map<String, Long> estadisticas = new HashMap<>();
        for (Object[] resultado : resultados) {
            Poderes poder = (Poderes) resultado[0];
            Long cantidad = (Long) resultado[1];
            estadisticas.put(poder.getNombre(), cantidad);
        }
        return estadisticas;
    }

    public Monstruo obtenerMonstruoAleatorio() {
        long count = monstruoRepo.count();
        int randomIndex = new Random().nextInt((int) count);
        Page<Monstruo> resultado = monstruoRepo.findAll(PageRequest.of(randomIndex, 1));
        return resultado.hasContent() ? resultado.getContent().get(0) : null;
    }

    public List<Monstruo> listarTopMonstruosPeligrosos() {
        return monstruoRepo.findTop10ByOrderByNivelDeTerrorDesc();
    }

    public List<Monstruo> buscarMonstruosPorHabilidad(String habilidadEspecial) {
        return monstruoRepo.buscarPorHabilidadEspecial(habilidadEspecial);
    }
}


