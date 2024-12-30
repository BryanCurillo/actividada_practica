package com.guia.practica.service;

import com.guia.practica.model.Clasificacion;
import com.guia.practica.repository.ClasificacionRepository;
import com.guia.practica.repository.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClasificacionService {
    @Autowired
    private ClasificacionRepository repository;

    // Crear o actualizar una Clasificacion
    public Clasificacion guardarClasificacion(Clasificacion clasificacion) {
        return repository.save(clasificacion);
    }

    // Obtener una Clasificacion por su ID
    public Optional<Clasificacion> obtenerClasificacionPorId(Long idClasificacion) {
        return repository.findById(idClasificacion);
    }

    // Listar todas las Clasificaciones
    public List<Clasificacion> listarClasificaciones() {
        return repository.findAll();
    }

    // Eliminar una Clasificacion por su ID
    public void eliminarClasificacion(Long idClasificacion) {
        repository.deleteById(idClasificacion);
    }
}
