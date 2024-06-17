<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="alert" value="<script>alert('알림!')</script>" />
<%-- 스크립트 실행되어 노출됨 - 보안 위험
${alert}
--%>
<c:out value="${alert}" />
<c:out value="${str}" default="값 없음" />
<c:out value="<h1>제목</h1>" escapeXml="false"/>
