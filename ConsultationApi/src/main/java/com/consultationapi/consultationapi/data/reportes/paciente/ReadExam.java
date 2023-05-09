package com.consultationapi.consultationapi.data.reportes.paciente;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.paciente.ReporteEspecialidad;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadExam extends ConnectionAttributes {
    public ArrayList<ReporteEspecialidad> read(int id, LocalDate dateStart, LocalDate dateEnd){
        ArrayList<ReporteEspecialidad> list= new ArrayList<>();
        String query="SELECT te.nombre AS tipo_examen, COUNT(*) AS cantidad  " +
                "FROM CONSULTA c " +
                "JOIN LISTA_EXAMENES_CONSULTA lec ON c.id = lec.id_consulta " +
                "JOIN TIPOS_EXAMENES te ON lec.id_examen = te.id  " +
                "WHERE c.fecha_incial BETWEEN '"+dateStart+"' AND '"+dateEnd+"' and  c.id_paciente="+id +
                " GROUP BY tipo_examen;";
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
