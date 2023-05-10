package com.consultationapi.consultationapi.readFile;

import com.consultationapi.consultationapi.model.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Data {
    List<Admin> admin;
    List<Especialidad> especialidades;
    List<TipoExamen> tipos_examenes;
    List<Medico> medicos;
    List<Laboratorio> laboratorios;
    List<Paciente> pacientes;
    List<Consulta> consultas;
    List<SolicitudExamen> solicitudes;

}
