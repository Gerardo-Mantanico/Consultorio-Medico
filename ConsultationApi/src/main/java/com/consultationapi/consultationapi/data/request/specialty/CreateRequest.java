package com.consultationapi.consultationapi.data.request.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;

import java.sql.SQLException;

public class CreateRequest  extends ConnectionAttributes {
    public  void create(SpecialtyRequest specialtyRequest){
        String query="INSERT INTO solicitud_especialidad (id,id_medico,nombre,descriptcion,estado) VALUES (?,?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,specialtyRequest.getId());
            preparedStatement.setInt(2,specialtyRequest.getIdDoctor());
            preparedStatement.setString(3,specialtyRequest.getName());
            preparedStatement.setString(4, specialtyRequest.getDescription());
            preparedStatement.setString(5,specialtyRequest.getState());
            preparedStatement.executeUpdate();
            System.out.println("solicitud guardada");
        }catch (SQLException ex){
            System.out.println("Error a la hora de crear solicitud: "+ ex);
        }
    }
}
