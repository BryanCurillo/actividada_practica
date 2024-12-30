package com.guia.practica.service;

import com.guia.practica.model.ItemFactura;
import com.guia.practica.repository.FacturaRepository;
import com.guia.practica.repository.ItemFacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemFacturaService {
    @Autowired
    private ItemFacturaRepository repository;

    // Guardar o actualizar un ItemFactura
    public ItemFactura guardarItemFactura(ItemFactura itemFactura) {
        return repository.save(itemFactura);
    }

    // Obtener un ItemFactura por su ID
    public Optional<ItemFactura> obtenerItemFacturaPorId(Long idItemFactura) {
        return repository.findById(idItemFactura);
    }

    // Listar todos los ItemFactura
    public List<ItemFactura> listarItemFacturas() {
        return repository.findAll();
    }

    // Eliminar un ItemFactura por su ID
    public void eliminarItemFactura(Long idItemFactura) {
        repository.deleteById(idItemFactura);
    }}
