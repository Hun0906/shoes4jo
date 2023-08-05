<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<title>마이페이지 | SHOES4JO</title>
<%@include file="header-head.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="form-wrapper">
	<h1>마이페이지</h1>
	<h2>회원 정보</h2>
		<div class="input-wrapper">
		<label>이름</label><input type="text" class="form-control" value="" readonly>
		</div>
		<div class="input-wrapper">
		<label>아이디</label><input type="text" class="form-control" value="<%=session.getAttribute("member_id")%>" readonly>
		</div>
		<div class="input-wrapper">
		<label>가입일</label><input type="text" class="form-control" value="" readonly>
		</div>
					<div class="form-button-wrapper">
	<button onclick="location.href='my_edit'" class="btn-basic">수정하기</button>
</div>		
			<div class="form-button-wrapper">
	<span class="btn-basic btn-line-red" onclick="location.href='member_delete'">탈퇴하기</span>
		</div>
	</div>
	
	<%@include file="footer.jsp"%>
	</body>
	</html>