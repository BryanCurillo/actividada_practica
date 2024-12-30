package com.guia.practica.repository;

import com.guia.practica.model.Competencia;
import com.guia.practica.model.Rol;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends GenericRepository<Competencia, Long> {


    // Consulta personalizada para contar competencias por nombre
    @Query("SELECT COUNT(c) FROM Competencia c WHERE c.nombre = :nombre")
    Long countByNombre(@Param("nombre") String nombre);
}

