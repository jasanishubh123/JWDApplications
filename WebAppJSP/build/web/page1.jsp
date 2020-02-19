<%-- 
    Document   : page1
    Created on : 27 Jan, 2020, 5:18:24 PM
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
        <h1>Page 1</h1>
          <%--<jsp:forward page="page2.jsp">--%>
              <%--<jsp:param name="username" value="abc" />--%>
          <%--</jsp:forward>--%>
          <h2>beigin</h2>
          <jsp:include page="page2.jsp">
             <jsp:param name="username" value="abc" />
          </jsp:include>
          <h1>end of pagge section</h1>
          
    </body>
</html>
