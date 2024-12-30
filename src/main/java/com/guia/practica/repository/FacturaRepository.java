package com.guia.practica.repository;

import com.guia.practica.model.Factura;
import com.guia.practica.model.Usuario;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends GenericRepository<Factura, Long> {
}
