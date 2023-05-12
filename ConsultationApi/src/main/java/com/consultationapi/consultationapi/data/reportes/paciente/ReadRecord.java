package com.consultationapi.consultationapi.data.reportes.paciente;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.paciente.ReporteConsul;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRecord extends ConnectionAttributes {

    public ArrayList<ReporteConsul> consulta(int id ,LocalDate dateStart, LocalDate dateEnd ){
        ArrayList<ReporteConsul> list = new ArrayList<>();
        String query="SELECT c.id AS id_consulta, e.nombre AS especialidad, m.nombre AS medico, c.fecha_incial, c.fecha_final, c.informe, 'Consulta' AS tipo " +
                "FROM CONSULTA c " +
                "JOIN USUARIO m ON c.id_medico = m.id " +
                "JOIN ESPECIALIDADES e ON c.id_especialidad = e.id " +
                "WHERE c.id_paciente ="+id  +
                " AND c.fecha_incial BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        try {
             stamente=con.conexion().createStatement();
             resultSet=stamente.executeQuery(query);
             while (resultSet.next()){
                  ReporteConsul reporteConsul=  new ReporteConsul();
                  reporteConsul.setId(resultSet.getInt(1));
                  reporteConsul.setName(resultSet.getString(2));
                  reporteConsul.setMedico(resultSet.getString(3));
                  reporteConsul.setDate(resultSet.getDate(4).toString());
                  list.add(reporteConsul);
             }
             resultSet.close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public  ArrayList<String> examenes(int idPa,int idcon ,LocalDate dateStart, LocalDate dateEnd){
        ArrayList<String> list = new ArrayList<>();
        String query="SELECT c.id AS id_consulta, te.nombre AS examen, '' AS medico, c.fecha_incial, c.fecha_final, '' AS informe, 'Examen' AS tipo" +
                " FROM CONSULTA c " +
                "JOIN LISTA_EXAMENES_CONSULTA lec ON c.id = lec.id_consulta " +
                "JOIN TIPOS_EXAMENES te ON lec.id_examen = te.id " +
                "WHERE c.id_paciente ="+idPa+"  and c.id="+idcon +
                " AND c.fecha_incial  BETWEEN '"+dateStart+"' AND '"+dateEnd+"'"  +
                "ORDER BY fecha_incial DESC";
        String name;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                name=resultSet.getString(2);
                list.add(name);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

