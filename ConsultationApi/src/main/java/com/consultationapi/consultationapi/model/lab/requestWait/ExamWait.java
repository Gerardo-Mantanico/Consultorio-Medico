package com.consultationapi.consultationapi.model.lab.requestWait;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class ExamWait {
    private  int idExam;
    private String name;
    private BigDecimal cost;
}
