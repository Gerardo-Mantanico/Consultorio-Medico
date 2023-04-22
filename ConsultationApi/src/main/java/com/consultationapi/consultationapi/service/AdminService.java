package com.consultationapi.consultationapi.service;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.data.user.ListUser;
import com.consultationapi.consultationapi.data.user.ReadUser;
import com.consultationapi.consultationapi.model.user.User;

import java.util.List;

public class AdminService {
    private final ListUser lisAdmin;
    private  final CreateUser createUser;
    private final ReadUser readUser;
    public AdminService (){

        lisAdmin = new ListUser();
        createUser = new CreateUser();
        readUser= new ReadUser();
        
    }
    public List<User> readAll() {
        return lisAdmin.listAdmin();
    }
    public void create(User user){
        createUser.createUser(user);
    }
    public User read(int id){
        return readUser.readAdmin(id);
    }
}
