package com.consultationapi.consultationapi.data.porcentage;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.percentage.Percentage;
import com.consultationapi.consultationapi.state.State;

import java.sql.SQLException;
import java.util.Date;

public class UpdatePercentage extends ConnectionAttributes {
    public void updata(Date fecha ,int id){

        String query="update porcentaje set estado='"+State.DESACTIVO.name()+"' ,   fecha_final='"+new java.sql.Date(fecha.getTime())+"'   where id="+id;
        try {
            stamente = con.conexion().createStatement();
            stamente.executeUpdate(query);
            stamente.close();
        }catch(SQLException ex){
            System.out.println("Erro en "+ex);
        }
    }
}
