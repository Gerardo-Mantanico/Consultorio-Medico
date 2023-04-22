package com.consultationapi.consultationapi.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataConnection {
    private final  String USER="root";
    private final  String PASSWORD="123456789";
    private final  String URL_MYSQL="jdbc:mysql://localhost:3306/data_consultorio";
    private Connection con;
    
     public Connection conexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(URL_MYSQL,USER,PASSWORD);
            System.out.println("La conexion con la base de datos fue satiscaftorio");
        }catch (SQLException ex) {
            System.out.println("Error en la coxeion"+ ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }   
}
