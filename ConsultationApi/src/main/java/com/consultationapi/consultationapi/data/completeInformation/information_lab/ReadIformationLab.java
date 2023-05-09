package com.consultationapi.consultationapi.data.completeInformation.information_lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.comple_information.CompleteInformation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadIformationLab extends ConnectionAttributes {

    public ArrayList readlist(int id){
        String query="SELECT*  FROM lista_examenes_lab join tipos_examenes on   id_examen=tipos_examenes.id where id_lab="+id;
        ArrayList<CompleteInformation> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                CompleteInformation completeInformation= new CompleteInformation();
                completeInformation.setId(resultSet.getInt(1));
                completeInformation.setId_user(resultSet.getInt(2));
                completeInformation.setId_type(resultSet.getInt(3));
                completeInformation.setCost(resultSet.getBigDecimal(4));
                completeInformation.setName(resultSet.getString(6));
                list.add(completeInformation);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
