package com.consultationapi.consultationapi.data.porcentage;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.percentage.Percentage;

import java.sql.SQLException;

public class UpdatePercentage extends ConnectionAttributes {
    public void updata(Percentage percentage){
        String query="UPDATE porcentaje SET estado='"+percentage.getState()+"' and fecha_final='"+percentage.getFinalDAte()+"' ";
        try {
            stamente = con.conexion().createStatement();
            stamente.executeUpdate(query);
            stamente.close();
        }catch(SQLException ex){
            System.out.println("Erro en "+ex);
        }
    }
}
