package com.consultationapi.consultationapi.data.request.lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;
import com.consultationapi.consultationapi.model.request.RequestExamType;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdataRequest  extends ConnectionAttributes {
    public void Update(RequestExamType requestExamType){
        String query= "UPDATE solicitud_tipos_examenes set estado='"+requestExamType.getState()+"' where id="+requestExamType.getId();
        try {
            stamente = con.conexion().createStatement();
            stamente.execute(query);
            con.conexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
