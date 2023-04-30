package com.consultationapi.consultationapi.model.user;

import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import lombok.*;

import java.util.ArrayList;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class TypeUser extends User{
    private  String address;
    private long phone;
    private long cui;
    private ArrayList<ScheduleDoctor> hour;
    private ArrayList<CompleteInformation> specialty;
}
