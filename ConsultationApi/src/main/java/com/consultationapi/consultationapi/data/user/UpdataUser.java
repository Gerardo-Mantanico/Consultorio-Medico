package com.consultationapi.consultationapi.data.user;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.user.TypeUser;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdataUser extends ConnectionAttributes {
    public void  updateTypeUSer(TypeUser typeUser){
        String query= "UPDATE usuario set saldo="+typeUser.getSaldo()+
                ",nombre="+typeUser.getName()+
                ",nombre_usuario="+typeUser.getUserName()+
                ",contraseña="+typeUser.getPassword()+
                ",correo="+typeUser.getEmail()+
                ",fecha="+typeUser.getDate()+
                ",tipo="+typeUser.getType()+
                " where id="+typeUser.getId();
        try {
            stamente = con.conexion().createStatement();
            stamente.execute(query);
            con.conexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void recharge(int id, BigDecimal saldo){
        String query="UPDATE usuario SET saldo = saldo+"+saldo+" WHERE id="+id;
        try {
            stamente=con.conexion().createStatement();
            stamente.executeUpdate(query);
            con.conexion().close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void  discount(int id, BigDecimal saldo){
        String query="UPDATE usuario SET saldo = saldo-"+saldo+" WHERE id="+id;
        try {
            stamente=con.conexion().createStatement();
            stamente.executeUpdate(query);
            con.conexion().close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
