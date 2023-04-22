package com.consultationapi.consultationapi.model.user;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class User {
    private int id;
    private String name;
    private  String userName;
    private String password;
    private String email;
    private Date date;
    private String type;
    private BigDecimal saldo;
}
