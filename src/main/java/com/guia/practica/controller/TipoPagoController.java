    package com.guia.practica.controller;

    import com.guia.practica.model.TipoPago;
    import com.guia.practica.model.Usuario;
    import com.guia.practica.service.TipoPagoService;
    import com.guia.practica.service.UsuarioService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/tipoPago")
    public class TipoPagoController {
        @Autowired
        private TipoPagoService service;
        // Crear o actualizar un TipoPago
        @PostMapping("/saveTipoPago")
        public ResponseEntity<TipoPago> saveTipoPago(@RequestBody TipoPago tipoPago) {
            TipoPago nuevoTipoPago = service.guardarTipoPago(tipoPago);
            return ResponseEntity.ok(nuevoTipoPago);
        }

        // Obtener un TipoPago por su ID
        @GetMapping("/obtTipoPagoPorId/{id}")
        public ResponseEntity<TipoPago> obtTipoPagoPorId(@PathVariable Long id) {
            Optional<TipoPago> tipoPago = service.obtenerTipoPagoPorId(id);
            return tipoPago.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }

        // Listar todos los Tipos de Pago
        @GetMapping("/listTiposPago")
        public ResponseEntity<List<TipoPago>> listTiposPago() {
            List<TipoPago> tiposPago = service.listarTiposPago();
            return ResponseEntity.ok(tiposPago);
        }

        // Eliminar un TipoPago por su ID
        @DeleteMapping("/deleteTipoPago/{id}")
        public ResponseEntity<Void> deleteTipoPago(@PathVariable Long id) {
            service.eliminarTipoPago(id);
            return ResponseEntity.noContent().build();
        }
    }
