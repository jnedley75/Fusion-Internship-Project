package Fusion.Internship.DAO;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO{

    static User insertUser(User user) throws SQLException {
        return user;
    }
    static User login(User user){
        return user;
    }

    static User getUser(User user) throws SQLException{
        return user;
    }

    static void updateUser(User user) throws SQLException{
    }

    static ArrayList<User> getAllUsers() throws SQLException{
        return null;
    }

    static void deleteUser(User user) throws SQLException{
    }

    static void printUser(User user) {
    }

    static void updateAdminStatus(User user){
    }

    public void setUserDAOImpl(DriverManagerDataSource dataSource);
}