package com.consultationapi.consultationapi.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor  @NoArgsConstructor
public class Medico {
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String direccion;
    private long cui;
    private long telefono;
    private String email;
    private String fecha_nacimiento;
    private double saldo;
    private List<String> horarios;
    private List<EspecialidadPrecio> especialidades;

    // getters y setters
}