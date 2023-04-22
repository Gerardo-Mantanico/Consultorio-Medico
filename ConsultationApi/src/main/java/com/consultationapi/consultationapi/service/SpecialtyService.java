package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.specialty.ReadSpecialty;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;

import java.util.List;

public class SpecialtyService {
    private final CreateSpecialty createSpecialty;
    private final ReadSpecialty readSpecialty;
    public SpecialtyService(){
        createSpecialty = new  CreateSpecialty();
        readSpecialty= new ReadSpecialty();
    }
    public  void crete(Specialty specialty){
        createSpecialty.create(specialty);
    }
    public Specialty read(int id){
        return readSpecialty.read(id);
    }
    public List<Specialty> readall(){
        return readSpecialty.readlist();
    }
}
