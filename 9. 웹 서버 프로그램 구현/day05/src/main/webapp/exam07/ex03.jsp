<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="num" value="123000000.12" />

<%--
# : 비어있는 자리 공백
0 : 비어있는 자리 0으로 채움
--%>

#,###.##### : <fmt:formatNumber value="${num}" pattern="#,###.#####" /><br>
0,000.00000 : <fmt:formatNumber value="${num}" pattern="0,000.00000" /><br>
