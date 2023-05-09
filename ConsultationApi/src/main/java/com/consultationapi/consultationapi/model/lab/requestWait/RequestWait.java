package com.consultationapi.consultationapi.model.lab.requestWait;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter @Setter
public class RequestWait {
    private int idRequest;
    private String name;
    private Date date;
    private ArrayList<ExamWait> exam;
    private String state;

}
