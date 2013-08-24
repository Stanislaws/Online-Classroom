/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jan
 */
@WebServlet(name = "Commit_Course_Roster", urlPatterns = {"/Commit_Course_Roster"})
public class Commit_Course_Roster extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String c = request.getParameter("courseName");
            
            String s = request.getParameter("studentName");
            
            /* TODO output your page here. You may use following sample code. */

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Commit_Course_Roster</title>");
            out.println("<link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>");
            out.println("</head>");
            out.println("<body>");
            
            if(c!=null&&!c.equals("")){
                if(s!=null&&!s.equals("")){
                    if(isCourse(c)){
                        if(isStudent(s)){
                            String rl = RosterLoad(c,s);
                            out.println(rl);
                            out.println("<br/><a href='Roster_Course'>Add another student to "+c+"</a>");
                            out.println("<br/><a href='admin'>Return to admin menu</a>");

                        }
                        else{
                            out.println(s+" is not a valid student username.");
                            out.println(" <a href='Roster_Course'>Return</a>");
                        }
                    }
                    else{
                        out.println(c+" is not a valid course name.");
                        out.println(" <a href='Roster_Course'>Return</a>");
                    }
                }
                else{
                    out.println("The student username is required.");
                    out.println(" <a href='Roster_Course'>Return</a>");
                }
            }
            else{
                out.println("The course name is required.");
                out.println(" <a href='Roster_Course'>Return</a>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch(SQLException e){
            out.println(e);
        } catch(ClassNotFoundException e){
            out.println(e);
        }
        finally {            
            out.close();
        }
    }
    private boolean isCourse(String c) throws SQLException, 
            ClassNotFoundException{
        ResultSet r = db.DB.connects("select n from g1courses where n='"+c+"'");
        return r.next();
    }
    private boolean isStudent(String s) throws SQLException, 
            ClassNotFoundException{
        ResultSet r = db.DB.connects("select u from g1users where t='s' and u='"+s+"'");
        return r.next();
    }
    private boolean validCount(String c) throws SQLException,
            ClassNotFoundException{
        ResultSet r = db.DB.connects("select n from g1students where n='"+c+"'");
        int count = 0;
        while(r.next()){
            count += Integer.valueOf(r.getString(1));
        }
        if(count<=50){
            return true;
        }
        else{
            return false;
        }
    }
    private String RosterLoad(String c, String s) throws SQLException, 
            ClassNotFoundException{

        if(validCount(c)){
            db.DB.connects("insert into g1students (n,u) values ('"+c+"','"+s+"')");
            return s+" was successfully added to "+c;
            
        }
        else{
            return c+" is full. Student was not added.";
        }

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
