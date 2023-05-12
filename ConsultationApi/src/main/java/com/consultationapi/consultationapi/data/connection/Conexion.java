package com.consultationapi.consultationapi.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conexion = null;
    private static  final  String USER="root";
    private  static final  String PASSWORD="123456789";
    private  static final  String URL_MYSQL="jdbc:mysql://localhost:3306/data_consultorio";

    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e);
        }
    }

    public static Connection obtenerConexion() {
        if(conexion == null) {
            new Conexion();
            System.out.println("Conexión exitosa");
        }
        return conexion;
    }
}
