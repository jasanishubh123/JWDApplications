<%-- 
    Document   : Welcome
    Created on : 29 Jan, 2020, 8:58:19 PM
    Author     : snehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% 
           String uname=request.getParameter("txtuname");
           String pass=request.getParameter("txtuname");
           if(uname.equals("admin") && pass.equals("admin") )
             {
                 session.setAttribute("username", uname);
                 Cookie ck=new Cookie("username", uname);
                 Cookie ckp=new Cookie("password", pass);
                 response.addCookie(ck);
                 response.addCookie(ckp);
                 response.sendRedirect("Msg.jsp");
             }
           else{
               out.println("wrong username or password");
           }
        %>
    </body>
</html>
