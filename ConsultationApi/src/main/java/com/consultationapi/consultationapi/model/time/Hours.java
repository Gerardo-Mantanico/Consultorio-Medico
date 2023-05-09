package com.consultationapi.consultationapi.model.time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
public class Hours {
    @Getter @Setter
    private String star;
    private String end;

    public Hours(String star, String end) {
        this.star=star;
        this.end = end;
    }


}
