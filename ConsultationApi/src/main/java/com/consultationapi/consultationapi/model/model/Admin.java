package com.consultationapi.consultationapi.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Admin {
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String email;
    private String fecha_nacimiento;
    private double saldo;
}