package com.consultationapi.consultationapi.model.patient;

import com.consultationapi.consultationapi.model.model.TipoExamen;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class Exam extends TipoExamen {
    private BigDecimal cost;

    public Exam(int id, String nombre, String descripcion, BigDecimal cost) {
        super(id, nombre, descripcion);
        this.cost = cost;
    }
}
