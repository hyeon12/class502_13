<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:forTokens var="item" items="Apple#Orange+Melon" delims="#+">
<%--패턴(ex.#,+)이 여러개 있는 경우 delims에 중복사용가능--%>
<div>${item}</div>
</c:forTokens>