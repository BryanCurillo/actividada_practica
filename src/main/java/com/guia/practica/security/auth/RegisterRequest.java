package com.guia.practica.security.auth;

import com.guia.practica.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private Long idUsuario;
    private String username;
    private String password;
    private Date fechaRegistro;
    private Rol idRol;
}
