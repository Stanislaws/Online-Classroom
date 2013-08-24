<%-- 
    Document   : student
    Created on : Dec 16, 2012, 9:27:49 PM
    Author     : Jan
--%>
<%@page import="student.SMenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Menu</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <h3>Student Menu</h3>
        <%try{%>
        <form action="student_sub.jsp" method="get">
            <label>Select the course:</label>
            <select name="courseName">
               
                <%
                String username = request.getParameter("username");
                String[] ica = SMenu.sCourses(username);
                for(int i=0;i<ica.length;i++){
                    out.println("<option value='"+ica[i]+"'>"+ica[i]+"</option>");
                }
                %>
                
            </select>
            <p>
                <input type="hidden" value="<%out.print(username);%>" name="username"/>
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
