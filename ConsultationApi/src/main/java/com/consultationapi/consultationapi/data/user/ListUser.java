package com.consultationapi.consultationapi.data.user;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListUser extends ConnectionAttributes {
    public ArrayList listUser(){
        ArrayList<Object> list = new ArrayList();
        String query="select* from usuario u  inner join  informacion_usuarios i on u.id=i.id_usuario";
        try {
            stamente = con.conexion().createStatement();
          resultSet  =stamente.executeQuery(query);
            while(resultSet.next()){
                TypeUser user= new TypeUser();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setUserName (resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
                user.setDate(resultSet.getDate(6));
                user.setType(resultSet.getString(7));
                user.setSaldo( BigDecimal.valueOf(resultSet.getDouble(8)));
                user.setAddress(resultSet.getString(10));
                user.setPhone(resultSet.getInt(11));
                user.setCui(resultSet.getInt(12));
                list.add(user);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public  ArrayList  listAdmin(){
        ArrayList<User> list= new ArrayList();
        String query ="select* from usuario";
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                User  admin = new User();
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setUserName(resultSet.getString(3));
                admin.setPassword(resultSet.getString(4));
                admin.setEmail(resultSet.getString(5));
              //  admin.setDate(resultSet.getDate(6));
                admin.setType(resultSet.getString(7));
                admin.setSaldo( BigDecimal.valueOf(resultSet.getDouble(8)));
                list.add(admin);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
