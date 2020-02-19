<%-- 
    Document   : sqljsp
    Created on : 3 Feb, 2020, 12:13:56 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %><!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:setDataSource driver="com.mysql.jdbc.Driver" user="shubham1" password="shubham" url="jdbc:mysql://localhost/EmpDB" var="db" />
       
        <c:set var="ename" value="${param.ename}"/>
        <c:set var="pass" value="${param.pass}"/>
        <c:set var="did" value="${param.did}"/>
        <s:update dataSource="${db}">
            insert into EmpTB(EmployeeName,Password,DepartmentID)values(?,?,?)
            <s:param value="${ename}"></s:param>
            <s:param value="${pass}"></s:param>
            <s:param value="${did}"></s:param>
        </s:update>
        <s:query dataSource="${db}" var="res">
            select * from EmpTB
        </s:query>
            Records<br>
            <c:forEach var="row" items="${res.rows}" >
                <c:out value="${row.EmployeeName}"/>
        </c:forEach>
            
            
    </body>
</html>
