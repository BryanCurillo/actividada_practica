package com.guia.practica.repository;

import com.guia.practica.model.Clasificacion;
import com.guia.practica.model.ItemFactura;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends GenericRepository<Clasificacion, Long> {
}
