package com.consultationapi.consultationapi.model.consultation;

import com.consultationapi.consultationapi.model.model.TipoExamen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Consultation {
    private int id;
    private int idPatient;
    private int doctor;
    private int specialty;
    private double porcentage;
    private ArrayList<TipoExamen> exams;
    private Date dataStart;
    private Date dataEnd;
    private BigDecimal precio;
    private String information;
    private String state;
}
