package com.consultationapi.consultationapi.resources;

import com.consultationapi.consultationapi.data.reportes.paciente.ReadRecord;
import com.consultationapi.consultationapi.model.report.paciente.ReporteConsul;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConstructionHistorialConsultas {

    private ReadRecord readRecord;
    public ConstructionHistorialConsultas(){
        this.readRecord= new ReadRecord();
    }
    public ArrayList<ReporteConsul> construc(int id, LocalDate dateStart , LocalDate dateEnd){
            ArrayList<ReporteConsul>  list= new ArrayList<>();
        for(  ReporteConsul  report: readRecord.consulta(id,dateStart,dateEnd)) {
                report.setNameExam(readRecord.examenes(id,dateStart,dateEnd));
             list.add(report);
        }
        return list;
    }
}
