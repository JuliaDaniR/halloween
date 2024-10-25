package com.halloween.montruoso.entidades;

import com.halloween.montruoso.dto.DatosRegistroMonstruo;
import com.halloween.montruoso.dto.DatosRegistroUsuario;
import com.halloween.montruoso.enumerador.Debilidades;
import com.halloween.montruoso.enumerador.NivelDePeligro;
import com.halloween.montruoso.enumerador.Poderes;
import com.halloween.montruoso.enumerador.TipoMonstruo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Monstruo")
@Table(name = "monstruos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoMonstruo tipo;

    private Integer nivelDeTerror;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Poderes> poderes;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Debilidades> debilidades;

    private String descripcion;
    private String imagenUrl;

    @Enumerated(EnumType.STRING)
    private NivelDePeligro nivelDePeligro;

    @ElementCollection
    private List<String> habilidadesEspeciales;

    @Lob
    private String historia;

    private String apariencia;
    private String sonido;

    public Monstruo(DatosRegistroMonstruo datos){
        this.nombre = datos.nombre();
        this.tipo = datos.tipo();
        this.nivelDeTerror = datos.nivelDeTerror();
        this.poderes = datos.poderes();
        this.debilidades = datos.debilidades();
        this.descripcion = datos.descripcion();
        this.imagenUrl = datos.imagenUrl();
        this.nivelDePeligro = datos.nivelDePeligro();
        this.habilidadesEspeciales = datos.habilidadesEspeciales();
        this.historia = datos.historia();
        this.apariencia = datos.apariencia();
        this.sonido = datos.sonido();
    }

    public void actualizarDatos(DatosRegistroMonstruo.DatosActualizarMonstruo datosActualizarMonstruo) {

        if (datosActualizarMonstruo.nombre() != null) {
            this.nombre = datosActualizarMonstruo.nombre();
        }

        if (datosActualizarMonstruo.tipo() != null) {
            this.tipo = datosActualizarMonstruo.tipo();
        }

        if (datosActualizarMonstruo.nivelDeTerror() > 0) {
            this.nivelDeTerror = datosActualizarMonstruo.nivelDeTerror();
        }

        if (datosActualizarMonstruo.poderes() != null && !datosActualizarMonstruo.poderes().isEmpty()) {
            this.poderes = datosActualizarMonstruo.poderes();
        }

        if (datosActualizarMonstruo.debilidades() != null && !datosActualizarMonstruo.debilidades().isEmpty()) {
            this.debilidades = datosActualizarMonstruo.debilidades();
        }

        if (datosActualizarMonstruo.descripcion() != null) {
            this.descripcion = datosActualizarMonstruo.descripcion();
        }

        if (datosActualizarMonstruo.imagenUrl() != null) {
            this.imagenUrl = datosActualizarMonstruo.imagenUrl();
        }

        if (datosActualizarMonstruo.nivelDePeligro() != null) {
            this.nivelDePeligro = datosActualizarMonstruo.nivelDePeligro();
        }

        if (datosActualizarMonstruo.habilidadesEspeciales() != null && !datosActualizarMonstruo.habilidadesEspeciales().isEmpty()) {
            this.habilidadesEspeciales = datosActualizarMonstruo.habilidadesEspeciales();
        }

        if (datosActualizarMonstruo.historia() != null) {
            this.historia = datosActualizarMonstruo.historia();
        }

        if (datosActualizarMonstruo.apariencia() != null) {
            this.apariencia = datosActualizarMonstruo.apariencia();
        }

        if (datosActualizarMonstruo.sonido() != null) {
            this.sonido = datosActualizarMonstruo.sonido();
        }
    }

}
