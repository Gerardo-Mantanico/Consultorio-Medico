package com.consultationapi.consultationapi.data.reportes.admin;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.admin.Top5;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultTop5 extends ConnectionAttributes {
    public ArrayList<Top5> Top5(){
        ArrayList<Top5> list= new ArrayList<>(5);
        String query="select id, nombre, saldo  from usuario where tipo='Doctor' order by saldo desc";
        try{
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()) {
                Top5 top5 = new Top5();
                top5.setId(resultSet.getInt(1));
                top5.setName(resultSet.getString(2));
                top5.setTotalConsultas(resultSet.getBigDecimal(3));
                list.add(top5);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

     public int cantidad(int id){
         int cantidad=0;
         String query="SELECT id_medico,  COUNT(*) as Total  FROM consulta  where id_medico="+id+"  GROUP BY id_medico  order by  Total desc";
         try{
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while (resultSet.next()) {
                  cantidad=resultSet.getInt(2);
             }
         }catch (SQLException ex){
             Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
         }
         return cantidad;
     }

    public BigDecimal total(int id){
        BigDecimal cantidad = new BigDecimal(10.5);
        String query="select  SUM(precio) from consulta where id_medico="+id;
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
