package com.consultationapi.consultationapi.data.consultation;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.consultation.Consultation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadConsultation extends ConnectionAttributes {
    public Consultation read(){
        String query="SELECT* FROM consulta";
        Consultation consultation = new Consultation();
        try {
            stamente=con.conexion().createStatement();
            resultSet =stamente.executeQuery(query);
            while(resultSet.next()){
                Consultation consultation1= new Consultation();
                consultation1.setId(resultSet.getInt(1));
                consultation.setIdPatient(resultSet.getInt(2));
                consultation.setDoctor(resultSet.getInt(3));
                consultation.setSpecialty(resultSet.getInt(4));
                consultation.setPorcentage(resultSet.getFloat(5));
                consultation.setDataStart(resultSet.getDate(6));
                consultation.setDataEnd (resultSet.getDate(7));
                consultation.setPrecio(resultSet.getBigDecimal(8));
                consultation.setInformation(resultSet.getString(9));
                consultation.setState(resultSet.getString(10));
                resultSet.close();
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultation;
    }
}
