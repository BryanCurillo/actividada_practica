package com.guia.practica.security.auth;

import com.guia.practica.model.Usuario;
import com.guia.practica.utils.RegexUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Usuario request) {

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
        return ResponseEntity.ok(authService.register(request));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/usuarioValido")
    public ResponseEntity<Boolean> usuarioValido(@RequestParam String user) {
        return new ResponseEntity<>(authService.usuarioValido(user), HttpStatus.OK);
    }
}
