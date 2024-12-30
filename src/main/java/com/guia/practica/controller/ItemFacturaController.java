package com.guia.practica.controller;

import com.guia.practica.model.ItemFactura;
import com.guia.practica.service.FacturaService;
import com.guia.practica.service.ItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itemFactura")
public class ItemFacturaController {
    @Autowired
    private ItemFacturaService service;
    // Crear o actualizar un ItemFactura
    @PostMapping("/saveItemFactura")
    public ResponseEntity<ItemFactura> saveItemFactura(@RequestBody ItemFactura itemFactura) {
        ItemFactura nuevoItemFactura = service.guardarItemFactura(itemFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoItemFactura);
    }

    // Obtener un ItemFactura por su ID
    @GetMapping("/obtItemFacturaPorId/{id}")
    public ResponseEntity<ItemFactura> obtItemFacturaPorId(@PathVariable Long id) {
        Optional<ItemFactura> itemFactura = service.obtenerItemFacturaPorId(id);
        return itemFactura.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los ItemFactura
    @GetMapping("/listItemFacturas")
    public ResponseEntity<List<ItemFactura>> listItemFacturas() {
        List<ItemFactura> itemFacturas = service.listarItemFacturas();
        return ResponseEntity.ok(itemFacturas);
    }

    // Eliminar un ItemFactura por su ID
    @DeleteMapping("/deleteItemFactura/{id}")
    public ResponseEntity<Void> deleteItemFactura(@PathVariable Long id) {
        service.eliminarItemFactura(id);
        return ResponseEntity.noContent().build();
    }
}
