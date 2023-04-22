package com.consultationapi.consultationapi;


import com.consultationapi.consultationapi.data.connection.DataConnection;
import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;
import com.consultationapi.consultationapi.model.user.TypeUser;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Ejecutable {

    public static void main(String args[]){
        
       /* DataConnection d= new DataConnection();
        d.conexion();

        TypeUser typeUser = new TypeUser();
        typeUser.setId(100);
        typeUser.setName("luis");
        typeUser.setUserName("luis");
        typeUser.setPassword("contrase;a");
        typeUser.setAddress("zona 2");
        typeUser.setCui(000023132132);
        typeUser.setPhone(370171769);
        typeUser.setEmail("luis@gmail.com");
        typeUser.setDate(Date.valueOf("2023-10-02"));
        typeUser.setSaldo(BigDecimal.valueOf(20.23));
        typeUser.setType("Medico");
        CreateUser c = new CreateUser();
        c.createUser(typeUser);
        c.informationComplet(typeUser);*/
        Specialty a= new Specialty();
        a.setId(100);
        a.setName("juan");
        a.setDescription("especialidad");
        CreateSpecialty c = new CreateSpecialty();
        c.create(a);
    }
}

