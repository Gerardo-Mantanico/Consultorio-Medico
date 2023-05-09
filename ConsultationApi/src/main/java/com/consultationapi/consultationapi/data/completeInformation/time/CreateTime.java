package com.consultationapi.consultationapi.data.completeInformation.time;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;

import java.sql.SQLException;
import java.sql.Time;

public class CreateTime extends ConnectionAttributes {

    public  boolean create(ScheduleDoctor doctor){
        boolean state=true;
        String query="insert into lista_horarios (id,id_medico,horario_inicial,horario_final) values (?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,doctor.getId());
            preparedStatement.setInt(2,doctor.getIdDoctor());
            preparedStatement.setTime(3, Time.valueOf(doctor.getStart()+":00"));
            preparedStatement.setTime(4, Time.valueOf(doctor.getEnd()+":00"));
            preparedStatement.executeUpdate();
            System.out.println("hora te atencion guardada");
            state=false;
        }catch (SQLException e){
            state=true;
            System.out.println("error a la hora de guardar en "+e);
        }
        return state;
    }
}
