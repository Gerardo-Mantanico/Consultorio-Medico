package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.data.user.ListUser;
import com.consultationapi.consultationapi.data.user.ReadUser;
import com.consultationapi.consultationapi.data.user.UpdataUser;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import com.consultationapi.consultationapi.model.user.TypeUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final CreateUser createUserss;
    private final ListUser  listUser;
    private final ReadUser readUser;
    private final UpdataUser updataUser;
    public UserService(){
        createUserss = new CreateUser();
        listUser= new ListUser();
        readUser= new ReadUser();
        updataUser = new UpdataUser();
    }
    public void createUser(TypeUser typeUser){
        if(typeUser.getSaldo()==null){
            typeUser.setSaldo(new BigDecimal(0.00));
        }
        createUserss.createUser(typeUser);
        if(typeUser.getId()==0){
            int id =readUser.getId(typeUser);
            System.out.println("EL di es "+id);
            typeUser.setId(id);
            createUserss.informationComplet(typeUser);
            return;
        }
        createUserss.informationComplet(typeUser);

    }
    public List<TypeUser> readAll() {
        return listUser.listUser();
    }
    public TypeUser read(int id) {
        return  readUser.readTypeUser(id);
    }
    public void update(TypeUser typeUSer){
        updataUser.updateTypeUSer(typeUSer);
    }

    public TypeUser perfil(int id, ArrayList scheduleDoctor, ArrayList specialty){
          var perfil= readUser.readTypeUser(id);
          perfil.setHour(scheduleDoctor);
          perfil.setSpecialty(specialty);
        return perfil;
    }

}
