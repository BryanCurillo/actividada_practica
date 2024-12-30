package com.guia.practica.repository;

import com.guia.practica.model.Usuario;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {

    //Esta implementación evita las inyecciones SQL porque utiliza las capacidades de Spring Data JPA
    // y consultas parametrizadas.
    Usuario findByIdUsuario(Long id);

    @Query(value = "SELECT * " +
            "FROM usuario " +
            "WHERE username =:username OR :username is null ", nativeQuery = true)
    List<Usuario> users(@Param("username") String username);

    Optional<Usuario> findByUsername(String username);


    @Query("SELECT COUNT(*) FROM Usuario u WHERE u.username = :username")
    Long usuarioUnico(@Param("username") String username);


}
