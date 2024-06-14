<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>
<jsp:useBean id="item" class="board.entities.BoardData" />
<jsp:setProperty name="item" property="subject" value="입력한 제목" />
<jsp:setProperty name="item" property="content" value="입력한 내용" />
<jsp:setProperty name="item" property="poster" value="작성자 이름" />

<%--데이터 클래스 사용 시, 속성명만 입력해도 getter 메서드가 찾아줌--%>
제목: ${item.subject}<br>
내용: ${item.content}<br>
작성자: ${item.poster}<br>

<%--
제목: ${item.getSubject()}<br>
내용: ${item.getContent()}<br>
--%>
<%--
제목: <jsp:getProperty name="item" property="subject" /><br>
내용: <jsp:getProperty name="item" property="content" /><br>
작성자: <jsp:getProperty name="item" property="poster" /><br>
--%>