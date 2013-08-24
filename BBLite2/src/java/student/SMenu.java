/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Methods for the student menu
 * @author Jan
 */
public class SMenu {
    public SMenu(){}
    /**
     * Returns a String[] of all the courses a student is enrolled in
     * @param u the student's username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String[] sCourses(String u) throws SQLException, 
            ClassNotFoundException{
        ArrayList<String> is = new ArrayList<String>();
        ResultSet rs = db.DB.connects("select n from g1students where u='"+u+"'");
        while(rs.next()){
            is.add(rs.getString(1));
        }
        
        String[] ic = new String[is.size()];
        ic = is.toArray(ic);
        return ic;
    }
    /**
     * Returns a String[] of all the grades a student has
     * @param u the student's username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String[] getGrades(String u) throws SQLException,
            ClassNotFoundException{
        ArrayList<String> gg = new ArrayList<String>();
        ResultSet rs = db.DB.connects("select c,g from g1grades where u='"+u+"'");
        while(rs.next()){
            gg.add(rs.getString(1)+"- "+rs.getString(2));
        }
        
        String[] gs = new String[gg.size()];
        gs = gg.toArray(gs);
        return gs;
    }
}
