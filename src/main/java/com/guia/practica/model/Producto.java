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
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;
    private int stock;
    private double precioUnitario;
    private String unidad;
    private boolean iva;

    @JsonIgnore
    @OneToMany(mappedBy = "idProducto")
    private List<ItemFactura> listaItems;

    @ManyToOne
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    private Proveedores idProveedor;

    @ManyToOne
    @JoinColumn(name = "idClasificacion", referencedColumnName = "idClasificacion")
    private Clasificacion idClasificacion;
}
