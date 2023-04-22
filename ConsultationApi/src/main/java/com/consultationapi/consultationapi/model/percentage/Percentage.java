package com.consultationapi.consultationapi.model.percentage;

import lombok.*;

import java.util.Date;
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Percentage {
    private int id ;
    private int porcentage;
    private Date StartDate;
    private Date  FinalDAte;
    private String state;

}
