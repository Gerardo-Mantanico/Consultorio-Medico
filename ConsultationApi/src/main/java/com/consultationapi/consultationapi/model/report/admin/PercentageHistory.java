package com.consultationapi.consultationapi.model.report.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PercentageHistory {
        private  int percentage;
        private Date dataStar;
        private Date dataEnd;
        private String estado;

}
