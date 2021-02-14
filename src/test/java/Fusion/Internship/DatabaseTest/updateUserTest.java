package Fusion.Internship.DatabaseTest;

import Fusion.Internship.DAO.User;
import Fusion.Internship.DAO.UserDAOImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class updateUserTest {

    static Date date = new Date();
    static long time = date.getTime();
    static private Timestamp lastLogin = new Timestamp(time);

    @Test
    public void testUpdateUser() throws SQLException {
        User user = new User();
        user.setUsername("username");
        user.setEmail("username@gmail.com");
        user.setPassword("password");
        User insertedUser = UserDAOImpl.insertUser(user);

        insertedUser.setLastLogin(lastLogin);

        UserDAOImpl.updateUser(insertedUser);

        User newUser = UserDAOImpl.getUser(insertedUser);
        assertEquals(newUser.getLastLogin() != null, true);

        UserDAOImpl.deleteUser(insertedUser);
    }
}
