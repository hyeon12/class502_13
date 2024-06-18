<%@ page contentType="text/html; charset=UTF-8" %>

<%
    int num1 = 100;
    int num2 = 200;
    out.write(num5 + "<br>");
    int result = num1+num2;
    out.write("result=" + result);
    out.write("<br>이름 : " + name);
    print();
%>

<%-- JSP 주석 ... 번역과정에서 배제되어 java 파일에 X --%>
<%--
<br>
<%=num1%> + <%=num2%> = <%=result%>
--%>

<%!
    //클래스명 바로 아래 - 인스턴스 자원 (멤버 변수, 멤버 함수)
    String name = "이이름";
    int num5 = 18;
    void print(){
    System.out.println(name);
    }
%>

