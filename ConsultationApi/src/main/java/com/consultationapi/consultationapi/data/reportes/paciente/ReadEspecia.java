package com.consultationapi.consultationapi.data.reportes.paciente;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.paciente.ReporteEspecialidad;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadEspecia extends ConnectionAttributes {


    public ArrayList<ReporteEspecialidad> read(int id, LocalDate dateStart,LocalDate dateEnd){
        ArrayList<ReporteEspecialidad> list= new ArrayList<>();
        System.out.println(id+"   "+dateStart+"  "+dateEnd);
        String query="SELECT e.nombre AS especialidad, COUNT(c.id) AS total_consultas " +
                "FROM CONSULTA c " +
                "JOIN USUARIO m ON c.id_medico = m.id " +
                "JOIN ESPECIALIDADES e ON c.id_especialidad = e.id " +
                "WHERE c.id_paciente="+id+"  and  c.fecha_incial >= '"+dateStart+"' AND c.fecha_incial <= '"+dateEnd+"'" +
                "GROUP BY e.nombre " +
                "ORDER BY total_consultas DESC;";
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while(resultSet.next()){
                ReporteEspecialidad reporteEspecialidad = new ReporteEspecialidad();
                reporteEspecialidad.setName(resultSet.getString(1));
                reporteEspecialidad.setVecez(resultSet.getInt(2));
                list.add(reporteEspecialidad);
            }
            resultSet.close();
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
