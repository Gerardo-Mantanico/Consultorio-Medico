package com.consultationapi.consultationapi.data.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.specialtyExam.Specialty;

import javax.security.auth.login.CredentialExpiredException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadSpecialty extends ConnectionAttributes {
    public Specialty read(int id){
        String query="select* from especialidades where id="+id;
        Specialty specialty1 = null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                Specialty specialty= new Specialty();
                specialty.setId(resultSet.getInt(1));
                specialty.setName(resultSet.getString(2));
                specialty.setDescription(resultSet.getString(3));
                specialty1=specialty;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return specialty1;
    }

    public ArrayList readlist(){
        String query="select* from especialidades";
        ArrayList<Specialty> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                Specialty specialty= new Specialty();
                specialty.setId(resultSet.getInt(1));
                specialty.setName(resultSet.getString(2));
                specialty.setDescription(resultSet.getString(3));
                list.add(specialty);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
