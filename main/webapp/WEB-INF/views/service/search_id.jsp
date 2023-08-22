<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>아이디 찾기 | SHOES4JO</title>
<script src="/assets/js/addHypen.js"></script>
<%@include file="../common/header-head.jsp"%>
</head>

<body>
	<%@include file="../common/header.jsp"%>

	<form Name="searchVO" id="searchForm"
		action="<%=context %>/controller/result_id" method="post">
		<div class="form-wrapper">
		<h1>계정 찾기</h1>

		<h2>아이디 찾기</h2>
		<div class="search-wrapper">
			<div class="input-wrapper">
				<label>이름</label><input type="text"
					class="form-control" id="member_name"
					name="member_name" placeholder="가입 시 입력한 이름을 입력하세요.">
			</div>

			<div class="input-wrapper">
				<label>휴대폰 번호</label><input type="tel"
					class="form-control" id="member_phone"
					name="member_phone" oninput="addHypen(this)"
					placeholder="가입 시 입력한 휴대폰 번호를 입력하세요.">
			</div>
		</div>
		</div>

		<div class="form-button-wrapper" style="text-align: center;">
			<button onclick="fnSubmit(); return false;" class="btn-basic">아이디 찾기</button>
		</div>

	</form>

	<script>
		$(document).ready(function() {
			var msg = "${msg}";
			if (msg != "") {
				alert(msg);
			}
		});

		function fnSubmit() {
			var tel_rule = /^\d{2,3}-\d{3,4}-\d{4}$/;

			if ($("#member_name").val() == null
					|| $("#member_name").val() == "") {
				alert("이름을 입력하세요.");
				$("#member_name").focus();
				return false;
			}

			if ($("#member_phone").val() == null
					|| $("#member_phone").val() == "") {
				alert("전화번호를 입력하세요.");
				$("#member_phone").focus();
				return false;
			}

			if (!tel_rule.test($("#member_phone").val())) {
				alert("형식에 맞게 입력하세요.");
				return false;
			}

			if (confirm("입력한 정보로 아이디를 찾으시겠습니까?")) {
				$("#searchForm").submit();
				return false;
			}
		}
	</script>
	
		<%@include file="../common/footer.jsp"%>
</body>
</html>
