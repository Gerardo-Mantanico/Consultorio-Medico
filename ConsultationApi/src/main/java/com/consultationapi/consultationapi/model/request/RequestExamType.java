package com.consultationapi.consultationapi.model.request;

import lombok.*;
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class RequestExamType {
        private int id;
        private int IdLaboratory;
        private String name;
        private String description;
        private  String state;

}
