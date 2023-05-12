package com.consultationapi.consultationapi.model.doctor.ver_consultas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class SolicitudesPendientes {
        private int idConsulta;
        private String nombrePaciente;
        private String especialidad;
        private String dataStart;
        private String dataEnd;
        private String info;
        private ArrayList<String> examenes;
}
