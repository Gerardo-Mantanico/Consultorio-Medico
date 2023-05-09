package com.consultationapi.consultationapi.data.reportes.admin;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.admin.PercentageHistory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class histPorcentaje extends ConnectionAttributes {
    public ArrayList<PercentageHistory> historial(){
        ArrayList<PercentageHistory> list= new ArrayList<>();
        String query="SELECT* FROM porcentaje";
        try{
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                PercentageHistory percentageHistory= new PercentageHistory();
                percentageHistory.setPercentage(resultSet.getInt(2));
                percentageHistory.setDataStar(resultSet.getDate(3));
                percentageHistory.setDataEnd(resultSet.getDate(4));
                percentageHistory.setEstado(resultSet.getString(5));
                list.add(percentageHistory);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
