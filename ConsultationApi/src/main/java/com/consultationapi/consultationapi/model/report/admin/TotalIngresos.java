package com.consultationapi.consultationapi.model.report.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TotalIngresos {
    private Date fechaIncial;
    private Date  fechaFinal;
    private BigDecimal totalIngresos;
    private String categoria;
    private int cantidad;
    private BigDecimal total;
}
