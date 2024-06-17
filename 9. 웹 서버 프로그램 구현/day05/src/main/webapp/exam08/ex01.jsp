<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="str" value="Apple,Banana,Melon,Orange" />
<%--EL 식 안에서 함수 형태로 사용 가능--%>
<c:set var="fruits" value="${fn:split(str, ',')}"/>
str : ${str}<br>
fruits : ${fruits}<br>

<c:forEach var="fruit" items="${fruits}">
    ${fruit}<br>
</c:forEach>

str2 : ${fn:join(fruits, '#')}<br>
<%--str2 : Apple#Banana#Melon#Orange--%>