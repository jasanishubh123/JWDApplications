<%-- 
    Document   : demoxml
    Created on : 3 Feb, 2020, 11:45:32 AM
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
        <c:import url="newXMLDocument.xml" var="personInfo" />
           
        <x:parse xml="${personInfo}" var="output"/>
        <x:out select="$output/persons/person[1]/name"/>
        
        <hr>
        <x:forEach var="n" select="$output/persons/person">
            <x:out select="$n/name"/>
            <br>
        </x:forEach>
    </body>
</html>
