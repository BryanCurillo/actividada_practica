package com.guia.practica.service;

import com.guia.practica.model.TipoPago;
import com.guia.practica.repository.TipoPagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoPagoService {
    @Autowired
    private TipoPagoRepository repository;
    // Crear o actualizar un TipoPago
    public TipoPago guardarTipoPago(TipoPago tipoPago) {
        return repository.save(tipoPago);
    }

    // Obtener un TipoPago por su ID
    public Optional<TipoPago> obtenerTipoPagoPorId(Long idTipoPago) {
        return repository.findById(idTipoPago);
    }

    // Obtener todos los Tipos de Pago
    public List<TipoPago> listarTiposPago() {
        return repository.findAll();
    }

    // Eliminar un TipoPago por su ID
    public void eliminarTipoPago(Long idTipoPago) {
        repository.deleteById(idTipoPago);
    }
}
