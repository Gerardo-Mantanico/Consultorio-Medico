package com.consultationapi.consultationapi.data.type_exam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.model.TipoExamen;

import java.sql.SQLException;

public class CreateTypeExam extends ConnectionAttributes {
    public void create(TipoExamen typeExam){
        String query="INSERT INTO tipos_examenes (id,nombre,descriptcion) VALUES(?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,typeExam.getId());
            preparedStatement.setString(2,typeExam.getNombre());
            preparedStatement.setString(3,typeExam.getDescripcion());
            preparedStatement.executeUpdate();
            System.out.println("Especialidad Creada");
        }catch (SQLException e){
            System.out.println("Erro a la hora de crear tipo de examen en "+e);
        }
    }
}
