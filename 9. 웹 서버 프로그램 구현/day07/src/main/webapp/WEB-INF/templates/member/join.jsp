<%--회원가입 양식--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/member/join" />
<layout:main title="회원가입">
    <h1>회원가입</h1>
    <%-- form 태그로 감싸줘야 데이터 전송이 가능 --%>
    <form method="post" action="${actionUrl}" autoComplete="off" target="ifrmProcess">
        <dl>
            <dt>이메일</dt>
            <dd>
                <input type="text" name="email">
            </dd>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="password">
            </dd>
        </dl>
        <dl>
            <dt>비밀번호 확인</dt>
            <dd>
                <input type="password" name="confirmPassword">
            </dd>
        </dl>
        <dl>
            <dt>회원명</dt>
            <dd>
                <input type="text" name="userName">
            </dd>
        </dl>
        <div>
            <input type="checkbox" name="termsAgree" value="true" id="termsAgree">
            <label for="termsAgree">회원가입 약관에 동의합니다.</label>
        </div>
        <button type="submit">회원가입하기</button>
    </form>

</layout:main>