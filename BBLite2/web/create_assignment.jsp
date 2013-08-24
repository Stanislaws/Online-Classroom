<%-- 
    Document   : create_assignment
    Created on : Dec 16, 2012, 2:05:29 PM
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String course = request.getParameter("courseName");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Create an Assignment for <%out.print(course);%></title>
            <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <h3>Create an Assignment for <%out.print(course);%></h3>
        <form action="commit_assignment.jsp" method="post">
            <p><label>Assignment Name*</label>
            <input type = 'text' name = 'assignName' size= '20' /></p>
            <p><label>Assignment Task*</label>
            <input type = 'text' name = 'assignTask' size= '20' /></p>
            <input type="hidden" name="courseName" value="<%out.print(course);%>"/>
            <p><input type = 'submit' value = 'Submit' />
            <input type="reset" value="Reset"/></p>
        </form>
    </body>
</html>
