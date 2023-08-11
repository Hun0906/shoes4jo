<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.multi.shoes4jo.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<script src="/assets/js/addHypen.js"></script>
<script type="text/javascript">
	function updateMemberInfo() {
		var formData = new FormData(document.getElementById("updateForm"));

		$.ajax({
			method : "POST",
			url : "/controller/my_edit",
			data : formData,
			processData : false,
			contentType : false,
			success : function(response) {
				alert("회원 정보가 업데이트되었습니다.");
				location.reload(); // 현재 페이지 새로고침
			},
			error : function(xhr, status, error) {
				console.log("회원 정보 업데이트 실패:", status, error);
				alert("회원 정보 업데이트에 실패하였습니다.");
			}
		});
	}
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="form-wrapper">
		<h1>마이페이지</h1>
		<h2>회원 정보</h2>

		<form id="updateForm" enctype="multipart/form-data">

			<%
			MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
			if (memberInfo == null) {
				out.println("로그인이 필요합니다.");
			} else {
			%>
			<div class="input-wrapper">
				<label>이름</label> <input type="text" class="form-control"
					name="member_name" value="<%=memberInfo.getmember_name()%>" required>
			</div>
			<div class="input-wrapper">
				<label>비밀번호</label> <input type="password" class="form-control"
					name="member_pw" value="<%=memberInfo.getmember_pw()%>" required>
			</div>
			<div class="input-wrapper">
				<label>이메일</label> <input type="email" class="form-control"
					name="member_email" value="<%=memberInfo.getmember_email()%>" required>
			</div>
			<div class="input-wrapper">
				<label>휴대폰 번호</label> <input type="tel" class="form-control"
					name="member_phone" value="<%=memberInfo.getmember_phone()%>" oninput="addHypen(this)" required>
			</div>
			<div class="form-button-wrapper">
					<button type="button" class="btn-basic btn-line-basic" onclick="history.go(0)">취소</button>
					<button class="btn-basic" onclick="updateMemberInfo()">저장</button>
			</div>
			<%
			}
			%>
		</form>
	</div>

	<%@include file="../common/footer.jsp"%>