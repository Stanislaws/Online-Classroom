<%-- 
    Document   : update_grades
    Created on : Dec 16, 2012, 2:06:03 PM
    Author     : Jan
--%>
<%@page import="instructor.IMenu"%>
<%String c = request.getParameter("courseName");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Grades</title>
        <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
    </head>
    <body>
        <%if(!c.equals("")){%>
        <form action="commit_grades.jsp">
            <label>Student</label>
            <select name="studentName">
                <%
                String[] a = IMenu.ReadStudents(c);
                for(int i=0;i<a.length;i++){
                    out.println("<option value='"+a[i]+"'>"+a[i]+"</option>");
                }
                %>
            </select>
            <select name="studentGrade">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
                <option value="F">F</option>
            </select>
            <p>
                <input type ="hidden" value="<%out.println(c);%>" name="courseName"/>
                <input type = 'submit' value = 'Submit' />
            </p>
        </form>
        <%}else{%>Invalid course.<%}%>
    </body>
</html>
