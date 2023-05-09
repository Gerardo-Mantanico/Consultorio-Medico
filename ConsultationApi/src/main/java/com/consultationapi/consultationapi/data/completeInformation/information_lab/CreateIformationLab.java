package com.consultationapi.consultationapi.data.completeInformation.information_lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;

public class CreateIformationLab extends ConnectionAttributes {

     public  boolean create(CompleteInformation complement){
         boolean estado= false;
         String query="INSERT INTO  lista_examenes_lab (id_lab,id_examen,costo) values (?,?,?)";
         try {
             preparedStatement=con.conexion().prepareStatement(query);
             preparedStatement.setInt(1,complement.getId_user());
             preparedStatement.setInt(2,complement.getId_type());
             preparedStatement.setBigDecimal(3,complement.getCost());
             preparedStatement.executeUpdate();
             estado=true;
         }catch (SQLException e){
             estado=false;
             System.out.println("Error al crear Especialidad: " + e);
         }
         return estado;
     }
}
