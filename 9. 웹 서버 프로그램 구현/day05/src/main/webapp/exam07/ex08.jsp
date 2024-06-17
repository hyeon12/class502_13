<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons" />
<%--하단 내용에 전부 반영됨--%>
    <form>
        <fmt:message key="EMAIL"/>
        <input type="text" name="email"><br>

        <fmt:message key="PASSWORD" />
        <input type="password" name="password"><br>

        <button type="submit">
        <fmt:message key="LOGIN"/>
        </button>
    </form>

<h1>
    <fmt:message key="LOGIN_MSG">
        <fmt:param>이이름</fmt:param> <%--0번째 치환--%>
        <fmt:param>test@test.org</fmt:param> <%--1번째 치환--%>
    </fmt:message>
</h1>

