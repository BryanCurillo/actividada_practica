package com.guia.practica.security.auth;

import com.guia.practica.model.Usuario;
import com.guia.practica.security.jwt.JwtService;
import com.guia.practica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Usuario user = userRepository.findByUsername(request.getUsername()).orElseThrow();
//        System.out.println("PASSS = "+userRepository.findByUsuNombreUsuario(request.getUsuNombreUsuario()));

        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .response("INICIO DE SESION EXITOSO")
                .username(user.getUsername())
                .rol(user.getIdRol().getIdRol())
                .token(token)
                .build();

    }

    public AuthResponse register(Usuario request) {
        Usuario user = Usuario.builder()
                .idUsuario(request.getIdUsuario())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))// utilizao hashing para encriptar la contraseña
                .fechaRegistro(request.getFechaRegistro())
                .idRol(request.getIdRol())
                .idPersona(request.getIdPersona())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .response("REGISTRO EXITOSO")
                .username(user.getUsername())
                .rol(user.getIdRol().getIdRol())
                .token(jwtService.getToken(user))
                .build();

    }

    public Usuario update(Usuario request) {
        Usuario user = Usuario.builder()
                .idUsuario(request.getIdUsuario())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .fechaRegistro(request.getFechaRegistro())
                .idRol(request.getIdRol())
                .build();

        userRepository.save(user);

        return userRepository.save(user);

    }

    public boolean usuarioValido(String user) {
        Long cont = userRepository.usuarioUnico(user.trim());

        if (cont > 0) {
            return true;
        } else {
            return false;
        }
    }
}
