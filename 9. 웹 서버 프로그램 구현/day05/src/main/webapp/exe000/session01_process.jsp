<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Session</title>
</head>
<body>
	<%
        //request.getParameter();
	    //웹 애플리케이션에서 클라이언트가 전송한 HTTP 요청(request)에서
	    //파라미터(parameter) 값을 추출하는 메서드
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("passwd");

        //void setAttribute(String name, Object value)
		if (user_id.equals("admin") && user_pw.equals("1234")) {
			session.setAttribute("userID", user_id);
			session.setAttribute("userPW", user_pw);
			out.println("세션 설정이 성공했습니다<br>");
			out.println(user_id+"님 환영합니다");
		} else {
			out.println("세션 설정이 실패했습니다");
		}
	%>
</body>
</html>