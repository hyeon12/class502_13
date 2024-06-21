<%--비회원일때--%>
<%@ tag body-content="scriptless" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="org.choongang.member.MemberUtil" %>
<% if (!MemberUtil.isLogin(request)) { %>
<jsp:doBody />
<% } %>