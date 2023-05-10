package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.specialty.ReadSpecialty;
import com.consultationapi.consultationapi.model.model.Especialidad;

import java.util.List;

public class SpecialtyService {
    private final CreateSpecialty createSpecialty;
    private final ReadSpecialty readSpecialty;
    public SpecialtyService(){
        createSpecialty = new  CreateSpecialty();
        readSpecialty= new ReadSpecialty();
    }
    public  void crete(Especialidad specialty){
        createSpecialty.create(specialty);
    }
    public Especialidad read(int id){
        return readSpecialty.read(id);
    }
    public List<Especialidad> readall(){
        return readSpecialty.readlist();
    }
}
