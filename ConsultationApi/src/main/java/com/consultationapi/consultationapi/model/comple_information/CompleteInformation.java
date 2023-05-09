package com.consultationapi.consultationapi.model.comple_information;

import lombok.*;

import java.math.BigDecimal;
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class CompleteInformation {
    private int id;
    private int id_user;
    private int id_type;
    private String name;
    private BigDecimal cost;
}
