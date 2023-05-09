package com.consultationapi.consultationapi.model.report.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Top5 {
    private int id;
    private String name;
    private int cantidad;
    private BigDecimal totalConsultas;
    private BigDecimal total;
}
