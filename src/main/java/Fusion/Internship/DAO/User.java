package Fusion.Internship.DAO;

import java.util.Date;
import java.sql.Timestamp;

public class User {

    Date date = new Date();
    long time = date.getTime();
    private String username;
    private String password;
    private int loginID;
    private String email;
    private int age;
    private String gender;
    private Timestamp lastLogin = new Timestamp(time);
    private boolean admin;


    public User(int loginID, String email, String username) {
        this.username = username;
        this.loginID = loginID;
        this.email = email;
    }
    public User(String email, String username) {
        this.username = username;
        this.loginID = loginID;
        this.email = email;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int userID) {
        this.loginID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAdmin(boolean admin){ this.admin = admin; }

    public boolean getAdmin() { return admin; }
}