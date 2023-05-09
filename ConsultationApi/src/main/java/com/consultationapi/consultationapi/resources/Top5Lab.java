package com.consultationapi.consultationapi.resources;

import com.consultationapi.consultationapi.data.reportes.admin.ConsultLab;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.util.ArrayList;

public class Top5Lab {

    private ConsultLab consultLab;

    public Top5Lab(){
        this.consultLab=new ConsultLab();
    }



    public ArrayList<Top5> costruc(){
        ArrayList<Top5> list = new ArrayList<>(5);
        for( Top5 medicos: consultLab.Top5()){
            medicos.setCantidad(consultLab.cantidad(medicos.getId()));
            //falta restar el saldo xd
            medicos.setTotal(consultLab.total(medicos.getId()));
            list.add(medicos);
        }
        return list;
    }
}
