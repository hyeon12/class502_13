<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionUrl" value="/member/join" />
${commonValue}
<br>
${command}
<h1>회원가입</h1>
<form:form method="POST" action="${actionUrl}" autocomplete="off" modelAttribute="command">
    <dl>
        <dt>이메일</dt>
        <dd>
            <form:input path="email" />
            <%--<input type="text" name="email" value="${requestJoin.email}">--%>
        </dd>
    </dl>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <form:password path="password" />
        </dd>
    </dl>
    <dl>
        <dt>비밀번호 확인</dt>
        <dd>
            <form:password path="confirmPassword" />
        </dd>
    </dl>
    <dl>
        <dt>회원명</dt>
        <dd>
            <form:input path="userName" />
        </dd>
    </dl>
    <dl>
        <dt>취미</dt>
        <dd>
            ${requestJoin.hobby[0]}
            <form:checkboxes path="hobby" items="${hobbies}" />
        </dd>
    </dl>
    <dl>
        <dt>주소</dt>
        <dd>
            <form:input path="addr.zipCode" placeholder="우편번호" />
            <form:input path="addr.address" placeholder="주소" />
            <form:input path="addr.addressSub" placeholder="나머지 주소" />
        </dd>
    </dl>
    <dl>
        <dt>약관동의</dt>
        <dd>
            <form:checkbox path="agree" value="true" label="회원가입 약관에 동의합니다." />
            <%--<input type="checkbox" name="agree" value="true" id="agree">--%>
            <%--<label for="agree">회원가입 약관에 동의합니다.</label>--%>
        </dd>
    </dl>
    <button type="submit">가입하기</button>
</form:form>