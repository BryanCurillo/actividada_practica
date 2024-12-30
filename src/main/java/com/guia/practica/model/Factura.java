package com.guia.practica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private String ruc;
    private Date fecha;
    private double descuento;
    private double total;

    @ManyToOne
    @JoinColumn(name = "idTipoPago", referencedColumnName = "idTipoPago")
    private TipoPago idTipoPago;

    @JsonIgnore
    @OneToMany(mappedBy = "idFactura")
    private List<ItemFactura> listaItems;

    @ManyToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona idPersona;
}
