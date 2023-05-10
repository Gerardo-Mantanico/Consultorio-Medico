package com.consultationapi.consultationapi.data.type_exam;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.model.TipoExamen;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTypeExam extends ConnectionAttributes {
    public TipoExamen  read(int id){
        String query="select* from tipos_examenes where id="+id;
        TipoExamen typeExam= null;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                TipoExamen typeExam1=new TipoExamen();
                typeExam1.setId(resultSet.getInt(1));
                typeExam1.setNombre(resultSet.getString(2));
                typeExam1.setDescripcion(resultSet.getString(3));
                typeExam=typeExam1;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
     return typeExam;
    }

    public ArrayList readList(){
        String query="select* from tipos_examenes";
        ArrayList<TipoExamen> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                TipoExamen typeExam = new TipoExamen();
                typeExam.setId(resultSet.getInt(1));
                typeExam.setNombre(resultSet.getString(2));
                typeExam.setDescripcion(resultSet.getString(3));
                list.add(typeExam);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
