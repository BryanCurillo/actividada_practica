package com.guia.practica.controller;

import com.guia.practica.model.Persona;
import com.guia.practica.model.Usuario;
import com.guia.practica.service.FacturaService;
import com.guia.practica.service.PersonaService;
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
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaService service;


    @GetMapping("/buscarPersona")
    public ResponseEntity<Persona> buscarPersona(@RequestParam String dni) {

        return new ResponseEntity<>(service.buscarPersona(dni), HttpStatus.OK);
    }

    @GetMapping("/obtNombreCompleto")
    public ResponseEntity<String> obtNombreCompleto(@RequestParam String dni) {

        return new ResponseEntity<>(service.obtNombreCompleto(dni), HttpStatus.OK);
    }


}
