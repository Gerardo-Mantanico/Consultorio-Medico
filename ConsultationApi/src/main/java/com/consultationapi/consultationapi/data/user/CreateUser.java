package com.consultationapi.consultationapi.data.user;
import com.consultationapi.consultationapi.data.connection.ConnectionAttributes;
import com.consultationapi.consultationapi.data.connection.DataConnection;
import com.consultationapi.consultationapi.model.user.TypeUser;
import com.consultationapi.consultationapi.model.user.User;

import java.sql.*;


public class CreateUser extends ConnectionAttributes {
    //meto para guardar usuarios en la base de datos
    public  void createUser(User user) {
        String query="INSERT INTO usuario (id,nombre,nombre_usuario,contraseña,correo,fecha,tipo,saldo) VALUES (?,?,?,?,?,?,?,?)";
        try{

            preparedStatement  = con.conexion().prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4,   user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setDate (6, new java.sql.Date(user.getDate().getTime()) );
            preparedStatement.setString(7,   user.getType());
            preparedStatement.setDouble(8, user.getSaldo().doubleValue());
            preparedStatement.executeUpdate();
            System.out.println("Usuario registrado");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario : " + e);
        }
    }
    public  void informationComplet(TypeUser typeUser) {
        String queryr = "INSERT INTO INFORMACION_USUARIOS (id_usuario,direccion,telefono,cui) VALUES (?,?,?,?)";
        try{
            preparedStatement  = con.conexion().prepareStatement(queryr);
            preparedStatement.setInt(1, typeUser.getId());
            preparedStatement.setString(2, typeUser.getAddress());
            preparedStatement.setLong(3, typeUser.getPhone());
            preparedStatement.setLong(4,   typeUser.getCui());
            preparedStatement.executeUpdate();
            System.out.println("completaciond de informacion  guardada");
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion: " + e);
        }
    }
}


