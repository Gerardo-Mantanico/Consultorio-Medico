package com.consultationapi.consultationapi.data.completeInformation.information_doctor;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadIformationDoctor extends ConnectionAttributes {

    public ArrayList readlist(int id){
        String query="select* from  lista_especialidad where id_medico="+id;
        ArrayList<CompleteInformation> list =new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                CompleteInformation completeInformation= new CompleteInformation();
                //completeInformation.setId_user(resultSet.getInt(1));
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
