package com.guia.practica.controller;

import com.guia.practica.model.Producto;
import com.guia.practica.service.PersonaService;
import com.guia.practica.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;
    // Crear o actualizar un Producto
    @PostMapping("/saveProducto")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = service.guardarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/updateProducto/{idproducto}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long idproducto, @RequestBody Producto producto) {
        try {
            Producto productoActualizado = service.actualizarProducto(idproducto, producto);
            return ResponseEntity.status(HttpStatus.OK).body(productoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Producto no encontrado
        }
    }


    // Obtener un Producto por su ID
    @GetMapping("/obtProductoPorId/{id}")
    public ResponseEntity<Producto> obtProductoPorId(@PathVariable Long id) {
        Optional<Producto> producto = service.obtenerProductoPorId(id);
        return producto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los Productos
    @GetMapping("/listProductos")
    public ResponseEntity<List<Producto>> listProductos() {
        List<Producto> productos = service.listarProductos();
        return ResponseEntity.ok(productos);
    }

    // Eliminar un Producto por su ID
    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
