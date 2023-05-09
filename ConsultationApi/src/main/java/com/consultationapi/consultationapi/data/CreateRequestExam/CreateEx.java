package com.consultationapi.consultationapi.data.CreateRequestExam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.patient.Exam;

import java.sql.SQLException;

public class CreateEx extends ConnectionAttributes {
    public void create(Exam exam, int id){
        String query="INSERT INTO lista_examenes_solicitud (id_solicitud,id_examen,costo) VALUES (?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2,exam.getId());
            preparedStatement.setBigDecimal (3,exam.getCost());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("error a la hora de crear un examen "+e);
        }

    }
}
