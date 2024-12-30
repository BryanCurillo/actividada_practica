package com.guia.practica.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idRol;
    private String nombre;
    private String descripcion;
    private boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "idRol")
    private List<Usuario> listaUsuarios;

    @ManyToMany
    @JoinTable(
            name = "rol_competencia",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_competencia")
    )
    private List<Competencia> competencias;
}

