/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Jan
 */
public class IMenu {
    public IMenu(){

    }
    /**
     * Returns a String[] of all the courses for the instructor
     * @param u the instructor's username
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String[] iCourses(String u) throws SQLException, 
            ClassNotFoundException{
        ArrayList<String> ic = new ArrayList<String>();
        ResultSet rs = db.DB.connects("select n from g1courses where ia='"+u+"' or ib='"+u+"'");
        while(rs.next()){
            ic.add(rs.getString(1));
        }
        
        String[] ica = new String[ic.size()];
        ica = ic.toArray(ica);
        return ica;
    }
    /**
     * Inserts new assignments into the db
     * @param c the course name
     * @param n the assignment name
     * @param t the assignment desc
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void LoadAssignment(String c,String n,String t) 
            throws SQLException, ClassNotFoundException{
        db.DB.connects("insert into g1assigns(c,n,t) values('"+c+"','"+n+"','"+t+"')");
    }
    /**
     * Returns a String[] of all the assignments in the db
     * @param c the course
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String[] ReadAssignment(String c) throws SQLException, 
            ClassNotFoundException{
        ArrayList<String> a = new ArrayList<String>();
        ResultSet rs = db.DB.connects("select n,t from g1assigns where c='"+c+"'");
        while(rs.next()){
            a.add(rs.getString(1)+"- "+rs.getString(2));
        }
        
        String[] ia = new String[a.size()];
        ia = a.toArray(ia);
        return ia;
    }
    /**
     * Returns a list of all the students enrolled in a particular course
     * @param c the course
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static String[] ReadStudents(String c) throws SQLException, 
            ClassNotFoundException{
        ArrayList<String> s = new ArrayList<String>();
        ResultSet rs = db.DB.connects("select u from g1students where n='"+c+"'");
        while(rs.next()){
            s.add(rs.getString(1));
        }
        
        String[] ia = new String[s.size()];
        ia = s.toArray(ia);
        return ia;
    }
    /**
     * Inserts grades into the db
     * @param c the course
     * @param u the student's username
     * @param g the grade
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static void LoadGrades(String c,String u,String g) throws 
            SQLException, ClassNotFoundException{
        db.DB.connects("insert into g1grades(c,u,g) values('"+c+"','"+u+"','"+g+"')");
    }
}
