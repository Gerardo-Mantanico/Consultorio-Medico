package com.consultationapi.consultationapi.data.request.lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.request.RequestExamType;
import com.consultationapi.consultationapi.model.request.SpecialtyRequest;
import com.consultationapi.consultationapi.state.State;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListLab extends ConnectionAttributes {
    public ArrayList list(){
        String query="SELECT* FROM solicitud_tipos_examenes WHERE estado='"+State.PENDIENTE_REVISION.name()+"'";
        ArrayList<RequestExamType> list= new ArrayList<>();
        try {
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while(resultSet.next()){
                 RequestExamType requestExamType= new RequestExamType();
                 requestExamType.setId(resultSet.getInt(1));
                 requestExamType.setIdDoctor(resultSet.getInt(2));
                 requestExamType.setName(resultSet.getString(3));
                 requestExamType.setDescription(resultSet.getString(4));
                 requestExamType.setState(resultSet.getString(5));
                 list.add(requestExamType);
             }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public RequestExamType read(int id){
        String query="SELECT* FROM solicitud_tipos_examenes WHERE id="+id;
        RequestExamType request= new RequestExamType();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                RequestExamType requestExamType= new RequestExamType();
                requestExamType.setId(resultSet.getInt(1));
                requestExamType.setIdDoctor(resultSet.getInt(2));
                requestExamType.setName(resultSet.getString(3));
                requestExamType.setDescription(resultSet.getString(4));
                requestExamType.setState(resultSet.getString(5));
                request=requestExamType;
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return request;
    }
}
