package Hotel.Management.System;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBCon {

    Connection connection;
    Statement statement;

    public DBCon(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelEE","root","niloy");
            statement = connection.createStatement();
        }catch(Exception e) {
            e.getStackTrace();
        }
    }
}