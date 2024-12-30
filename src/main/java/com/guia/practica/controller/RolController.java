package com.guia.practica.controller;

import com.guia.practica.model.Rol;
import com.guia.practica.service.ProveedoresService;
import com.guia.practica.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping("/siExisteRol")
    public ResponseEntity<Boolean> siExisteRol(@RequestParam String idRol) {

        return new ResponseEntity<>(service.siExisteRol(idRol), HttpStatus.OK);
    }
    // Crear un nuevo Rol
    @PostMapping("/saveRol")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
        Rol nuevoRol = service.saveRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    // Obtener un Rol por su ID
    @GetMapping("/obtenerRol/{idRol}")
    public ResponseEntity<Rol> obtenerRol(@PathVariable String idRol) {
        Optional<Rol> rol = service.obtenerRol(idRol);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un Rol
    @PutMapping("/updateRol/{idRol}")
    public ResponseEntity<Rol> updateRol(@PathVariable String idRol, @RequestBody Rol rolUpdate) {
        try {
            Rol rolActualizado = service.updateRol(idRol, rolUpdate);
            return ResponseEntity.ok(rolActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Eliminar un Rol por su ID
    @DeleteMapping("/deleteRol/{idRol}")
    public ResponseEntity<Void> deleteRol(@PathVariable String idRol) {
        service.deleteRol(idRol);
        return ResponseEntity.noContent().build();
    }

    // Listar todos los Roles
    @GetMapping("/listRoles")
    public ResponseEntity<List<Rol>> listRoles() {
        List<Rol> roles = service.listRoles();
        return ResponseEntity.ok(roles);
    }
}
