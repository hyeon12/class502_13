<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="loginUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<c:url var="logoutUrl" value="/member/logout" />

<%--sessionScope.member쪽에 값이 없으면 미로그인 상태--%>
<util:GuestOnly>
    <a href="${loginUrl}">로그인</a>
    <a href="${joinUrl}">회원가입</a>
</util:GuestOnly>

<%--로그인 상태--%>
<util:MemberOnly>
    ${sessionScope.member.userName}(${sessionScope.member.email})님 로그인...
    <a href="${logoutUrl}">로그아웃</a>
</util:MemberOnly>
