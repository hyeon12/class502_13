<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Session</title>
</head>
<body>
    <%
        //Object getAttribute(String name)
        String user_id = (String)session.getAttribute("userID");
        //value -> Object 형이므로, (String)으로 형변환
        //모든 클래스의 상위 클래스인 Object => 하위클래스로 형변환 가능
        String user_pw = (String)session.getAttribute("userPW");

        out.println("설정된 세션 값[1]" + user_id + "<br>");
        out.println("설정된 세션 값[2]" + user_pw + "<br>");
    %>
</body>
</html>