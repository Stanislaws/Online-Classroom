/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jan
 */
@WebServlet(name = "rcourse", urlPatterns = {"/rcourse"})
public class Register_Course extends HttpServlet {
    
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Course Registration Servlet</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println(
                    "<h3>Course Registration Form</h3>"
                   +"<form action = 'rcadd' method='post'>" 
                   +"<p><label>Course Name*</label>" 
                   +"<input type = 'text' name = 'c' size= '20' /></p>");
            out.println("<p><label>Instructor A Username*</label>");
            out.println("<input type = 'text' name = 'ia' size= '20' /></p>");
            out.println("<p><label>Instructor B Username</label>");
            out.println("<input type = 'text' name = 'ib' size= '20' /></p>");           
            out.println("<p><input type = 'submit' value = 'Submit' />");
            out.println("<input type = 'reset' value = 'Reset' /></p>");
            out.println("</form>");
            out.println("</body>");
            out.println("</body>");
            out.println("</html>");
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
}
