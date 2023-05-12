package com.consultationapi.consultationapi.data.consultation.Examenes;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;

import java.sql.SQLException;

public class CreateExmenesConsulta extends ConnectionAttributes {
    public void create(int idconsult,int id){
        String query="insert into lista_examenes_consulta(id_consulta,id_examen) values (?,?)";
        try{
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,idconsult);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println("examenes de consulta registrado");
        }catch (SQLException e){
            System.out.println("error a la hora de crear examenes de consula "+e);
        }
    }
}
