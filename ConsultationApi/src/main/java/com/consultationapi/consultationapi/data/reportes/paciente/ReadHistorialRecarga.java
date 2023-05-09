package com.consultationapi.consultationapi.data.reportes.paciente;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.user.CreateUser;
import com.consultationapi.consultationapi.model.report.paciente.HistorialRecarga;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadHistorialRecarga extends ConnectionAttributes {

    public ArrayList<HistorialRecarga> read(int id){
        ArrayList<HistorialRecarga> lis = new ArrayList<>();
        String query="select* from recarga where id_usuario="+id;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                HistorialRecarga historialRecarga= new HistorialRecarga();
                historialRecarga.setMonto(resultSet.getBigDecimal(2));
                historialRecarga.setDate(resultSet.getDate(3).toString());
                lis.add(historialRecarga);
            }
        }catch (SQLException ex){
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lis;
    }
}
