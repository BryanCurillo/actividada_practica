package com.guia.practica.service;

import com.guia.practica.model.Usuario;
import com.guia.practica.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> findUsers(String username) {
        List<Usuario> users = repository.users(username);
        return users;
    }

    public Boolean siExiste(String username) {
        try {
            // Delegar la consulta al repositorio
            Long conteo = repository.usuarioUnico(username);
            return conteo > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Crear un nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    // Obtener usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return repository.findById(id);
    }

    // Obtener usuario por username
    public Optional<Usuario> getUsuarioByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Actualizar usuario
    public Usuario updateUsuario(Long id, Usuario usuario) {
        if (repository.existsById(id)) {
            usuario.setIdUsuario(id);  // Asegurarse de que el ID se mantenga igual
            return repository.save(usuario);
        }
        return null; // o lanzar una excepción si el usuario no existe
    }

    // Eliminar usuario
    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }
}
