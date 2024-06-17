<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:catch var="e">
<%
    String str = null; //NullPointerException 의도적으로 발생
    str.toUpperCase();
 %>
 </c:catch>

 <c:if test="${e != null}">
 <%-- e가 null 아니면 예외발생한 상황 --%>
    <%-- 에러 메세지 : ${e.getMessage()} --%>
    에러 메세지 : ${e.message}
 </c:if>
