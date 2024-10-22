package com.halloween.montruoso.entidades;

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

    private int nivelDeTerror;

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

    private String historia;
    private String apariencia;
    private String sonido;
}
