package com.consultationapi.consultationapi.service;

import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.data.user.ListUser;
import com.consultationapi.consultationapi.data.user.ReadUser;
import com.consultationapi.consultationapi.data.user.UpdataUser;
import com.consultationapi.consultationapi.model.user.TypeUser;

import java.util.List;

public class UserService {
    private final CreateUser createUser;
    private final ListUser  listUser;
    private final ReadUser readUser;
    private final UpdataUser updataUser;
    public UserService(){
        createUser = new CreateUser();
        listUser= new ListUser();
        readUser= new ReadUser();
        updataUser = new UpdataUser();
    }
    public void createUser(TypeUser typeUser){
        createUser.createUser(typeUser);
        createUser.informationComplet(typeUser);
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

}
