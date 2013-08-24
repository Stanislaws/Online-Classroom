<%-- 
    Document   : commit_assignment
    Created on : Dec 16, 2012, 7:51:17 PM
    Author     : Jan
--%>
<%@page import="instructor.IMenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String c = request.getParameter("courseName");
String n = request.getParameter("assignName");
String t = request.getParameter("assignTask");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commit Assignment</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <%if(!c.equals("")&&!n.equals("")&&!t.equals("")){
            IMenu.LoadAssignment(c,n,t);
            out.println("Successfully added "+n+" to "+c+".");
            out.println("<a href='instructor_sub.jsp?courseName="+c+"'> Return to course menu</a>.");
        }else{%>All fields are required. Click the back button to continue.<%}%>
        
    </body>
</html>
