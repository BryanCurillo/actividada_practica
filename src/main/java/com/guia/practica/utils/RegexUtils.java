package com.guia.practica.utils;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.regex.Pattern;
@Getter
@Setter
@Builder
public class RegexUtils {
    public static final Pattern PATTERN_NUMERICO = Pattern.compile("^[0-9]+$");
    public static final Pattern PATTERN_MINUSCULAS = Pattern.compile("^[a-z]+$");
    public static final Pattern PATTERN_MAYUSCULAS = Pattern.compile("^[A-Z]+$");
    public static final Pattern PATTERN_LET_O_NUM = Pattern.compile("^[a-zA-Z0-9]+$");
    public static final Pattern PATTERN_LET_Y_NUM = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]+$");
    public static final Pattern PATTERN_PASS = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    //Validar que contenga solo letras y numeros
    public static boolean validarUsername(String input) {
        return PATTERN_LET_O_NUM.matcher(input).matches();
    }

    //Validar que contenga:
    //Al menos una letra minúscula
    //Al menos una letra mayúscula
    //Al menos un número
    //Al menos un carácter especial
    //Mínimo 8 caracteres
    public static boolean validarPassword(String input) {
        return PATTERN_PASS.matcher(input).matches();
    }
}
