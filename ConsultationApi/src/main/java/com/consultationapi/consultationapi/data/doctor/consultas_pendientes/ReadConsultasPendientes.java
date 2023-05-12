package com.consultationapi.consultationapi.data.doctor.consultas_pendientes;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.doctor.ver_consultas.SolicitudesPendientes;
import com.consultationapi.consultationapi.model.login.Login;
import com.consultationapi.consultationapi.state.State;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadConsultasPendientes extends ConnectionAttributes {
    public ArrayList<SolicitudesPendientes> read(int idMedico){
        ArrayList<SolicitudesPendientes> list = new ArrayList<>();
        String query= "  SELECT c.id , c.fecha_incial AS id_consulta, u.nombre AS nombre_paciente, e.nombre AS tipo_especialidad " +
                "FROM CONSULTA c " +
                "INNER JOIN USUARIO u ON c.id_paciente = u.id " +
                "INNER JOIN ESPECIALIDADES e ON c.id_especialidad = e.id " +
                "WHERE  c.id_medico="+idMedico+"  and c.estado='"+State.AGENDADA.name()+"'";
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                SolicitudesPendientes solicitudesPendientes = new SolicitudesPendientes();
                    solicitudesPendientes.setIdConsulta(resultSet.getInt(1));
                    solicitudesPendientes.setNombrePaciente( resultSet.getString(3));
                    solicitudesPendientes.setEspecialidad(resultSet.getString(4));
                    solicitudesPendientes.setDataStart( resultSet.getString(2));
                list.add(solicitudesPendientes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
