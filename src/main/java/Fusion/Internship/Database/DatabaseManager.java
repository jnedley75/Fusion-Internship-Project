package Fusion.Internship.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public static DatabaseManager dbm = new DatabaseManager();
    public static Connection conn = null;

    public static Connection openConnection() throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3306/databaseschema";
        String username = "root";
        String password = "fusion";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, username, password);
            if(conn != null) {
                System.out.println("Connection to database is Successful");
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("Connection to database failed");
        }
        return conn;
    }
}

