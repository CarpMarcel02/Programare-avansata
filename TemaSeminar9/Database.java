package org.example;

import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/Java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Monster02@";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() {
       if(connection ==null){
           createConnection();
       }
       return connection;
    }
    /**
     * creez conexiunea cu baza de date
     */
    private static void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            System.out.println("Am reusit sa ma conectez ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public static void closeConnection() {
        try{
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
}
    public static void rollback() {
        Connection con = getConnection();
        try {
            con.rollback();
        } catch (SQLException e) {
            System.err.println("Failed to rollback transaction: " + e.getMessage());
        }
    }

}