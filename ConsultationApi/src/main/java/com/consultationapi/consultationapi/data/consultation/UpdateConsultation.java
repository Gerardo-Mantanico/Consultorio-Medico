package com.consultationapi.consultationapi.data.consultation;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;

import java.sql.SQLException;

public class UpdateConsultation extends ConnectionAttributes {
    public void update(){
        String query="UPDATE SET";
        try {
            stamente=con.conexion().createStatement();
            stamente.executeUpdate(query);
            stamente.close();

        }catch(SQLException ex){

        }
    }
}
