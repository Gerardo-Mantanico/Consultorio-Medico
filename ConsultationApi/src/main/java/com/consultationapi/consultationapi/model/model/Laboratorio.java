package com.consultationapi.consultationapi.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

    public class Laboratorio {
        private int id;
        private String nombre;
        private String username;
        private String password;
        private String direccion;
        private String cui;
        private String telefono;
        private String email;
        private String fecha_fundacion;
        private double saldo;
        private List<ExamenPrecio> examenes;

        // getters y setters
    }

