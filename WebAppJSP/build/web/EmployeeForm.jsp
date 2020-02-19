<%-- 
    Document   : EmployeeForm
    Created on : 27 Jan, 2020, 5:30:41 PM
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
        <form action="Display.jsp" method="post">
            ID<input type ="text" name="empID"/>
            <br>
            Name<input type="text" name="username"/>
            <br>
            Password
            <input type="password" name="password"/>
            <br>
            <input  type="submit" name="submit" value="submit"/>
        </form>
    </body>
</html>
