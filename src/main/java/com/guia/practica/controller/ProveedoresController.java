package com.guia.practica.controller;

import com.guia.practica.model.Proveedores;
import com.guia.practica.service.ProductoService;
import com.guia.practica.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
    @Autowired
    private ProveedoresService service;
    // Crear o actualizar un Proveedor
    @PostMapping("/saveProveedor")
    public ResponseEntity<Proveedores> saveProveedor(@RequestBody Proveedores proveedor) {
        Proveedores nuevoProveedor = service.guardarProveedor(proveedor);
        return ResponseEntity.ok(nuevoProveedor);
    }

    // Obtener un Proveedor por su ID
    @GetMapping("/obtProveedor/{id}")
    public ResponseEntity<Proveedores> obtProveedorPorId(@PathVariable Long id) {
        Optional<Proveedores> proveedor = service.obtenerProveedorPorId(id);
        return proveedor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los Proveedores
    @GetMapping("/listProveedores")
    public ResponseEntity<List<Proveedores>> listProveedores() {
        List<Proveedores> proveedores = service.listarProveedores();
        return ResponseEntity.ok(proveedores);
    }

    // Eliminar un Proveedor por su ID
    @DeleteMapping("/deleteProveedor/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        service.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
