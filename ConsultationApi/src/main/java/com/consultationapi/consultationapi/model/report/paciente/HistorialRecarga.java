package com.consultationapi.consultationapi.model.report.paciente;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class HistorialRecarga {
    private BigDecimal monto;
    private String date;
  }
