package com.guia.practica.repository;

import com.guia.practica.model.Persona;
import com.guia.practica.model.Producto;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends GenericRepository<Producto, Long> {
}
