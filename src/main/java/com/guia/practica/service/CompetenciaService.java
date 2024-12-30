package com.guia.practica.service;

import com.guia.practica.model.Competencia;
import com.guia.practica.repository.CompetenciaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository repository;

    public Boolean siExisteCom(String nombre) {
        try {
            Long count = repository.countByNombre(nombre);
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Guardar o actualizar una competencia
    public Competencia guardarCompetencia(Competencia competencia) {
        return repository.save(competencia);
    }

    // Obtener una competencia por ID
    public Optional<Competencia> obtenerCompetenciaPorId(Long id) {
        return repository.findById(id);
    }

    // Listar todas las competencias
    public List<Competencia> listarCompetencias() {
        return repository.findAll();
    }

    // Eliminar una competencia por ID
    public void eliminarCompetencia(Long id) {
        repository.deleteById(id);
    }

}
