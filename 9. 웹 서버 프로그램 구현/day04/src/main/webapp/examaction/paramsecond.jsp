<%@ page contentType="text/html; charset=utf-8" %>
<%--Today is : <%=request.getParameter("date");%>--%>
<%
    String str = request.getContentType();
    System.out.println(request);
    String str1 = response.getContentType();
    System.out.println(str1);
%>