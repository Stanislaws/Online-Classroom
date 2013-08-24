<%-- 
    Document   : commit_grades
    Created on : Dec 16, 2012, 8:43:02 PM
    Author     : Jan
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="instructor.IMenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String c = request.getParameter("courseName");
String u = request.getParameter("studentName");
String g = request.getParameter("studentGrade");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commit Grades</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <%if(!c.equals("")&&!u.equals("")&&!g.equals("")){
            try{IMenu.LoadGrades(c,u,g);}catch(SQLException e){out.println(e);}
            out.println("Successfully updated grade for "+u);
            out.println("<a href='instructor_sub.jsp?courseName="+c+"'> Return to course menu</a>.");
        }else{%>All fields are required. Click the back button to continue.<%}%>
    </body>
</html>
