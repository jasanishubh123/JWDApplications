<%-- 
    Document   : newjsp
    Created on : 5 Feb, 2020, 10:54:13 AM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="p" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:set var="clang" value="${param.dlang}"/>

<c:if test="${not empty clang}">
    
    <p:setLocale value="${clang}"/>
    
</c:if>
<p:setBundle basename="resource/MyProperties"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><p:message key="title" /></title>
    </head>
    <body>
        <h1><p:message key="message"/></h1>
        <form  method="post">
            <p:message key="language"/>
            <select name="dlang" >
                <option value="en_US">
                    English
                </option>
                <option value="fr_CH">French</option>
                <option value="hi_IN">Hindi</option>
                
            </select><br>
            <input type="submit" value="<p:message key="button"/>">
        </form>
    </body>
</html>
