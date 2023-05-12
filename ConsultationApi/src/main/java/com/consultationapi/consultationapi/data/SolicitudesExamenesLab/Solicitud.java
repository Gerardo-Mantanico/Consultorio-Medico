package com.consultationapi.consultationapi.data.SolicitudesExamenesLab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.model.SolicitudExamen;
import com.consultationapi.consultationapi.model.patient.RequestEx;
import com.consultationapi.consultationapi.state.State;

import java.sql.SQLException;
import java.util.Date;

public class Solicitud extends ConnectionAttributes {



    public void create(SolicitudExamen requestEx){
        String query="INSERT INTO  solicitud_examenes(id,id_paciente,id_lab,porcentaje,fecha_solicitada,fecha_finalizada,estado) VALUES(?,?,?,?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,requestEx.getId());
            preparedStatement.setInt(2,requestEx.getPaciente());
            preparedStatement.setInt(3,requestEx.getLaboratorio());
            preparedStatement.setDouble(4,requestEx.getPorcentaje_aplicacion());
            preparedStatement.setDate(5, java.sql.Date.valueOf(requestEx.getFecha_solicitado()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(requestEx.getFecha_finalizado()));
            preparedStatement.setString(7, requestEx.getEstado_solicitud());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("error al crear un solicitud de examen  "+e);
        }

    }
}
