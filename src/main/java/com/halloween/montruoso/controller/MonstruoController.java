package com.halloween.montruoso.controller;

import com.halloween.montruoso.dto.DatosRegistroMonstruo;
import com.halloween.montruoso.dto.DatosRespuestaMonstruo;
import com.halloween.montruoso.entidades.Monstruo;
import com.halloween.montruoso.enumerador.Debilidades;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.Poderes;
import com.halloween.montruoso.enumerador.TipoMonstruo;
import com.halloween.montruoso.services.MonstruoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URI;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/monstruos")
@SecurityRequirement(name = "bearer-key")
public class MonstruoController {

    @Autowired
    private MonstruoService monstruoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaMonstruo> registrarMonstruo(
            @RequestBody @Valid DatosRegistroMonstruo datosRegistroMonstruo,
            UriComponentsBuilder uriComponentsBuilder) {

        DatosRespuestaMonstruo datosRespuestaMonstruo = monstruoService.registrarMonstruo(datosRegistroMonstruo);

        URI url = uriComponentsBuilder.path("/monstruos/{id}").buildAndExpand(datosRespuestaMonstruo.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMonstruo);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaMonstruo>> listarMonstruos(@PageableDefault(size = 10) Pageable paginacion) {
        Page<DatosRespuestaMonstruo> respuestaMonstruos = monstruoService.listarMonstruos(paginacion);
        return ResponseEntity.ok(respuestaMonstruos);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaMonstruo> actualizarMonstruo(@PathVariable Long id,
                                                                     @RequestBody @Valid DatosRegistroMonstruo.DatosActualizarMonstruo datosActualizarMonstruo) {
        DatosRespuestaMonstruo datosRespuestaMonstruo = monstruoService.actualizarMonstruo(id, datosActualizarMonstruo);
        return ResponseEntity.ok(datosRespuestaMonstruo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarMonstruo(@PathVariable Long id) {
        boolean eliminado = monstruoService.eliminarMonstruo(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El monstruo con ID " + id + " no fue encontrado.");
        }
        return ResponseEntity.ok("El monstruo con ID " + id + " fue eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornarDatosMonstruo(@PathVariable Long id) {
        DatosRespuestaMonstruo datosMonstruo = monstruoService.retornarDatosMonstruo(id);
        if (datosMonstruo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El monstruo con ID " + id + " no fue encontrado.");
        }
        return ResponseEntity.ok(datosMonstruo);
    }

    @GetMapping("/nivelPeligro")
    public ResponseEntity<Page<DatosRespuestaMonstruo>> listarMonstruosPorNivelDePeligro(
            @PageableDefault(size = 10) Pageable paginacion,
            @RequestParam(required = false, defaultValue = "asc") String orden) {

        Page<DatosRespuestaMonstruo> datosMonstruos = monstruoService.listarMonstruosPorNivelDePeligro(paginacion, orden);

        if (datosMonstruos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(datosMonstruos);
    }
    @GetMapping("/buscarPorAtributos")
    public ResponseEntity<Page<Monstruo>> listarMonstruosPorAtributos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) TipoMonstruo tipo,
            @RequestParam(required = false) NivelDePeligro nivelDePeligro,
            @RequestParam(required = false) Debilidades debilidad,
            @RequestParam(required = false) Poderes poder,
            @PageableDefault(size = 10) Pageable paginacion) {

        Page<Monstruo> monstruos = monstruoService.buscarMonstruosPorAtributos(nombre, tipo, nivelDePeligro, debilidad, poder, paginacion);

        return ResponseEntity.ok(monstruos);
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Map<String, Long>>> obtenerEstadisticas() {
        Map<String, Map<String, Long>> estadisticas = new HashMap<>();

        Map<String, Long> estadisticasPorNivelDePeligro = monstruoService.obtenerEstadisticasPorNivelDePeligro();
        estadisticas.put("Por nivel de peligro: ", estadisticasPorNivelDePeligro);

        Map<String, Long> estadisticasPorTipo = monstruoService.obtenerEstadisticasPorTipo();
        estadisticas.put("Por Tipo: ", estadisticasPorTipo);

        Map<String, Long> estadisticasPorPoder = monstruoService.obtenerEstadisticasPorPoder();
        estadisticas.put("Por Poder: ", estadisticasPorPoder);

        return ResponseEntity.ok(estadisticas);
    }

    @GetMapping("/aleatorio")
    public ResponseEntity<Monstruo> obtenerMonstruoAleatorio() {
        Monstruo monstruo = monstruoService.obtenerMonstruoAleatorio();
        if (monstruo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return ResponseEntity.ok(monstruo);
    }

    @GetMapping("/top10MasTerrorificos")
    public ResponseEntity<List<Monstruo>> listarTopMonstruosPeligrosos() {
        List<Monstruo> monstruosPeligrosos = monstruoService.listarTopMonstruosPeligrosos();
        return ResponseEntity.ok(monstruosPeligrosos);
    }

    @GetMapping("/buscarPorHabilidadEspecial")
    public ResponseEntity<List<Monstruo>> listarMonstruosPorHabilidad(
            @RequestParam String habilidadEspecial) {

        List<Monstruo> monstruos = monstruoService.buscarMonstruosPorHabilidad(habilidadEspecial);
        return ResponseEntity.ok(monstruos);
    }

    @GetMapping("/comparar")
    public ResponseEntity<Map<String, Object>> compararMonstruos(
            @RequestParam Long idMonstruo1, @RequestParam Long idMonstruo2) {

        DatosRespuestaMonstruo monstruo1 = monstruoService.retornarDatosMonstruo(idMonstruo1);
        DatosRespuestaMonstruo monstruo2 = monstruoService.retornarDatosMonstruo(idMonstruo2);

        Map<String, Object> comparacion = new HashMap<>();
        comparacion.put("monstruo1", monstruo1);
        comparacion.put("monstruo2", monstruo2);

        return ResponseEntity.ok(comparacion);
    }
}
