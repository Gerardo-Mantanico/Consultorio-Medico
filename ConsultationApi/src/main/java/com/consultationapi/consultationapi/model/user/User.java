package com.consultationapi.consultationapi.model.user;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


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
