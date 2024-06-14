<%@ page contentType="text/html; charset=UTF-8" %>
<form method="post" action="ex04_ps.jsp">
    <%--property와 name의 값이 동일해야 인식 가능--%>
    작성자: <input type="text" name="poster"><br>
    제목: <input type="text" name="subject"><br>
    내용: <textarea name="content"></textarea><br>
    <button type="submit">작성하기</button>
</form>