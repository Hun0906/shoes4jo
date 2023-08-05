<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
    String memberId = (String) session.getAttribute("memberId");
   // String memberName = (String) session.getAttribute("memberName");

    // 수정 버튼을 누르기 전에 기존 정보를 보여주기 위해 세션에 저장된 회원 정보를 이용하여 기본 값을 설정
    // (회원 정보 수정 후 저장하기 버튼을 누르면 DB에 업데이트되도록 설정)
%>
<!DOCTYPE html>
<html>
<head>
    <title>회원 정보 수정 | SHOES4JO</title>
	<%@include file="header-head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
    <h2>회원 정보 수정</h2>
    
     <form action="member_update.jsp" method="post">
        <label>이름:</label>
        <input type="text" name="memberName" value="<%= session.getAttribute("memberName") %>">
        <br>
        <label>아이디:</label>
        <input type="text" name="memberId" value="<%= session.getAttribute("memberId") %>" readonly>
        <br>
        <label>비밀번호:</label>
        <input type="password" name="memberPw">
        <br>
        <input type="submit" value="저장">
        <button type ="button" onclick="location.href='my_page'">취소</button>
    </form>

<%@include file="footer.jsp"%>
</body>
</html> 