package com.halloween.montruoso.repository;

import com.halloween.montruoso.entidades.Monstruo;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonstruoRepository extends JpaRepository<Monstruo, Long>, JpaSpecificationExecutor<Monstruo> {

    @Query("SELECT m FROM Monstruo m ORDER BY " +
            "CASE m.nivelDePeligro " +
            "WHEN 'BAJO' THEN 1 " +
            "WHEN 'MEDIO' THEN 2 " +
            "WHEN 'ALTO' THEN 3 " +
            "WHEN 'EXTREMO' THEN 4 END ASC")
    Page<Monstruo> findAllByOrderByNivelDePeligroAsc(Pageable pageable);

    @Query("SELECT m FROM Monstruo m ORDER BY " +
            "CASE m.nivelDePeligro " +
            "WHEN 'BAJO' THEN 1 " +
            "WHEN 'MEDIO' THEN 2 " +
            "WHEN 'ALTO' THEN 3 " +
            "WHEN 'EXTREMO' THEN 4 END DESC")
    Page<Monstruo> findAllByOrderByNivelDePeligroDesc(Pageable pageable);

    @Query("SELECT m.nivelDePeligro, COUNT(m) FROM Monstruo m GROUP BY m.nivelDePeligro")
    List<Object[]> contarMonstruosPorNivelDePeligro();

    @Query("SELECT m.tipo, COUNT(m) FROM Monstruo m GROUP BY m.tipo")
    List<Object[]> contarMonstruosPorTipo();

    @Query("SELECT p, COUNT(m) FROM Monstruo m JOIN m.poderes p GROUP BY p")
    List<Object[]> contarMonstruosPorPoder();

    List<Monstruo> findTop10ByOrderByNivelDeTerrorDesc();

    @Query("SELECT m FROM Monstruo m JOIN m.habilidadesEspeciales h WHERE LOWER(h) LIKE LOWER(CONCAT('%', :habilidadEspecial, '%'))")
    List<Monstruo> buscarPorHabilidadEspecial(@Param("habilidadEspecial") String habilidadEspecial);

}
