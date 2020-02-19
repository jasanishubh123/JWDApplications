<%-- 
    Document   : newjsp
    Created on : 28 Jan, 2020, 5:33:13 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tx" uri="/WEB-INF/tlds/mytag.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <tx:Taghandler2 >Hello World</tx:Taghandler2>
            
        <tx:Taghandler3 color="red">
            <tx:mydate/>
    </body>
</html>
