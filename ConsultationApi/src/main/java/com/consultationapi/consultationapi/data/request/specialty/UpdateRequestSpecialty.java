package com.consultationapi.consultationapi.data.request.specialty;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateRequestSpecialty extends ConnectionAttributes {
    public boolean Update(SpecialtyRequest specialtyRequest){
        boolean estado=false;
        String query= "UPDATE solicitud_especialidad  set  estado='"+specialtyRequest.getState()+"'  where id="+specialtyRequest.getId();
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
