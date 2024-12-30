package com.guia.practica.controller;

import com.guia.practica.model.Competencia;
import com.guia.practica.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competencia")
public class CompetenciaController {
    @Autowired
    private CompetenciaService service;

    @GetMapping("/siExisteCom")
    public ResponseEntity<Boolean> siExisteCom(@RequestParam String nombre) {

        return new ResponseEntity<>(service.siExisteCom(nombre), HttpStatus.OK);
    }
    // Crear o actualizar una Competencia
    @PostMapping("/saveCompetencia")
    public ResponseEntity<Competencia> saveCompetencia(@RequestBody Competencia competencia) {
        Competencia nuevaCompetencia = service.guardarCompetencia(competencia);
        return ResponseEntity.ok(nuevaCompetencia);
    }

    // Obtener una Competencia por su ID
    @GetMapping("/obtCompetenciaPorId/{id}")
    public ResponseEntity<Competencia> obtCompetenciaPorId(@PathVariable Long id) {
        Optional<Competencia> competencia = service.obtenerCompetenciaPorId(id);
        return competencia.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todas las Competencias
    @GetMapping("/listCompetencias")
    public ResponseEntity<List<Competencia>> listCompetencias() {
        List<Competencia> competencias = service.listarCompetencias();
        return ResponseEntity.ok(competencias);
    }

    // Eliminar una Competencia por su ID
    @DeleteMapping("/deleteCompetencia/{id}")
    public ResponseEntity<Void> deleteCompetencia(@PathVariable Long id) {
        service.eliminarCompetencia(id);
        return ResponseEntity.noContent().build();
    }

}
