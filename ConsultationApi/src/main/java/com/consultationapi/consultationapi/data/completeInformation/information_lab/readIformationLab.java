package com.consultationapi.consultationapi.data.completeInformation.information_lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readIformationLab extends ConnectionAttributes {

    public ArrayList readlist(){
        String query="";
        ArrayList<CompleteInformation> list =null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                CompleteInformation completeInformation= new CompleteInformation();
                completeInformation.setId_type(resultSet.getInt(1));
                completeInformation.setId_type(resultSet.getInt(2));
                completeInformation.setCost(resultSet.getBigDecimal(3));
                list.add(completeInformation);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
