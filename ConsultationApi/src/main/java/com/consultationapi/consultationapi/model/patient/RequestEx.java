package com.consultationapi.consultationapi.model.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RequestEx {
    private int idPaciente;
    private int idLab;
    private String name;
    private ArrayList<Exam> lisExam;

}

