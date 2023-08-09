<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.multi.shoes4jo.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<script type="text/javascript">
	function enableEditing() {
		var inputs = document.querySelectorAll('.form-control');
		for (var i = 0; i < inputs.length; i++) {
			inputs[i].removeAttribute('readonly');
		}
		document.getElementById('btnEdit').style.display = 'none';
		document.getElementById('btnSaveCancel').style.display = 'block';
	} 
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="form-wrapper">
		<h1>마이페이지</h1>
		<h2>회원 정보</h2>
		<form action="/controlloer/my_edit" method="post">
			<%
			MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
			if (memberInfo == null) {
				out.println("로그인이 필요합니다.");
			} else {
			%>
			<div class="input-wrapper">
				<label>이름</label> <input type="text" class="form-control"
					name="member_name" value="<%=memberInfo.getmember_name()%>"
					readonly>
			</div>
			<div class="input-wrapper">
				<label>아이디</label> <input type="text" class="form-control"
					name="member_id" value="<%=memberInfo.getmember_id()%>" readonly>
			</div>
			<div class="input-wrapper">
				<label>가입일</label> <input type="text" class="form-control"
					value="<%=memberInfo.getsignup_date()%>" readonly>
			</div>
			<div class="input-wrapper">
				<label>이메일</label> <input type="text" class="form-control"
					name="member_email" value="<%=memberInfo.getmember_email()%>"
					readonly>
			</div>
			<div class="input-wrapper">
				<label>휴대폰 번호</label> <input type="text" class="form-control"
					name="member_phone" value="<%=memberInfo.getmember_phone()%>"
					readonly>
			</div>
			<div id="btnEdit" class="form-button-wrapper">
				<span class="btn-basic" onclick="enableEditing()">수정하기</span>
			</div>
			<div id="btnSaveCancel" class="form-button-wrapper"
				style="display: none;">
				<input type="submit" value="저장"></input>
				<button type="button" onclick="location.href='/'">취소</button>
			</div>
			<%
			}
			%>
		</form>
	</div>

	<%@include file="../common/footer.jsp"%>