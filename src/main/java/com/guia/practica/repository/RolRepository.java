package com.guia.practica.repository;

import com.guia.practica.model.Rol;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends GenericRepository<Rol, String> {
    @Query("SELECT COUNT(r) FROM Rol r WHERE r.idRol=:idRol")
    Long countByNombre(@Param("idRol") String idRol);

   //aqui se hago un nativeQuery ya que la tabla intermedia se creo automaticamente por que usamos JPA
    // y no tiene una clase asociada

    @Query(value = "SELECT COUNT(*) FROM rol_competencia r WHERE r.id_rol = :idRol AND r.id_competencia = :idCompetencia", nativeQuery = true)
    Long countRolComp(@Param("idRol") String idRol, @Param("idCompetencia") Long idCompetencia);


}
