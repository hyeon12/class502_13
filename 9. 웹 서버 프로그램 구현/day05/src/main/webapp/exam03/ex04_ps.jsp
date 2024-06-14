<%--_ps:process 처리 내용 정의--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>
<jsp:useBean id="item" class="board.entities.BoardData" scope="request"/>
<jsp:setProperty name="item" property="*" />

<%--ex04에서 입력받은 데이터가 각각 들어갈 수 있도록--%>
<%--
<jsp:setProperty name="item" property="subject" />
<jsp:setProperty name="item" property="content" />
<jsp:setProperty name="item" property="poster" param="writer" />
--%>
제목: ${item.subject}<br>
내용: ${item.content}<br>
작성자: ${item.poster}<br>