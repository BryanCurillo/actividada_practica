package com.guia.practica.controller;

import com.guia.practica.model.Usuario;
import com.guia.practica.security.auth.AuthResponse;
import com.guia.practica.security.auth.AuthService;
import com.guia.practica.service.UsuarioService;
import com.guia.practica.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private AuthService authService;

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> users(@RequestParam String username) {
        return new ResponseEntity<>(service.findUsers(username), HttpStatus.OK);
    }

    @GetMapping("/siExiste")
    public ResponseEntity<Boolean> siExiste(@RequestParam String username) {

        return new ResponseEntity<>(service.siExiste(username), HttpStatus.OK);
    }


    // Se usa authService para el manejo de JWT
    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Usuario request)
    {
        if (!RegexUtils.validarUsername(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(AuthResponse.builder()
                            .response("El nombre de usuario solo puede contener letras y números.")
                            .build());
        }
        if (!RegexUtils.validarPassword(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(AuthResponse.builder()
                            .response("La contraseña no cumple con los requisitos de seguridad: debe tener al menos 8 caracteres, "
                                    + "incluyendo una letra mayúscula, una letra minúscula, un número y un carácter especial.")
                            .build());
        }

        // Si las validaciones son correctas, delegar al servicio
        return ResponseEntity.ok(authService.register(request));

    }

    // Obtener un Usuario por su ID
    @GetMapping("/obtUsuarioPorId/{id}")
    public ResponseEntity<Usuario> obtUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = service.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Listar todos los Usuarios
    @GetMapping("/listUsuarios")
    public ResponseEntity<List<Usuario>> listUsuarios() {
        List<Usuario> usuarios = service.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Eliminar un Usuario por su ID
    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        service.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
