<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Cookie cookie = new Cookie("key2", "value2");
    cookie.setMaxAge(60 * 60 * 24 * 7); //관례적인 시간 표기(일주일 초 단위)
    response.addCookie(cookie);
%>

