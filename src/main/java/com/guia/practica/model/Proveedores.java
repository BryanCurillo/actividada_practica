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
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;
    private String ruc;
    private String nombre;
    private String telefono;
    private String pais;
    private String correo;
    private String moneda;

    @JsonIgnore
    @OneToMany(mappedBy = "idProveedor")
    private List<Producto> listaProductos;

}
