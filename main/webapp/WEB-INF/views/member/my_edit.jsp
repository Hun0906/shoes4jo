<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<script src="<%=context %>/assets/js/addHypen.js"></script>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="form-wrapper">
		<h1>마이페이지</h1>
		<h2>회원 정보</h2>
		<form id="updateForm" action="<%=context %>/controller/my_edit" method="get">

			<div class="input-wrapper">
				<label>아이디</label> <input type="text" class="form-control"
					value="<%=request.getParameter("member_id")%>" readonly>
			</div>
			<div class="input-wrapper">
				<label>현재 비밀번호</label> <input type="password" class="form-control"
					name="member_pw" value="" required>
			</div>
			<hr>
			<div class="input-wrapper">
				<label>이름</label> <input type="text" class="form-control"
					name="member_name" value="<%=request.getParameter("member_name")%>" required>
			</div>
			<div class="input-wrapper">
				<label>이메일</label> <input type="email" class="form-control"
					name="member_email" value="<%=request.getParameter("member_email")%>" pattern="^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$" required>
			</div>
			<div class="input-wrapper">
				<label>휴대폰 번호</label> <input type="tel" class="form-control"
					name="member_phone" value="<%=request.getParameter("member_phone")%>" oninput="addHypen(this)" pattern="^01[016789]{1}-?[1-9]{1}[0-9]{2,3}-?[0-9]{4}$" title="01x-xxxx-xxxx" maxlength="13" required>
			</div>
			<div class="form-button-wrapper">
				<span class="btn-basic btn-line-basic" onclick="location.href='<%=context%>/controller/memberInfo'">취소</span>
				<button class="btn-basic">저장</button>
			</div>
		</form>

	</div>

	<%@include file="../common/footer.jsp"%>