<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ page import="jakarta.servlet.http.*" %>--%>
<%
    Cookie cookie1 = new Cookie("key1", "value1");
    response.addCookie(cookie1);
%>