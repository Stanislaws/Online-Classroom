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
@WebServlet(name = "rcommit", urlPatterns = {"/rcommit"})
public class Commit_User extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        try {
            String first = request.getParameter("firstName");
            String last = request.getParameter("lastName");
            String user = first.substring(0, 1).toLowerCase() + last.toLowerCase();
            String email = user + "@bblite.com";
            String type = request.getParameter("type");
            String pass = type + user;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Account Loader</title>");
            out.println("<link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>");
            out.println("</head>");
            out.println("<body>");
            if(first!=null){
                if(!first.equals("")){
                    if(last!=null){
                        if(!last.equals("")){
                            if(!isUser(user)){
                                CommitData(user,pass,type,first,last,email);
                                out.println(user + 
                                        " was successfully registered. ");
                                out.println("<p><a href='admin'>Return to admin menu</a></p>");
                            } else{
                               out.println(user + " is already registered!"); 
                               out.println(" <a href='rstudent'>Return</a>");
                            }     
                        }
                        else {
                            out.println("Last name can't be empty.");
                            out.println(" <a href='rstudent'>Return</a>");
                        }
                    }
                    else{
                        out.println("Last name can't be null.");
                        out.println(" <a href='rstudent'>Return</a>");
                    }
                }
                else {
                    out.println("First name can't be empty.");
                    out.println(" <a href='rstudent'>Return</a>");
                }
            }
            else{
                out.println("First name can't be null.");
                out.println(" <a href='rstudent'>Return</a>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch(SQLException ex){
            out.println(ex);
        } catch(ClassNotFoundException ex){
            out.println(ex);
        }      
        finally {            
            out.close();
        }
    }
    
    private void CommitData
            (String u, String p, String t, String f, String l, String e) throws
            SQLException, ClassNotFoundException, IOException{    
        db.DB.connects("insert into g1users(u,p,t,f,l,e) values('"
                +u+"','"+p+"','"+t+"','"+f+"','"+l+"','"+e+"')"); 
    }
    private boolean isUser(String u) throws SQLException, ClassNotFoundException{
        ResultSet r = db.DB.connects("select u from g1users where u='"+
                u+"'");
        if(r.next()){
            return true;
        }
        else{
            return false;
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
