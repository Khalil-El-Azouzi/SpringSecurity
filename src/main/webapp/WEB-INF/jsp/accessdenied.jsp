<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 31/12/2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<!DOCTYPE html>
<center>
    <h1>Welcome to Spring Boot Access Denied Error Page</h1>

    <h2>You are in Spring Boot Access Denied Error page</h2>
    <br><a href="/">home</a>
    <br><br>
<%
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            out.println("User '" + auth.getName() + "' attempted to access the protected URL: ");
            out.println("<br>auth : "+auth.isAuthenticated());
            out.println("<br>Role : "+auth.getAuthorities());
            out.println("<br>Error Page : "+request.getRequestURL());
        }
%>
</center>
