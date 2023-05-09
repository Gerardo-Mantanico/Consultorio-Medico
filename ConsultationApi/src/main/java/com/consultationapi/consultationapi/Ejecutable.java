package com.consultationapi.consultationapi;


import com.consultationapi.consultationapi.data.completeInformation.time.ReadTime;
import com.consultationapi.consultationapi.data.connection.DataConnection;
import com.consultationapi.consultationapi.data.login.Consultl;
import com.consultationapi.consultationapi.data.reportes.lab.ReadTopExam;
import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.login.Login;
import com.consultationapi.consultationapi.model.patient.contruc;
import com.consultationapi.consultationapi.model.report.admin.Top5;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.resources.Top5Lab;
import com.consultationapi.consultationapi.resources.Top5Medicos;
import com.consultationapi.consultationapi.resources.Top5Pacienes;
import com.consultationapi.consultationapi.utils.GsonUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Ejecutable {

    public static void main(String args[]){
        
     /*   DataConnection d= new DataConnection();
        d.conexion();

/*        typeUser.setId(0);
        typeUser.setName("luis");
        typeUser.setUserName("camilyyyyyoccc");
        typeUser.setPassword("contrase;a");
        typeUser.setAddress("zona 2");
        typeUser.setCui(000023132132);
        typeUser.setPhone(370171769);
        typeUser.setEmail("luis@gmail.com");
        typeUser.setDate(LocalDate.of(2023,10,02));
        typeUser.setSaldo(BigDecimal.valueOf(20.23));
        typeUser.setType("Medico");
        CreateUser c = new CreateUser();
        c.createUser(typeUser);
        c.informationComplet(typeUser);
       /* Consultl c = new Consultl();
        Login a  = new Login();
        a.setUser("boby");
        System.out.println(c.read(a));*/
        ///
        /*LocalDate fecha = LocalDate.of(2023, 10, 2);
        String fechaString = fecha.toString();
        System.out.println(fechaString);*/

       /* LocalTime initialTime = LocalTime.of(8, 0); // 9:00 AM
        LocalTime finalTime = LocalTime.of(12, 0); // 5:00 PM


        int durationInMinutes = (finalTime.getHour() * 60 + finalTime.getMinute()) -
                (initialTime.getHour() * 60 + initialTime.getMinute());

        List<LocalTime> schedule = new ArrayList<>();
        LocalTime scheduleTime = LocalTime.of(initialTime.getHour(), initialTime.getMinute());

        for (int i = 0; i <=durationInMinutes; i += 60) {
            LocalTime time = scheduleTime.plusMinutes(i);
            System.out.println(time);
            schedule.add(time);
        }

*/  String fechaTexto = "2023-05-07";
        LocalDate fecha = LocalDate.parse(fechaTexto);
        ReadTopExam readTopExam = new ReadTopExam();


    }
}

