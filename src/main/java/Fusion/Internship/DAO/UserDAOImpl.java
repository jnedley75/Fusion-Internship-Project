package Fusion.Internship.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Fusion.Internship.Database.DatabaseManager;

public class UserDAOImpl implements UserDAO{

    private static Connection conn = conn();
    private JdbcTemplate jt;

    @Override
    public void setUserDAOImpl(DriverManagerDataSource dataSource) {
        jt = new JdbcTemplate(dataSource);
    }

    public static Connection conn() {
        try {
            return DatabaseManager.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static User insertUser(User user) throws SQLException {
        int loginID = user.getLoginID();
        String email = user.getEmail();
        Timestamp lastLogin = user.getLastLogin();
        String username = user.getUsername();
        String password = user.getPassword();
        int age = user.getAge();
        String gender = user.getGender();

        String sql = "INSERT INTO login (Email,Username,LastLogin,Pass,AdminStatus, Age, Gender) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, email);
        ps.setString(2, username);
        ps.setTimestamp(3, lastLogin);
        ps.setString(4, password);
        ps.setBoolean(5, false);
        ps.setInt(6,age);
        ps.setString(7, gender);

        ps.executeUpdate();


        return user;
    }

    public static User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        String sql = "SELECT * FROM login WHERE Username = '"+username+"' and Pass = '"+password+"'";
        //SELECT * FROM databaseschema.login where Username = 'testCase102 ' and Pass = 'test1';
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            rs.next();

            if(user.getUsername().equals(rs.getString("Username"))) {
                user.setLoginID(rs.getInt("LoginID"));
                user.setEmail(rs.getString("Email"));
                user.setLastLogin(rs.getTimestamp("LastLogin"));
                user.setLoggedIn(true);
                return user;
            }
            else {
                User failUser = new User();
                failUser.setUsername("FAIL");
                return failUser;
            }


        } catch (SQLException e) {
            User failUser = new User();
            failUser.setUsername("FAIL");
            return failUser;
        }


    }


    public static User getUser(User user) throws SQLException {
        String sql = "SELECT * FROM login WHERE Username = '" + user.getUsername() + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        rs.beforeFirst();
        rs.next();

        try {
            int loginID = rs.getInt("LoginID");
            String email = rs.getString("Email");
            Timestamp lastLogin = rs.getTimestamp("LastLogin");
            String username = rs.getString("Username");
            boolean admin = rs.getBoolean("AdminStatus");
            String password = rs.getString("Pass");
            boolean loggedStatus = rs.getBoolean("loggedStatus");
            rs.close();

            User returnedUser = new User(loginID, email, username);
            returnedUser.setAdmin(admin);
            returnedUser.setPassword(password);
            returnedUser.setLoggedIn(loggedStatus);

            return returnedUser;
        } catch (SQLException e) {
            try {
                String email = rs.getString("Email");
                Timestamp lastLogin = rs.getTimestamp("LastLogin");
                String username = rs.getString("Username");
                boolean admin = rs.getBoolean("AdminStatus");
                String password = rs.getString("Pass");

                rs.close();

                User returnedUser = new User(email, username);
                returnedUser.setAdmin(admin);
                returnedUser.setPassword(password);

                return returnedUser;
            } catch (SQLException e2) {
                User failUser = new User("failUser.12.12.12@gmail.com", "failUser.12.12.12");
                return failUser;
            }
        }
    }


    public static void updateUser(User user) throws SQLException {
        int loginID = user.getLoginID();
        String email = user.getEmail();
        String username = user.getUsername();
        Timestamp lastlogin = user.getLastLogin();
        boolean admin = user.getAdmin();

        String sql = "UPDATE login" + "\nSET Username = '" + username + "', Email = '"
                + email + "', LastLogin = '" + lastlogin + "', AdminStatus = " + admin + " WHERE LoginID = " + loginID;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    public static ArrayList<User> getAllUsers() throws SQLException{
        String sql = "SELECT * FROM login";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ArrayList<User> users = new ArrayList<>();

            ResultSet rs = ps.executeQuery(sql);
            rs.first();
            //while to rs.next()
            while(true){
                User temp = new User();
                temp.setLoginID(rs.getInt("LoginID"));
                temp.setEmail(rs.getString("Email"));
                temp.setUsername(rs.getString("Username"));
                temp.setAge(rs.getInt("Age"));
                temp.setGender(rs.getString("Gender"));
                temp.setLastLogin(rs.getTimestamp("lastLogin"));
                users.add(temp);

                if (rs.isLast()) {
                    break;
                }
                rs.next();
            }
            rs.close();
            return users;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    public static void deleteUser(User user) throws SQLException {
        int loginID = user.getLoginID();
        String sql = "DELETE FROM login WHERE LoginID = " + loginID;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }

    public static void updateAdminStatus(User user) throws SQLException{
        int loginID = user.getLoginID();
        boolean admin = user.getAdmin();

        String sql = "UPDATE login" + "\nSET AdminStatus = " + admin + " WHERE LoginID = " + loginID;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }


    public static void printUser(User user) {
        int loginID = user.getLoginID();
        String email = user.getEmail();
        String username = user.getUsername();

        System.out.println("***********************************************************");
        System.out.print("User details:");
        System.out.print("\nLogin ID: " + loginID);
        System.out.print("\nEmail: " + email);
        System.out.print("\nUsername: " + username);
        System.out.println("\n***********************************************************\n");

    }

}
