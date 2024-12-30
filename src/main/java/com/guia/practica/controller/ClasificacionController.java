package com.guia.practica.controller;


import com.guia.practica.model.Clasificacion;
import com.guia.practica.service.ClasificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasificacion")
public class ClasificacionController {
    @Autowired
    private ClasificacionService service;

    // Crear o actualizar una Clasificacion
    @PostMapping("/saveClasificacion")
    public ResponseEntity<Clasificacion> saveClasificacion(@RequestBody Clasificacion clasificacion) {
        Clasificacion nuevaClasificacion = service.guardarClasificacion(clasificacion);
        return ResponseEntity.ok(nuevaClasificacion);
    }

    // Obtener una Clasificacion por su ID
    @GetMapping("/obtClasificacion/{id}")
    public ResponseEntity<Clasificacion> obtClasificacionPorId(@PathVariable Long id) {
        Optional<Clasificacion> clasificacion = service.obtenerClasificacionPorId(id);
        return clasificacion.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las Clasificaciones
    @GetMapping("/listClasificaciones")
    public ResponseEntity<List<Clasificacion>> listClasificaciones() {
        List<Clasificacion> clasificaciones = service.listarClasificaciones();
        return ResponseEntity.ok(clasificaciones);
    }

    // Eliminar una Clasificacion por su ID
    @DeleteMapping("/deleteClasificacion/{id}")
    public ResponseEntity<Void> deleteClasificacion(@PathVariable Long id) {
        service.eliminarClasificacion(id);
        return ResponseEntity.noContent().build();
    }
}
