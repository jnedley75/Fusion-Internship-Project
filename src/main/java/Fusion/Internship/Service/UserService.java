package Fusion.Internship.Service;

import Fusion.Internship.DAO.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;

import java.util.ArrayList;

public interface UserService {

    static String registerUser(User user){ return null; }

    static String databaseLogin(User user){
        return null;
    }

    static User getUser(User user) { return null; }

    static String googleLogin(User newGoogleUser){
        return null;
    }

    static ArrayList<User> showUserTable(){return null;}

    static void deleteUser(int loginID){}

    static void updateUser(boolean adminStatus, int loginID){}
}
