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
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String dni;
    private String celular;
    private String correo;

    @JsonIgnore
    @OneToMany(mappedBy = "idPersona")
    private List<Factura> listaFacturas;

    @JsonIgnore
    @OneToMany(mappedBy = "idPersona")
    private List<Usuario> listaUsuarios;

}
