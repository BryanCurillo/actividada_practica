package com.guia.practica.service;

import com.guia.practica.model.Factura;
import com.guia.practica.repository.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FacturaService {
    @Autowired
    private FacturaRepository repository;
    // Guardar o actualizar una Factura
    public Factura guardarFactura(Factura factura) {
        return repository.save(factura);
    }

    // Obtener una Factura por su ID
    public Optional<Factura> obtenerFacturaPorId(Long idFactura) {
        return repository.findById(idFactura);
    }

    // Obtener todas las Facturas
    public List<Factura> listarFacturas() {
        return repository.findAll();
    }

    // Eliminar una Factura por su ID
    public void eliminarFactura(Long idFactura) {
        repository.deleteById(idFactura);
    }
}
