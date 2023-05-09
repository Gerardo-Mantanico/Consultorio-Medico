package com.consultationapi.consultationapi.resources;

import com.consultationapi.consultationapi.model.time.ScheduleDoctor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerateSchedules {
    private List<String> listSchedule;
    public GenerateSchedules(){
        this.listSchedule=new ArrayList<>();
    }
    public List scehdules(ScheduleDoctor scheduleDoctor){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime hoursStart = LocalTime.parse(scheduleDoctor.getStart(), formatter);
        LocalTime hoursEnd= LocalTime.parse(scheduleDoctor.getEnd(), formatter);
        int durationInMinutes = (hoursEnd.getHour() * 60 + hoursEnd.getMinute()) -
                (hoursStart.getHour() * 60 + hoursStart.getMinute());
        LocalTime scheduleTime = LocalTime.of(hoursStart.getHour(), hoursStart.getMinute());

        for (int i = 0; i <=durationInMinutes; i += 60) {
            LocalTime time = scheduleTime.plusMinutes(i);
            this.listSchedule.add(time.toString());
        }
        return listSchedule;
    }

    public List<String> getListSchedule() {
        return listSchedule;
    }
}
