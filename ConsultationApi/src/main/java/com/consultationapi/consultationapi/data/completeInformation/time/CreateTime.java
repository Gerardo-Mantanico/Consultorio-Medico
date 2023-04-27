package com.consultationapi.consultationapi.data.completeInformation.time;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;

import java.sql.SQLException;
import java.sql.Time;

public class CreateTime extends ConnectionAttributes {

    public  void create(ScheduleDoctor doctor){
        String query="insert into lista_horarios (id_medico,horario_inicial,horario_final,) values (?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,doctor.getId());
            preparedStatement.setTime(2, doctor.getStart());
            preparedStatement.setTime(3, doctor.getEnd());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("error a la hora de guardar en "+e);
        }

    }
}
