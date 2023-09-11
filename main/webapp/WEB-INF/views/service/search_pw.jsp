<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<head>
<title>비밀번호 찾기 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<script src="/assets/js/addHypen.js"></script>
<script>
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
	});

	function fnSubmit() {

		var email_rule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var tel_rule = /^\d{2,3}-\d{3,4}-\d{4}$/;

		if ($("#member_id").val() == null || $("#member_id").val() == "") {
			alert("아이디를 입력해주세요.");
			$("#member_id").focus();

			return false;
		}

		if ($("#member_name").val() == null || $("#member_name").val() == "") {
			alert("이름을 입력해주세요.");
			$("#member_name").focus();

			return false;
		}

		if ($("#member_phone").val() == null || $("#member_phone").val() == "") {
			alert("휴대폰 번호를 입력해주세요.");
			$("#member_phone").focus();

			return false;
		}

		if (!tel_rule.test($("#member_phone").val())) {
			alert("형식에 맞게 입력해주세요.");
			return false;
		}

		if (confirm("임시 비밀번호를 발급받으시겠습니까?")) {

			$("#createForm").submit();

			return false;
		}
	}
</script>
</head>

<body>

	<%@include file="../common/header.jsp"%>
	<form commandName="searchVO" id="createForm"
		action="<%=context%>/controller/result_pw" method="post">
		<input type="hidden" id="member_id_yn" name="member_id_yn" value="N">
		<div class="form-wrapper">
		<h1>계정 찾기</h1>

		<h2>임시 비밀번호 발급</h2>
		<div class="search-wrapper">
		<div class="input-wrapper">
			<label>아이디</label><input type="text" class="form-control form-control-user"
				id="member_id" name="member_id" placeholder="아이디를 입력하세요.">
		</div>
		<div class="input-wrapper">
			<label>이름</label><input type="text" class="form-control form-control-user"
				id="member_name" name="member_name" placeholder="가입 시 입력한 이름을 입력하세요.">
		</div>
		<div class="input-wrapper">
			<label>휴대폰 번호</label><input type="tel" class="form-control form-control-user"
				id="member_phone" name="member_phone" oninput="addHypen(this)"
				placeholder="가입 시 입력한 휴대폰 번호를 입력하세요.">
		</div>
		</div>
		
		<div class="form-button-wrapper">
			<span onclick="fnSubmit(); return false;" class="btn-basic">임시 비밀번호 발급</span>
		</div>

		</div>
	</form>
	<%@include file="../common/footer.jsp"%>

</body>
</html>