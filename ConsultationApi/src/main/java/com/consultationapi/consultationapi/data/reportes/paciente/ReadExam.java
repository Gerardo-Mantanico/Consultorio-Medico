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
        String query="SELECT TE.nombre AS tipo_examen, COUNT(LES.id_examen) AS cantidad_examenes " +
                "FROM SOLICITUD_EXAMENES SE " +
                "INNER JOIN LISTA_EXAMENES_SOLICITUD LES ON SE.id = LES.id_solicitud " +
                "INNER JOIN TIPOS_EXAMENES TE ON LES.id_examen = TE.id " +
                "WHERE SE.fecha_solicitada BETWEEN '"+dateStart+"' AND '"+dateEnd+"'" +
                "  AND SE.id_paciente ="+id +
                " GROUP BY TE.nombre;";
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
