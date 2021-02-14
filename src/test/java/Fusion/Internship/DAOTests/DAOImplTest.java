package Fusion.Internship.DAOTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import Fusion.Internship.DAO.UserDAO;
import Fusion.Internship.DAO.User;

public class DAOImplTest {

    private String email = "testCase@gmail.com";
    private String username = "testCase101";
    private String password = "test1";
    private User testUser = new User(email, username);

    @Before
    public void testInsertUser() throws Exception{
        System.out.println("Testing insertUser method...");
        testUser.setPassword(password);

        UserDAO.insertUser(testUser);
        UserDAO.printUser(testUser);
        assertNotNull(testUser.getLoginID());
    }

    @Test
    public void testGetUser() throws Exception{
        System.out.println("Testing getUser method...");

        User temp = UserDAO.getUser(testUser);
        UserDAO.printUser(temp);
        assertNotNull(temp.getLoginID());
        UserDAO.deleteUser(testUser);
    }

    @Test
    public void testUpdateUser() throws Exception{
        System.out.println("Testing updateUser method...");

        testUser.setUsername("testCase102");

        UserDAO.updateUser(testUser);
        UserDAO.printUser(testUser);

        assertEquals(UserDAO.getUser(testUser).getUsername() != "testCase102", true);
        UserDAO.deleteUser(testUser);
    }

    @After
    public void testDeleteUser() throws Exception{
        System.out.println("Testing deleteUser method...");

        UserDAO.deleteUser(testUser);

        assertEquals(UserDAO.getUser(testUser).getEmail() != "failUser.12.12.12@gmail.com", true );
    }

}

