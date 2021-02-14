package Fusion.Internship.DAOTests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Fusion.Internship.DAO.UserDAO;
import Fusion.Internship.DAO.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class getAllUsersTest {

    @Test
    public void testGetAllUsers() throws SQLException {
        ArrayList<User> users = UserDAO.getAllUsers();
        int count = 0;
        for (int i = 0; i <= 1; i++) {
            UserDAO.printUser(users.get(i));
        }

        assertEquals(UserDAO.getUser(users.get(0)).getUsername(), "jjn0004");
    }
}
