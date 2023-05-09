package com.consultationapi.consultationapi.data.searchId;

import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;

import java.sql.SQLException;

public class SearchId extends ConnectionAttributes {
    public int IdMax(String tipo){
        int id=0;
        String query="SELECT MAX(id) AS id FROM "+tipo;
        try {
            stamente=con.conexion().createStatement();
            resultSet=stamente.executeQuery(query);
            while (resultSet.next()){
                id=resultSet.getInt(1);
            }
        }catch (SQLException ex){
        }
        return id;
    }
}
