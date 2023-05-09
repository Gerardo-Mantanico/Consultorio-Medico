package com.consultationapi.consultationapi.resources;

import com.consultationapi.consultationapi.data.reportes.lab.ReadTopPaciente;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Top5Pacienes {
    private ReadTopPaciente readTopPaciente;
    public  Top5Pacienes(){
        this.readTopPaciente= new ReadTopPaciente();
    }

    public ArrayList<Top5> construc(int id, LocalDate dateStart, LocalDate dateEnd){
        ArrayList<Top5> list = new ArrayList<>();
        for(Top5 paciente: readTopPaciente.cantidad(id,dateStart,dateEnd)){
            paciente.setName(readTopPaciente.nombre(paciente.getId()));
            paciente.setTotal(readTopPaciente.total(paciente.getId(), id));
            list.add(paciente);
        }
        return list;
    }
}
