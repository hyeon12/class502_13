<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="items" class="java.util.ArrayList" scope="request"/>
${items}
<%
    //scope='page'일 때 조회
    /*
    ArrayList data = (ArrayList)pageContext.getAttribute("items");
    data.add("A");
    data.add("B");
    System.out.println(data);
    */

    ArrayList data = (ArrayList)request.getAttribute("items");
    data.add("A");
    System.out.println(data);

%>