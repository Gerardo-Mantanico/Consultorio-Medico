package com.consultationapi.consultationapi.data.request.lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.request.RequestExamType;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;

import java.sql.SQLException;

public class CreateRequestLab extends ConnectionAttributes {
    public  void create(RequestExamType requestExamType){
        String query="INSERT INTO solicitud_tipos_examenes (id,id_lab,nombre,descriptcion,estado) VALUES (?,?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,requestExamType.getId());
            preparedStatement.setInt(2,requestExamType.getIdLaboratory());
            preparedStatement.setString(3,requestExamType.getName());
            preparedStatement.setString(4, requestExamType.getDescription());
            preparedStatement.setString(5,requestExamType.getState());
            preparedStatement.executeUpdate();
            System.out.println("solicitud guardada");
        }catch (SQLException ex){
            System.out.println("Error a la hora de crear solicitud: "+ ex);
        }
    }
}
