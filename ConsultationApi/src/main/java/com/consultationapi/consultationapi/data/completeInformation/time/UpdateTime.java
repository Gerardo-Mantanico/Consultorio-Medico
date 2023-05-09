package com.consultationapi.consultationapi.data.completeInformation.time;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateTime extends ConnectionAttributes {
    public boolean Update(ScheduleDoctor hour){
        boolean estado=false;
        String query="update lista_horarios set horario_inicial ='"+hour.getStart()+"',  horario_final='"+hour.getEnd()+"'  where id="+hour.getId();
        try {
            stamente = con.conexion().createStatement();
            stamente.execute(query);
            con.conexion().close();
            estado=true;
        } catch (SQLException ex) {
            estado=false;
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
}
