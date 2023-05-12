package com.consultationapi.consultationapi.resources;

import com.consultationapi.consultationapi.data.reportes.admin.ConsultTop5;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.util.ArrayList;

public class Top5Medicos {

    private ConsultTop5 constrrucReport;
    public  Top5Medicos(){
        this.constrrucReport= new ConsultTop5();

    }

    public ArrayList<Top5> costruc(){
        ArrayList<Top5> list = new ArrayList<>(5);
        for( Top5 medicos: constrrucReport.Top5()){
               medicos.setCantidad(constrrucReport.cantidad(medicos.getId()));

               var total= medicos.getTotalConsultas().subtract(constrrucReport.total(medicos.getId()));
               medicos.setTotal(total);
               list.add(medicos);
        }
        return list;
    }
}
