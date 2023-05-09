package com.consultationapi.consultationapi.model.patient;

import com.consultationapi.consultationapi.data.CreateRequestExam.ReadModelExam;

import java.math.BigDecimal;
import java.util.ArrayList;

public class contruc {


    public ArrayList construccion() {
        ReadModelExam readModelExam = new ReadModelExam();
        ArrayList<RequestEx> lista = new ArrayList<>();
        int id=0;
        for (ModelExam lab : readModelExam.read()) {
            if(lab.getIdLab()!=id){
                ArrayList<Exam> list = new ArrayList<>();
                for (ModelExam exam : readModelExam.read()) {
                    if (lab.getIdLab() == exam.getIdLab()) {
                        Exam exames = new Exam(exam.getIdExam(), exam.getNameExam(), exam.getDescripcion(), exam.getCost());
                       // System.out.println("precio:"+ exames.getCost());
                        list.add(exames);
                    }
                }
                RequestEx request = new RequestEx(0,lab.getIdLab(), lab.getName(), list);
               // System.out.println(request.getIdLab()+"   "+request.getLisExam());
                id= lab.getIdLab();
                lista.add(request);
            }
        }
        return lista;
    }
}
