package com.guia.practica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Competencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetencia;
    @Column(unique = true)
    private String nombre;
    private String descripcion;
    @ManyToMany(mappedBy = "competencias")
    private List<Rol> roles;
}
