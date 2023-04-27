package com.consultationapi.consultationapi.data.completeInformation.time;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateTime extends ConnectionAttributes {
    public void Update(ScheduleDoctor hour){
        String query="update lista_horarios set horario_inicial ='"+hour.getStart()+"' ,  horario_final='"+hour.getEnd()+"'  where id_medico="+hour.getId();
        try {
            stamente = con.conexion().createStatement();
            stamente.execute(query);
            con.conexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
