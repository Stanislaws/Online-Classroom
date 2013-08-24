<%-- 
    Document   : student_sub
    Created on : Dec 16, 2012, 9:36:06 PM
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String course = request.getParameter("courseName");%>
<%String username = request.getParameter("username");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%out.print(course);%> Menu</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <%if(course!=null&&!course.equals("")){%>
        <h3><%out.print(course);%> Menu</h3>
        <form action="read_assignment.jsp" method="get">
            <input type = 'submit' value = 'Read Assignments' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' /> 
            <input type="hidden" value="<%out.print(username);%>" name="username"/>
        </form>
        <form action="upload_assignment.jsp" method="get">
            <input type = 'submit' value = 'Upload Assignments' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' /> 
            <input type="hidden" value="<%out.print(username);%>" name="username"/>
        </form>
        <form action="view_grades.jsp" method="get">
            <input type = 'submit' value = 'View Grades' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' />
            <input type="hidden" value="<%out.print(username);%>" name="username"/>
        </form>
        <%} else{out.println("Invalid course");}%>
    </body>
</html>
