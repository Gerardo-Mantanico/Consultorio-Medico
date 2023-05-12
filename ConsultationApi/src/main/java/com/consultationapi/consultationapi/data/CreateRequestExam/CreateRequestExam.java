package com.consultationapi.consultationapi.data.CreateRequestExam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.patient.RequestEx;
import com.consultationapi.consultationapi.state.State;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

public class CreateRequestExam extends ConnectionAttributes {
    public void create(RequestEx requestEx,int porcentaje){
        String query="INSERT INTO  solicitud_examenes(id,id_paciente,id_lab,porcentaje,fecha_solicitada,fecha_finalizada,estado) VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,requestEx.getIdPaciente());
            preparedStatement.setInt(3,requestEx.getIdLab());
            BigDecimal porcentaj =  new BigDecimal(porcentaje);
            BigDecimal porciento = new BigDecimal("100");
            BigDecimal resultado = porcentaj.divide(porciento, 5, BigDecimal.ROUND_HALF_UP);
            preparedStatement.setBigDecimal(4, resultado);
            Date fechaActual = new Date();
            preparedStatement.setDate(5,new java.sql.Date(fechaActual.getTime()));
            preparedStatement.setDate(6,null);
            preparedStatement.setString(7, State.PENDIENTE.name());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("error al crear un solicitud de examen  "+e);
        }

    }
}
