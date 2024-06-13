<%@ page contentType="text/html; charset=UTF-8" %>
<%-- ex01쪽에서 ex02 추가하는 방식 --%>

<% //pageContext - 하나의 jsp 페이지에서만 조회 가능
    //pageContext.setAttribute("key1", "value1");
    request.setAttribute("key1", "value1");
%>
<jsp:include page="ex02.jsp" />

<%  //반환값 Object로, String으로 형변환
    //String key1 = (String)pageContext.getAttribute("key1");
    String key1 = (String)request.getAttribute("key1");
%>

<div>
ex01-key1: <%=key1%>
</div>
