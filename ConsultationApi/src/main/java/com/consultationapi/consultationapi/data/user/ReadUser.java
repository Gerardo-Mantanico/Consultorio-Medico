package com.consultationapi.consultationapi.data.user;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadUser  extends ConnectionAttributes {
    public TypeUser readTypeUser(int id){
        ResultSet r;
        TypeUser typeUser=null;
        String query="select* from usuario u  inner join  informacion_usuarios i on u.id=i.id_usuario where u.id="+id;
        try {
            stamente = con.conexion().createStatement();
            r=stamente.executeQuery(query);
            while(r.next()){
                TypeUser user= new TypeUser();
                user.setId(r.getInt(1));
                user.setName(r.getString(2));
                user.setUserName(r.getString(3));
                user.setPassword(r.getString(4));
                user.setEmail(r.getString(5));
                user.setDate(r.getDate(6));
                user.setType(r.getString(7));
                user.setSaldo( BigDecimal.valueOf(r.getDouble(8)));
                user.setAddress(r.getString(10));
                user.setPhone(r.getLong(11));
                user.setCui(r.getLong(12));
                typeUser=user;
            }
        }catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeUser;
    }
    public User readAdmin(int id){
         User admin = new User();
         String query="select* from usuario where id="+id;
         try {
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while (resultSet.next()){
                 admin.setId(resultSet.getInt(1));
                 admin.setName(resultSet.getString(2));
                 admin.setUserName(resultSet.getString(3));
                 admin.setPassword(resultSet.getString(4));
                 admin.setEmail(resultSet.getString(5));
                 admin.setDate(resultSet.getDate(6));
                 admin.setType(resultSet.getString(7));
                 admin.setSaldo(resultSet.getBigDecimal(8));
             }
         }catch (SQLException ex){
             Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
         }
        return admin;
    }
    public int getId(TypeUser typeUser){
        int id=0;
        String query="SELECT* FROM usuario where nombre_usuario='"+typeUser.getUserName()+"'";
        try {
            stamente = con.conexion().createStatement();
            resultSet = stamente.executeQuery(query);
            while(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null,ex);
        }
        return id;
    }
}
