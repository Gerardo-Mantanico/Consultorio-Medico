package com.consultationapi.consultationapi.data.CreateRequestExam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.patient.ModelExam;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadModelExam extends ConnectionAttributes {

    public ArrayList<ModelExam> read(){
        String query="select u. id, u. nombre, l.id_examen, e.nombre, e.descriptcion ,  l.costo  from usuario u   join lista_examenes_lab l on  l.id_lab=u.id    join tipos_examenes  e on e.id=l.id_examen      where u. tipo='Laboratorio'";
        ArrayList<ModelExam> list= new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet = stamente.executeQuery(query);
            while(resultSet.next()){
                ModelExam modelExam = new ModelExam();
                modelExam.setIdLab(resultSet.getInt(1));
                modelExam.setName(resultSet.getString(2));
                modelExam.setIdExam(resultSet.getInt(3));
                modelExam.setNameExam(resultSet.getString(4));
                modelExam.setDescripcion(resultSet.getString(5));
                modelExam.setCost(resultSet.getBigDecimal(6));
                list.add(modelExam);
            }
            resultSet.close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
