package com.consultationapi.consultationapi.data.completeInformation.time;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.time.ScheduleDoctor;
import com.consultationapi.consultationapi.model.user.TypeUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTime extends ConnectionAttributes {
    public ArrayList readList(int id){
        String query="select* from lista_horarios where id_medico="+id;
        ArrayList<ScheduleDoctor> list = new ArrayList<>();
         try {
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while (resultSet.next()){
                 ScheduleDoctor scheduleDoctor = new ScheduleDoctor();
                 scheduleDoctor.setId(resultSet.getInt(1));
                 scheduleDoctor.setStart(resultSet.getTime(2));
                 scheduleDoctor.setEnd(resultSet.getTime(3));
                 list.add(scheduleDoctor);
             }
         resultSet.close();
         }catch (SQLException ex) {
             Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
         }
        return list;
    }
}
