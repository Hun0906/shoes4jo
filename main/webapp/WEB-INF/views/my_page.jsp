<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
    <title>마이 페이지</title>
    <%@include file="header-head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
    <h2>마이페이지</h2>
    <p>회원 정보</p>
    <p>이름: <%= session.getAttribute("memberName") %></p>
    <p>아이디: <%= session.getAttribute("memberId") %></p>
    <p>가입날짜: <%= session.getAttribute("signupDate") %></p>
    <%-- 더 표시할 것 추가하면 ㅇㅇ --%>
    
    <button onclick="location.href='my_edit'">수정하기</button>
    <button onclick="location.href='member_delete'">탈퇴하기</button>
<%@include file="footer.jsp"%>
</body>
</html>