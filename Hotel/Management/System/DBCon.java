package Hotel.Management.System;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBCon {

    Connection connection;
    Statement statement;

    public DBCon(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://switchback.proxy.rlwy.net:16925/hotelEE",
                    "root",
                    "TwUJAkmLvEmgnrGAQSZVXAEHMlCFFfDB"
            );
            statement = connection.createStatement();
            System.out.println("✅Database Connected Successfully!");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
