package com.guia.practica.service;

import com.guia.practica.model.Competencia;
import com.guia.practica.model.Rol;
import com.guia.practica.repository.ProductoRepository;
import com.guia.practica.repository.RolRepository;
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
public class RolService {
    @Autowired
    private RolRepository repository;
    @Autowired
    private RolRepository rolRepository;

    public Boolean siExisteRol(String idRol) {
        try {
            // Consulta al repositorio, evita SQL manual.
            Long conteo = repository.countByNombre(idRol);
            return conteo > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean siExisteCompetencia(String idRol, Long idCompetencia) {
        try {
            // Consulta al repositorio, evita SQL manual.
            Long conteo = repository.countRolComp(idRol, idCompetencia);
            return conteo > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // Crear un nuevo Rol
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    // Obtener un Rol por su ID
    public Optional<Rol> obtenerRol(String idRol) {
        return rolRepository.findById(idRol);
    }

    // Actualizar un Rol
    public Rol updateRol(String idRol, Rol rolUpdate) {
        Rol rolExistente = rolRepository.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Actualizar los detalles del rol (nombre, descripcion, estado)
        rolExistente.setNombre(rolUpdate.getNombre());
        rolExistente.setDescripcion(rolUpdate.getDescripcion());
        rolExistente.setEstado(rolUpdate.isEstado());

        // Verificar si las competencias no existen antes de agregarlas
        for (Competencia competencia : rolUpdate.getCompetencias()) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++");
            System.out.println(siExisteCompetencia(rolExistente.getIdRol(), competencia.getIdCompetencia()));
            if (!siExisteCompetencia(rolExistente.getIdRol(), competencia.getIdCompetencia())) {
                rolExistente.getCompetencias().add(competencia); // Agregar la nueva competencia
            }
        }

        // Guardar y devolver el rol actualizado
        return rolRepository.save(rolExistente);
    }

    // Eliminar un Rol
    public void deleteRol(String idRol) {
        Rol rol = rolRepository.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolRepository.delete(rol);
    }

    // Listar todos los Roles
    public List<Rol> listRoles() {
        return rolRepository.findAll();
    }
}
