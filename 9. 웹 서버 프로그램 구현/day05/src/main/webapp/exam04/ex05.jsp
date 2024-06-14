<%@ page contentType="text/html; charset=UTF-8"%>
User-Agent: ${header['User-Agent']}<br>

JSESSIONID : ${cookie.JSESSIONID.getValue()}<br>
JSESSIONID : ${cookie.JSESSIONID.value}<br> <%--메서드 없이 바로 호출 가능--%>
key1 : ${initParam.key1}<br>

URI : ${pageContext.getRequest().getRequestURI()}<br>
URI : ${pageContext.request.requestURI}
<%--get메서드 없이 속성명으로 바로 접근/호출 가능하다!--%>