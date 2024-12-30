package com.guia.practica.controller;

import com.guia.practica.model.Factura;
import com.guia.practica.service.FacturaService;
import com.guia.practica.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private FacturaService service;

    // Crear o actualizar una Factura
    @PostMapping("/saveFactura")
    public ResponseEntity<Factura> saveFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = service.guardarFactura(factura);
        return ResponseEntity.ok(nuevaFactura);
    }

    // Obtener una Factura por su ID
    @GetMapping("/obtFacturaPorId/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id) {
        Optional<Factura> factura = service.obtenerFacturaPorId(id);
        return factura.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las Facturas
    @GetMapping("/listFacturas")
    public ResponseEntity<List<Factura>> listarFacturas() {
        List<Factura> facturas = service.listarFacturas();
        return ResponseEntity.ok(facturas);
    }

    // Eliminar una Factura por su ID
    @DeleteMapping("/deleteFactura/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long id) {
        service.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}
