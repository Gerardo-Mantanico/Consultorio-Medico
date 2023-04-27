package com.consultationapi.consultationapi.data.completeInformation.information_lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;

public class CreateIformationLab extends ConnectionAttributes {

     public  void create(CompleteInformation complement){
         String query="INSERT INTO  lista_especialidad (id_medico,id_especialidad,precio_consulta) values (?,?,?)";
         try {
             preparedStatement=con.conexion().prepareStatement(query);
             preparedStatement.setInt(1,complement.getId_user());
             preparedStatement.setInt(2,complement.getId_type());
             preparedStatement.setBigDecimal(3,complement.getCost());
             preparedStatement.executeUpdate();
         }catch (SQLException e){
             System.out.println("Error al crear Especialidad: " + e);
         }

     }
}
