<%-- 
    Document   : instructor
    Created on : Dec 14, 2012, 4:49:00 PM
    Author     : Jan
--%>
<%@page import="instructor.IMenu"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor Menu</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <h3>Instructor Menu</h3>
        <%try{%>
        <form action="instructor_sub.jsp" method="post">
            <label>Select the course:</label>
            <select name="courseName">
               
                <%
                String username = request.getParameter("username");
                String[] ica = IMenu.iCourses(username);
                for(int i=0;i<ica.length;i++){
                    out.println("<option value='"+ica[i]+"'>"+ica[i]+"</option>");
                }
                %>
                
            </select>
            <p>
                <input type = 'submit' value = 'Submit' />
            </p>
        </form>
        <%
        }
        catch(Error e){
            out.println(e);
        }%>
    </body>
</html>
