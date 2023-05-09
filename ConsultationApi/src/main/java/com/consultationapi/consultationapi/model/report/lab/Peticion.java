package com.consultationapi.consultationapi.model.report.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
 @Getter @Setter  @AllArgsConstructor @NoArgsConstructor
public class Peticion {
        private String type;
        private int id;
        private  String  dateStart;
        private  String dateEnd;

}
