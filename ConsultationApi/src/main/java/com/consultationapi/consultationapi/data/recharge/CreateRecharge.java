package com.consultationapi.consultationapi.data.recharge;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.Recharge.Recharge;

import java.sql.Date;
import java.sql.SQLException;

public class CreateRecharge extends ConnectionAttributes {
    public boolean create(Recharge recharge){
        boolean estado=false;
        String query="INSERT INTO recarga (id,monto,fecha,id_usuario) VALUES (?,?,?,?)";
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1,recharge.getId());
            preparedStatement.setBigDecimal(2,recharge.getMonto());
            preparedStatement.setDate( 3,new Date(recharge.getDate().getTime()));
            preparedStatement.setInt(4,recharge.getIdUser());
            preparedStatement.executeUpdate();
            estado=true;
        }catch(SQLException e){
            System.out.println ("Error a la hora de crear una recarga: "+e);
            estado=false;
        }
        return estado;
    }
}
