<%-- 
    Document   : read_assignment
    Created on : Dec 16, 2012, 2:05:46 PM
    Author     : Jan
--%>
<%@page import="instructor.IMenu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String c = request.getParameter("courseName");%>
<%String[] a = IMenu.ReadAssignment(c);%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Assignments</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <ol>
        <%for(int i=0;i<a.length;i++){
            out.println("<li>"+a[i]+"</li>");
        }%>
        </ol>
    </body>
</html>
