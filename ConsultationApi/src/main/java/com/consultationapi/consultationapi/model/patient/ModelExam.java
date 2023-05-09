package com.consultationapi.consultationapi.model.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ModelExam {
    private int idLab;
    private String name;
    private int idExam;
    private String nameExam;
    private String descripcion;
    private BigDecimal cost;
}
