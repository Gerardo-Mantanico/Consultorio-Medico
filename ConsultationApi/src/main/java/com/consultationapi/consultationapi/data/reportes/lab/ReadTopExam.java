package com.consultationapi.consultationapi.data.reportes.lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTopExam extends ConnectionAttributes {

    public ArrayList<Top5> read(int id, LocalDate dateStart, LocalDate dateEnd){
        ArrayList<Top5> list = new ArrayList<>(5);
        String query=" SELECT te.nombre AS nombre_examen, COUNT(*) AS total_examenes, SUM(l.costo) AS total_ingresos" +
                " FROM SOLICITUD_EXAMENES se " +
                "JOIN USUARIO u ON u.id = se.id_paciente" +
                " JOIN LISTA_EXAMENES_SOLICITUD l ON l.id_solicitud = se.id " +
                "JOIN TIPOS_EXAMENES te ON te.id = l.id_examen " +
                "WHERE se.fecha_solicitada BETWEEN '"+dateStart+"' AND '"+dateEnd+"'  and se.id_lab="+id +
                " GROUP BY te.nombre" +
                " ORDER BY total_ingresos DESC;";
        try{
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                Top5 top5= new Top5();
                top5.setName(resultSet.getString(1));
                top5.setCantidad(resultSet.getInt(2));
                top5.setTotal(resultSet.getBigDecimal(3));
                list.add(top5);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
