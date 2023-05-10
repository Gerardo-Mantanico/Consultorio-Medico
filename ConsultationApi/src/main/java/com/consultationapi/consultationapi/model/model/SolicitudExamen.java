package com.consultationapi.consultationapi.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class SolicitudExamen {
    private int id;
    private int paciente;
    private int laboratorio;
    private double porcentaje_aplicacion;
    private String fecha_solicitado;
    private String fecha_finalizado;
    private List<ExamenPrecio> examenes;
    private String estado_solicitud;

    // getters y setters
}