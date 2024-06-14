<%@ page contentType="text/html; charset=UTF-8" %>
<%
    pageContext.setAttribute("num", 10);
%>
${100 + 200}<br>
${num == 10 ? "숫자 10" : "숫자 10 아님"}<br>