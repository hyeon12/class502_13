<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
    <h3>이 파일은 first.jsp입니다.</h3>
    <jsp:include page="second.jsp">
       <jsp:param name="date" value="<%=java.util.Calendar.getInstance().getTime()%>" />
    </jsp:include>
</body>
</html>