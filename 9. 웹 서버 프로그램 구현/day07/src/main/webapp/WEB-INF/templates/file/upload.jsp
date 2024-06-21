<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="actionUrl" value="/file/upload" />
<form method="post" action="${actionUrl}" enctype="multipart/form-data">
    제목 : <input type="text" name="subject"><br>
    내용 : <input type="text" name="content"><br>
     <%--클릭하면 파일탐색기 통해 입력됨--%>
    파일(1개 선택) : <input type="file" name="file"><br>
    파일(여러개 선택) : <input type="file" name="file" multiple><br>
    <button type="submit">작성하기</button>
</form>
