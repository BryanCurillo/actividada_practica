package com.guia.practica.repository;

import com.guia.practica.model.TipoPago;
import com.guia.practica.repository.genericRepository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagoRepository extends GenericRepository<TipoPago, Long> {

}
