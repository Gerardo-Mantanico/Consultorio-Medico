package com.consultationapi.consultationapi.data.consultation;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.model.consultation.Consultation;

import java.sql.Date;
import java.sql.SQLException;

public class CreateConsultation extends ConnectionAttributes {
    public boolean create(Consultation consultation){
        boolean estado=false;
        String query="INSERT INTO consulta (id, id_paciente, id_medico, id_especialidad, porcentaje, fecha_incial, fecha_final, precio, informe, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?,?)" ;
        try {
            preparedStatement=con.conexion().prepareStatement(query);
            preparedStatement.setInt(1, consultation.getId());
            preparedStatement.setInt(2,consultation.getIdPatient());
            preparedStatement.setInt(3,consultation.getDoctor());
            preparedStatement.setInt(4,consultation.getSpecialty());
            preparedStatement.setDouble(5,consultation.getPorcentage());
            preparedStatement.setDate(6,  new Date( consultation.getDataStart().getTime()));
            preparedStatement.setDate(7,  null);
            preparedStatement.setBigDecimal(8,consultation.getPrecio());
            preparedStatement.setString(9,consultation.getInformation());
            preparedStatement.setString(10,consultation.getState());
            preparedStatement.executeUpdate();
            estado=true;
        }catch (SQLException e){
            estado=false;
            System.out.println("erron e la hora de crear una consulta en: "+e);
        }
        return estado;
    }
}
