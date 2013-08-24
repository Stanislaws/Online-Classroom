/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jan
 */
@WebServlet(name = "rcadd", urlPatterns = {"/rcadd"})
public class Commit_Course extends HttpServlet {

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
            String c = request.getParameter("c");
            String ia = request.getParameter("ia");
            String ib = request.getParameter("ib");
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Course Loader Servlet</title>");
            out.println("<link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>");
            out.println("</head>");
            out.println("<body>");
            if(c!=null&&!c.equals("")){
                if(ia!=null&&!ia.equals("")){
                    if(isUser(ia)){
                        if(ib!=null&&!ib.equals("")){
                            if(isUser(ib)){
                                CourseLoad(c,ia,ib);
                                out.println("Sucessfully added a course with these parameters<br/>"
                                           +"Course Name: " + c + "<br/>"
                                           +"Instructor A: " + ia + "<br/>"
                                           +"Instructor B: " + ib + "<br/>");
                                out.println("<p><a href='admin'>Return to admin menu</a></p>");
                            }
                            else{
                                out.println(ib + " is not a user.");
                                out.println(" <a href='rcourse'>Return</a>");
                            }
                        }
                        else{
                            CourseLoad(c,ia);
                            out.println("Sucessfully added a course with these parameters<br/>"
                                       +"Course Name: " + c + "<br/>"
                                       +"Instructor A: " + ia + "<br/>");
                            out.println("<p><a href='admin'>Return to admin menu</a></p>");
                        } 
                    }
                    else{
                        out.println(ia + " is not a user.");
                        out.println(" <a href='rcourse'>Return</a>");
                    }

                }
                else{
                    out.println("Instructor A is required.");
                    out.println(" <a href='rcourse'>Return</a>");
                }
            }
            else{
                out.println("Course Name is required.");
                out.println(" <a href='rcourse'>Return</a>");
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

    private void CourseLoad(String c, String a) throws SQLException, 
            ClassNotFoundException {
        db.DB.connects("insert into g1courses(n,ia) values('"+c+"','"+a+"')");
    }

    private void CourseLoad(String c, String a, String b) throws SQLException, 
            ClassNotFoundException {
        db.DB.connects("insert into g1courses(n,ia,ib) values ('"
                +c+"','"+a+"','"+b+"')");
    }
    private boolean isUser(String u) throws SQLException, 
            ClassNotFoundException{
        ResultSet r = db.DB.connects("select u from g1users where u='"+u+"'");
        return r.next();
    }    
}
