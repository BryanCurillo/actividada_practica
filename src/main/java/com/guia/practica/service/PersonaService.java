package com.guia.practica.service;

import com.guia.practica.model.Persona;
import com.guia.practica.repository.ClasificacionRepository;
import com.guia.practica.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    //EntityManager es una abstracción de más alto nivel que simplifica la ejecución de consultas y manejo de parámetros.
    // No es necesario usar PreparedStatement porque JPA se encarga de la preparación de la consulta y
    // la gestión de los parámetros de forma interna.
    @Transactional
    public Persona buscarPersona(String dni) {
        Persona persona = null;
        try {
            String sql = "SELECT p FROM Persona p WHERE p.dni = :dni";
            persona = entityManager.createQuery(sql, Persona.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Manejar el caso cuando no se encuentra la persona
            System.out.println("No se encontró la persona con DNI: " + dni);
            // Puede devolver null o alguna respuesta personalizada
            persona = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persona;
    }
    @Transactional
    public String obtNombreCompleto(String dni) {
        String nombreCompleto = null;
        try {
            String sql = "SELECT CONCAT(p.apellido, ' ', p.nombre) FROM Persona p WHERE p.dni = :dni";
            nombreCompleto = entityManager.createQuery(sql, String.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } catch (NoResultException e) {
            nombreCompleto = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreCompleto;
    }
}



