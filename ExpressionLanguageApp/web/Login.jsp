<%-- 
    Document   : Login
    Created on : 29 Jan, 2020, 9:05:05 PM
    Author     : snehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="Welcome.jsp">
            UserName:<input type="text" name="txtuname" value="${cookie.username.value}"/>
            <br>
            Password:<input type="password" name="txtPass" value="${cookie.password.value}" />
            </br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
