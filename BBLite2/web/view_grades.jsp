<%-- 
    Document   : view_grades
    Created on : Dec 16, 2012, 9:46:31 PM
    Author     : Jan
--%>
<%@page import="student.SMenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String u = request.getParameter("username");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grades</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <h3><%out.println(u);%>'s Grades</h3>
        <ol>
        <%
        String[] g = SMenu.getGrades(u);
        for(int i=0;i<g.length;i++){
            out.println("<li>"+g[i]+"</li>");
        }%>
        </ol>
    </body>
</html>
