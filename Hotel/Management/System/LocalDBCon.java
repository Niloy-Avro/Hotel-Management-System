package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LocalDBCon {
    Connection connection;
    Statement statement;

    public LocalDBCon(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotelEE",
                    "root",
                    "niloy"
            );
            statement = connection.createStatement();
            System.out.println("✅Database Connected Successfully!");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
 }