package com.guia.practica.repository;

import com.guia.practica.model.Clasificacion;
import com.guia.practica.model.Persona;
import com.guia.practica.repository.genericRepository.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public interface PersonaRepository extends GenericRepository<Persona, Long> {

}
