/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible for all database calls.
 * @author Jan
 */
public class DB {
    public DB(){}
    /**
     * The db method used across the application
     * @param query the SQL query string
     * @return a resultset of the data
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static ResultSet connects(String query) throws SQLException, 
            ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "hello1");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(query);
        return r;
    }
    
}
