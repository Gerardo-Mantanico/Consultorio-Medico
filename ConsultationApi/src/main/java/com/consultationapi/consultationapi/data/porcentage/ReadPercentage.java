package com.consultationapi.consultationapi.data.porcentage;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.percentage.Percentage;
import com.consultationapi.consultationapi.state.State;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadPercentage extends ConnectionAttributes {
    public Percentage read(){
        Percentage percentage1 = new Percentage();
        String query="SELECT* FROM porcentaje WHERE estado='"+State.ACTIVO.name()+"'";
        try{
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                Percentage percentage= new Percentage();
                percentage.setId(resultSet.getInt(1));
                percentage.setPorcentage(resultSet.getInt(2));
                percentage.setStartDate(resultSet.getDate(3));
                percentage.setFinalDAte(resultSet.getDate(4));
                percentage.setState(resultSet.getString(5));
                percentage1=percentage;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return percentage1;
    }
}
