/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultationapi.consultationapi.data.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.model.Especialidad;

import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class CreateSpecialty extends ConnectionAttributes {
    
    public void create(Especialidad specialty){
     String query="INSERT INTO especialidades (id,nombre,descriptcion) values (?,?,?)";
      try {
          preparedStatement  = con.conexion().prepareStatement(query);
          preparedStatement.setInt(1,specialty.getId());
          preparedStatement.setString(2,specialty.getNombre());
          preparedStatement.setString(3,specialty.getDescripcion());
          preparedStatement.executeUpdate();
          System.out.println("Especialidad Registrada");
      }catch (SQLException e){
          System.out.println("Error al crear Especialidad: " + e);
      }
     
    }
}
