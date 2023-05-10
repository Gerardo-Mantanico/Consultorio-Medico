package com.consultationapi.consultationapi;


import com.consultationapi.consultationapi.data.specialty.CreateSpecialty;
import com.consultationapi.consultationapi.data.type_exam.CreateTypeExam;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.model.Admin;
import com.consultationapi.consultationapi.model.model.Especialidad;
import com.consultationapi.consultationapi.model.model.Medico;
import com.consultationapi.consultationapi.model.model.TipoExamen;
import com.consultationapi.consultationapi.model.user.User;
import com.consultationapi.consultationapi.readFile.Data;
import com.consultationapi.consultationapi.readFile.ReadFile;
import com.consultationapi.consultationapi.state.State;

import java.math.BigDecimal;
import java.sql.Date;

public class Ejecutable {

    public static void main(String args[]){
        ReadFile readFile = new ReadFile();
        Data data = readFile.read();
        System.out.println(data.getAdmin().get(0).getNombre());
        System.out.println(data.getTipos_examenes().get(2).getDescripcion());
        CreateUser createUser = new CreateUser();

      /* for(Admin admin: data.getAdmin()){
            User user = new User();
            user.setId(admin.getId());
            user.setName(admin.getNombre());
            user.setUserName(admin.getUsername());
            user.setPassword(admin.getPassword());
            user.setEmail(admin.getEmail());
            user.setDate(  Date.valueOf(admin.getFecha_nacimiento()));
            user.setSaldo(BigDecimal.valueOf(admin.getSaldo()));
            user.setType(State.ADMINISTRADOR.name());
            createUser.createUser(user);
        }*/
        /*for(Especialidad especialidad: data.getEspecialidades()){
            CreateSpecialty createSpecialty = new CreateSpecialty();
            createSpecialty.create(especialidad);

        }*/
       /* for(TipoExamen tipoExamen: data.getTipos_examenes()){
            CreateTypeExam createTypeExam = new CreateTypeExam();
            createTypeExam.create(tipoExamen);
        }*/

        


    }
}

