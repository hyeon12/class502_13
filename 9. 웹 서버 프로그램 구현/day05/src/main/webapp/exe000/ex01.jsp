<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie cookie = new Cookie("key123", "value123");
    //cookie.setMaxAge(3); - 쿠키 생성 addCookie 보다 이전에 와야 반영됨
    cookie.setPath(request.getContextPath());
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
%>