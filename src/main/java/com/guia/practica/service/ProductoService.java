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

    // Actualizar un Producto existente
    public Producto actualizarProducto(Long idProducto, Producto productoActualizado) {
        // Buscar el producto existente
        Optional<Producto> productoExistenteOptional = repository.findById(idProducto);

        if (productoExistenteOptional.isPresent()) {
            Producto productoExistente = productoExistenteOptional.get();

            // Actualizar los campos del producto con los valores proporcionados
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setStock(productoActualizado.getStock());
            productoExistente.setPrecioUnitario(productoActualizado.getPrecioUnitario());
            productoExistente.setUnidad(productoActualizado.getUnidad());
            productoExistente.setIva(productoActualizado.isIva());
            productoExistente.setIdProveedor(productoActualizado.getIdProveedor());
            productoExistente.setIdClasificacion(productoActualizado.getIdClasificacion());

            // Guardar el producto actualizado y retornarlo
            return repository.save(productoExistente);
        } else {
            // Si el producto no existe, lanzar una excepción o retornar un valor nulo
            throw new RuntimeException("Producto no encontrado con ID: " + idProducto);
        }
    }
}
