package com.consultationapi.consultationapi.data.login;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.login.Login;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultl extends ConnectionAttributes {
    public Login read(Login user){
        String query="select* from usuario where correo='"+user.getEmail()+"'";
        Login login1=null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                Login login = new Login();
                login.setEmail(resultSet.getString(3));
                login.setPassword(resultSet.getString(4));
                login1=login;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login1;
    }
}
