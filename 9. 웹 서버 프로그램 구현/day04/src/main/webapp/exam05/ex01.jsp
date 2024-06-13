<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>
<h1>ex01.jsp - 상단</h1>
<%
    RequestDispatcher rd = request.getRequestDispatcher("ex02.jsp");
    //rd.forward(request, response);//버퍼 치환, 기존버퍼 교체
    rd.include(request, response); //버퍼 추가, 기존버퍼 취소X
%>
<h1>ex01.jsp - 하단</h1>