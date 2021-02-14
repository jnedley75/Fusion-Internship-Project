package Fusion.Internship.DatabaseTest;
import java.sql.Connection;

import Fusion.Internship.Database.DatabaseManager;
import org.junit.Test;
import static org.junit.Assert.*;


public class DatabaseManagerTest {


    @Test
    public void testopenConnection() throws Exception{
        System.out.println("Testing openConnection...");
        Connection result = DatabaseManager.openConnection();
        assertEquals(result != null, true);
    }

}
