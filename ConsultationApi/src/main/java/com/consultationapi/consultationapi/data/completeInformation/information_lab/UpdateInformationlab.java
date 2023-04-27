package com.consultationapi.consultationapi.data.completeInformation.information_lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateInformationlab extends ConnectionAttributes{
    public void Update(CompleteInformation complement){
        String query= "UPDATE lista_especialidad set precio_consulta="+complement.getCost()+" where id="+complement.getId_user();
        try {
            stamente = con.conexion().createStatement();
            stamente.execute(query);
            con.conexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
