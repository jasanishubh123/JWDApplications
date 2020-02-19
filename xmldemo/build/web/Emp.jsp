<%-- 
    Document   : Emp
    Created on : 3 Feb, 2020, 11:57:13 AM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="Employee.xml" var="EmployeeInfo"/>
          <x:parse xml="${EmployeeInfo}" var="output"/>
        <x:out select="$output/employees/employee[1]/dept"/>
         <select name="drop">
         <x:forEach var="n" select="$output/employees/employee">
            
                 <option><x:out select="$n/dept"/></option>
         
            <br>
        </x:forEach>
        <c:choose>
            <c:when test="${n.drop=='HR'}">
                <h1>
                    HR
                </h1>
            </c:when>
        </c:choose>
       </select>
         
    </body>
</html>
