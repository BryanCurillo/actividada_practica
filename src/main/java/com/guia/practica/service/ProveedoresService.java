package com.guia.practica.service;

import com.guia.practica.model.Proveedores;
import com.guia.practica.repository.ProductoRepository;
import com.guia.practica.repository.ProveedoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProveedoresService {
    @Autowired
    private ProveedoresRepository repository;
    // Crear o actualizar un Proveedor
    public Proveedores guardarProveedor(Proveedores proveedor) {
        return repository.save(proveedor);
    }

    // Obtener un Proveedor por su ID
    public Optional<Proveedores> obtenerProveedorPorId(Long idProveedor) {
        return repository.findById(idProveedor);
    }

    // Listar todos los Proveedores
    public List<Proveedores> listarProveedores() {
        return repository.findAll();
    }

    // Eliminar un Proveedor por su ID
    public void eliminarProveedor(Long idProveedor) {
        repository.deleteById(idProveedor);
    }
}
