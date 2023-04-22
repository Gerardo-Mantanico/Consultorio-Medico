package com.consultationapi.consultationapi.data.connection;

import lombok.Getter;
import lombok.Setter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Getter @Setter
public class ConnectionAttributes {
    public DataConnection con = new DataConnection();
    public  PreparedStatement preparedStatement;
    public Statement stamente;
    public ResultSet resultSet;
}
