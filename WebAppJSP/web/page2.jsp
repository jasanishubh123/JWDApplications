<%-- 
    Document   : page2
    Created on : 27 Jan, 2020, 5:18:37 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page 2</h1>
        <h2>hello <%= request.getParameter("username")  %></h2>
    </body>
</html>
