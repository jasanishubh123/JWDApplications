<%-- 
    Document   : Display
    Created on : 27 Jan, 2020, 5:30:54 PM
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
        <!--<h1>Hello World!</h1>-->
        <jsp:useBean id="empObj" class="beans.employeeBean">
            <jsp:setProperty name="empObj" property="*"></jsp:setProperty>
            <%--<jsp:setProperty name="empObj" property="empID"></jsp:setProperty>--%>
            <%--<jsp:setProperty name="empObj" property="username"></jsp:setProperty>--%>
            <%--<jsp:setProperty name="empObj" property="password"></jsp:setProperty>--%>
            <%
                empObj.validate();
            %>

            Records:
            <jsp:getProperty name="empObj" property="empID"></jsp:getProperty>
            <jsp:getProperty name="empObj" property="username"></jsp:getProperty>

            <jsp:getProperty name="empObj" property="password"></jsp:getProperty>
        </jsp:useBean>
    </body>
</html>
