package com.consultationapi.consultationapi.model.time;

import lombok.Getter;
import lombok.Setter;


import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Getter @Setter
public class ScheduleDoctor {
    private int id;
    private int idDoctor;
    private String start;
    private String end;
}
