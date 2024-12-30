package com.guia.practica.service;

import com.guia.practica.model.Producto;
import com.guia.practica.repository.PersonaRepository;
import com.guia.practica.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    // Guardar o actualizar un Producto
    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    // Obtener un Producto por su ID
    public Optional<Producto> obtenerProductoPorId(Long idProducto) {
        return repository.findById(idProducto);
    }

    // Listar todos los Productos
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    // Eliminar un Producto por su ID
    public void eliminarProducto(Long idProducto) {
        repository.deleteById(idProducto);
    }
}
