<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="color" %>
<div style="border: 5px double ${color}; padding: 30px;">
    <jsp:doBody />
    <%--여는태그 닫는태그일때는 내용물 출력 태그 필수--%>
</div>
