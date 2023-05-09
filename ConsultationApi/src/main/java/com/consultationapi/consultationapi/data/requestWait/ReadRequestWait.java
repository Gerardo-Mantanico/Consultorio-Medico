package com.consultationapi.consultationapi.data.requestWait;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.lab.requestWait.ExamWait;
import com.consultationapi.consultationapi.model.lab.requestWait.RequestWait;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRequestWait extends ConnectionAttributes {

    public ArrayList<RequestWait> searchRequest(String id){
        String query="select s.id, u.nombre, s.fecha_solicitada, s.estado  from  solicitud_examenes s join usuario u on s.id_paciente=u.id  where id_lab="+id;
        ArrayList<RequestWait> list = new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                RequestWait requestWait = new RequestWait();
                 requestWait.setIdRequest(resultSet.getInt(1));
                 requestWait.setName(resultSet.getString(2));
                 requestWait.setDate(resultSet.getDate(3));
                 requestWait.setState(resultSet.getString(4));
                 list.add(requestWait);
            }
            resultSet.close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<ExamWait> searchExam(int id){
        String query="select l.id_examen, t.nombre,  l.costo   from   lista_examenes_solicitud l   join tipos_examenes t on l.id_examen=t.id     where id_solicitud="+id;
        ArrayList<ExamWait> list= new ArrayList<>();
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                ExamWait examWait = new ExamWait();
                examWait.setIdExam(resultSet.getInt(1));
                examWait.setName(resultSet.getString(2));
                examWait.setCost(resultSet.getBigDecimal(3));
                list.add(examWait);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
