package Fusion.Internship.Service;

import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.UserDAO;
import Fusion.Internship.DAO.UserDAOImpl;
import Fusion.Internship.Model.login;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class UserServiceImpl implements UserService{
    static Date date = new Date();
    static long time = date.getTime();
    static private Timestamp lastLogin = new Timestamp(time);

    public static String databaseLogin(User verifiedUser) throws SQLException {

        User temp = new User();
        temp = verifiedUser;
        verifiedUser = UserDAOImpl.login(temp);
        if(!(verifiedUser.getUsername().equals("FAIL"))) {
            if(verifiedUser.getLastLogin() != null) {
                verifiedUser.setLastLogin(lastLogin);
                UserDAOImpl.updateUser(verifiedUser);
                return "successOld";
            } else{
                verifiedUser.setLastLogin(lastLogin);
                UserDAOImpl.updateUser(verifiedUser);
                return "successNew";
            }
        }else {
            return "invalid";
        }
    }

    public static User getUser(User user) throws SQLException{
        return UserDAOImpl.getUser(user);
    }

    public static String googleLogin(User newGoogleUser) throws SQLException {

        if(!(UserDAOImpl.getUser(newGoogleUser).getEmail().equals(newGoogleUser.getEmail()))) {
            try {
                UserDAOImpl.insertUser(newGoogleUser);
                UserDAOImpl.updateUser(newGoogleUser);
                return "successNew";
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else{
            UserDAOImpl.updateUser(newGoogleUser);
            return "successOld";
        }
    }

    public static ArrayList<User> showUserTable() throws SQLException {
        return UserDAOImpl.getAllUsers();
    }

    public static void deleteUser(int loginID) throws SQLException {
        User tempUser = new User();
        tempUser.setLoginID(loginID);
        UserDAOImpl.deleteUser(tempUser);
    }

    public static void updateUser(boolean adminStatus, int loginID) throws SQLException {
        User temp = new User(loginID, null, null);
        temp.setAdmin(adminStatus);
        UserDAOImpl.updateAdminStatus(temp);
    }

}
