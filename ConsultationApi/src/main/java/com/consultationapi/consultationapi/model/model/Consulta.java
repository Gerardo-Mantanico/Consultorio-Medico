package com.consultationapi.consultationapi.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Consulta {
    private int id;
    private int paciente;
    private int medico;
    private int especialidad;
    private double porcentaje_aplicacion;
    private List<Id> examenes_solicitados;
    private String fecha_creacion;
    private String fecha_agendada;
    private double precio;
    private String informe_finalizacion;
    private String estado;

    // getters y setters
}