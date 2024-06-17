<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 동적 attribute : 맵 형태로 추가(키-값) --%>
<%@ tag import="java.util.*" %>
<%@ tag dynamic-attributes="stars" %>
<%
    Map<String, String> stars = (Map<String, String>)jspContext.getAttribute("stars");
    String _size = stars.getOrDefault("size", "0"); //값이 없을때 기본 값 대체 getOrDefault
    int size = Integer.parseInt(_size);
%>

<div style="color: ${stars.color};">
<%
    for (int i = 0; i < size; i++){
        out.write("*");
    }
%>
</div>

<%--
String 만 가능
color : ${stars.color}<br>
size : ${stars.size}<br> -> int 로 바꿔줘야함. (자바코드로 가져오면 된다!! 위의 코드 참고)
--%>
