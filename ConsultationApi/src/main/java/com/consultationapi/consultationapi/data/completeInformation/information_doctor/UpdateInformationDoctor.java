package com.consultationapi.consultationapi.data.completeInformation.information_doctor;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateInformationDoctor extends ConnectionAttributes{
    public boolean Update(CompleteInformation complement){
        boolean estado=false;
        String query= "UPDATE lista_especialidad set precio_consulta="+complement.getCost()+" where id="+complement.getId();
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
