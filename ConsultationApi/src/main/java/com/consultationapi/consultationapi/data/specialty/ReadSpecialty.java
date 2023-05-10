package com.consultationapi.consultationapi.data.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.model.Especialidad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadSpecialty extends ConnectionAttributes {
    public Especialidad read(int id){
        String query="select* from especialidades where id="+id;
        Especialidad specialty1 = null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                Especialidad specialty= new Especialidad();
                specialty.setId(resultSet.getInt(1));
                specialty.setNombre(resultSet.getString(2));
                specialty.setDescripcion(resultSet.getString(3));
                specialty1=specialty;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return specialty1;
    }

    public ArrayList readlist(){
        String query="select* from especialidades";
        ArrayList<Especialidad> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                Especialidad specialty= new Especialidad();
                specialty.setId(resultSet.getInt(1));
                specialty.setNombre(resultSet.getString(2));
                specialty.setDescripcion(resultSet.getString(3));
                list.add(specialty);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
