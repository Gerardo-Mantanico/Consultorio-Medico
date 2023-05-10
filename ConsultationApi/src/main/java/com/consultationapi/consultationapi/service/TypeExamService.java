package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.type_exam.CreateTypeExam;
import com.consultationapi.consultationapi.data.type_exam.ReadTypeExam;
import com.consultationapi.consultationapi.model.model.TipoExamen;

import java.util.List;

public class TypeExamService {
    private  final CreateTypeExam createTypeExam;
    private  final ReadTypeExam readTypeExam;
    public TypeExamService(){
        createTypeExam=new CreateTypeExam();
        readTypeExam = new ReadTypeExam();
    }
    public List<TipoExamen> readall(){
        return readTypeExam.readList();
    }
    public TipoExamen read(int id){
        return readTypeExam.read(id);
    }
}
