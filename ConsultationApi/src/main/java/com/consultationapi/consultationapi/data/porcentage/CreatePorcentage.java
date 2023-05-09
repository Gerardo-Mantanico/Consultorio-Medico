package com.consultationapi.consultationapi.data.porcentage;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.percentage.Percentage;

import java.sql.Date;
import java.sql.SQLException;

public class CreatePorcentage extends ConnectionAttributes {

    public boolean create(Percentage percentage){
        String query="INSERT INTO porcentaje (id, porcentaje,fecha_inicio,fecha_final,estado) VALUES(?,?,?,?,?)";
        boolean state=false;
        try{
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,percentage.getId());
            preparedStatement.setInt(2,percentage.getPorcentage());
            preparedStatement.setDate(3,new java.sql.Date(percentage.getStartDate().getTime()));
            preparedStatement.setDate(4, null);
            preparedStatement.setString(5,percentage.getState());
            preparedStatement.executeUpdate();
            state=true;
        }catch (SQLException e){
            state=false;
            System.out.println("Error  a lal hora de crear un nuevo porcentaje :"+e);
        }
        return state;
    }
}
