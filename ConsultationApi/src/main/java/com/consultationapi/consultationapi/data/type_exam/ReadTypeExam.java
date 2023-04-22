package com.consultationapi.consultationapi.data.type_exam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.specialtyExam.TypeExam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTypeExam extends ConnectionAttributes {
    public TypeExam read(int id){
        String query="select* from tipos_examenes where id="+id;
        TypeExam typeExam= null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                TypeExam typeExam1=new TypeExam();
                typeExam1.setId(resultSet.getInt(1));
                typeExam1.setName(resultSet.getString(2));
                typeExam1.setDescription(resultSet.getString(3));
                typeExam=typeExam1;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
     return typeExam;
    }

    public ArrayList readList(){
        String query="select* from tipos_examenes";
        ArrayList<TypeExam> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                TypeExam typeExam = new TypeExam();
                typeExam.setId(resultSet.getInt(1));
                typeExam.setName(resultSet.getString(2));
                typeExam.setDescription(resultSet.getString(3));
                list.add(typeExam);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
