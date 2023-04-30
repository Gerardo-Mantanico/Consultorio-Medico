package com.consultationapi.consultationapi.data.request.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListSpecialty extends ConnectionAttributes {
    public ArrayList list(){
        String query="SELECT* FROM solicitud_especialidad";
        ArrayList<SpecialtyRequest> list= new ArrayList<>();
        try {
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while(resultSet.next()){
                 SpecialtyRequest specialtyRequest= new SpecialtyRequest();
                 specialtyRequest.setId(resultSet.getInt(1));
                 specialtyRequest.setIdDoctor(resultSet.getInt(2));
                 specialtyRequest.setName(resultSet.getString(3));
                 specialtyRequest.setDescription(resultSet.getString(4));
                 specialtyRequest.setState(resultSet.getString(5));
                 list.add(specialtyRequest);
             }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
