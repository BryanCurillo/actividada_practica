package com.guia.practica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ItemFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemFactura;
    private int cantidad;
    private double precio;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    private Factura idFactura;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    private Producto idProducto;
}
