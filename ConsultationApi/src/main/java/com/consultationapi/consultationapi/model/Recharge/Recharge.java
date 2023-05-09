package com.consultationapi.consultationapi.model.Recharge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Setter @Getter
public class Recharge {

    private int id;
    private int idUser;
    private BigDecimal monto;
    private Date date;

}
