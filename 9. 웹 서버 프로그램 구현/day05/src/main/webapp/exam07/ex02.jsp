<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="num1" value="100000000" />

<%-- 1000000 한눈에 보기 어려운 숫자 -> ,로 구분(기본값) groupingUsed-true --%>
groupingUsed 'true' : <fmt:formatNumber value="${num1}" /><br>
groupingUsed 'false' : <fmt:formatNumber value="${num1}" groupingUsed="false" /><br>
type-percent : <fmt:formatNumber value="0.25" type="percent" /><br>
type-currency : <fmt:formatNumber value="10000" type="currency" /><br>

