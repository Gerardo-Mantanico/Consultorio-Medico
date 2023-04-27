package com.consultationapi.consultationapi.model.time;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;

@Getter @Setter
public class ScheduleDoctor {
    private int id;
    private Time start;
    private Time end;
}
