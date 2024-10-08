package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

    private static final String URL = "-----------------------";
    private static final String USER = "----";
    private static final String PASSWORD = "---------------";

    public static Connection connection = null;


    public static Connection openConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso");
        } catch (SQLException e) {
            System.out.println("Problem com o "+ e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Problem com o "+ e.getMessage());
        }
    }
}
