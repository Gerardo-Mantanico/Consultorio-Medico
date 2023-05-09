package com.consultationapi.consultationapi.model.patient;

import com.consultationapi.consultationapi.model.specialtyExam.TypeExam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class Exam extends TypeExam {
    private BigDecimal cost;

    public Exam(int id, String name, String description, BigDecimal cost) {
        super(id, name, description);
        this.cost = cost;
    }
}
