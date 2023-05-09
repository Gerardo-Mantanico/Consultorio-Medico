package com.consultationapi.consultationapi.model.report.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
    @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ReporteConsul {
    private int id;
    private String name;
    private String medico;
    private String date;
    private ArrayList<String> nameExam;

}
