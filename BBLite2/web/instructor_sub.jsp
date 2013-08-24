<%-- 
    Document   : instructor_sub
    Created on : Dec 16, 2012, 12:21:01 PM
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String course = request.getParameter("courseName");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%out.print(course);%> Menu</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <%if(course!=null&&!course.equals("")){%>
        <h3><%out.print(course);%> Menu</h3>
        <form action="create_assignment.jsp" method="get">
            <input type = 'submit' value = 'Create Assignment' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' /> 
        </form>
        <form action="read_assignment.jsp" method="get">
            <input type = 'submit' value = 'Read Assignments' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' />             
        </form>
        <form action="update_grades.jsp" method="get">
            <input type = 'submit' value = 'Update Grades' />
            <input type = 'hidden' value = '<%out.print(course);%>' name='courseName' />              
        </form>
        <%} else{out.println("Invalid course");}%>
    </body>
</html>
