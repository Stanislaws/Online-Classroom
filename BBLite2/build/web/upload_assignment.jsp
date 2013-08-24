<%-- 
    Document   : upload_assignment
    Created on : Dec 16, 2012, 9:46:49 PM
    Author     : Jan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String c = request.getParameter("courseName");%>
<%String u = request.getParameter("username");%>
<html>
<head>
    <title>File Uploading Form</title>
    <link rel='stylesheet' type='text/css' href='/BBLite/resources/css/login.css'>
</head>
<body>
    <h3>File Upload:</h3>
    Select a file to upload: <br />
    <form action="UploadServlet" method="post"
                            enctype="multipart/form-data">
        <input type="file" name="file" size="50" />
        <br />
        <input type="hidden" value="<%out.print(c);%>" name="courseName"/>
        <input type="hidden" value="<%out.print(u);%>" name="username"/>
        <input type="submit" value="Upload File" />
    </form>
</body>
</html>
