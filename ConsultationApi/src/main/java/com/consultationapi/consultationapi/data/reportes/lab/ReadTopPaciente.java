package com.consultationapi.consultationapi.data.reportes.lab;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTopPaciente extends ConnectionAttributes {

        //pasar fecha
    public ArrayList<Top5> cantidad(int id, LocalDate dateStart, LocalDate dateEnd){
        ArrayList<Top5> list = new ArrayList<>(5);
        String query=" SELECT  id_paciente,  COUNT(*) as Total  FROM solicitud_examenes   where id_lab="+id+"  and  fecha_solicitada BETWEEN '"+dateStart+"' AND '"+dateEnd+"'  GROUP BY id_paciente  order by  Total desc";
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                Top5 top5= new Top5();
                top5.setId(resultSet.getInt(1));
                top5.setCantidad(resultSet.getInt(2));
                list.add(top5);
            }
        }catch (SQLException e){
        }
        return list;
    }

    public String nombre(int id){
        String name= "";
        String query="select id, nombre from usuario where id="+id;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                name=resultSet.getString(2);
            }
            resultSet.close();
        }catch (SQLException e){
        }
        return name;
    }

    public BigDecimal total(int idpaciente, int idLab){
        BigDecimal cantidad = new BigDecimal(10.5);
       /* String query="SELECT SUM(l.costo * (1 - s.porcentaje)) as costo_total " +
                "FROM solicitud_examenes  " +
                "JOIN lista_examenes_solicitud l ON s.id = l.id_solicitud " +
                "WHERE s.id_paciente ="+idpaciente+"  AND s.id_lab ="+idLab;
*/
        String query="select SUM(costo)  from solicitud_examenes s join lista_examenes_solicitud l  on  s.id=l.id_solicitud  where id_paciente="+idpaciente+" and id_lab="+idLab;
        try{
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()) {
                cantidad=resultSet.getBigDecimal(1);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

}
