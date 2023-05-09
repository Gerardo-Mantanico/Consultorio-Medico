package com.consultationapi.consultationapi.data.type_exam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.specialtyExam.TypeExam;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTypeExam extends ConnectionAttributes {
    public void create(TypeExam typeExam){
        String query="INSERT INTO tipos_examenes (id,nombre,descriptcion) VALUES(?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,typeExam.getId());
            preparedStatement.setString(2,typeExam.getName());
            preparedStatement.setString(3,typeExam.getDescription());
            preparedStatement.executeUpdate();
            System.out.println("Especialidad Creada");
        }catch (SQLException e){
            System.out.println("Erro a la hora de crear tipo de examen en "+e);
        }
    }
}
