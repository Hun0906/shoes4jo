<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/assets/js/addHypen.js"></script>
<script>
	var path = "${pageContext.request.contextPath }";

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
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>search_pw | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
</head>

<form commandName="searchVO" id="createForm"
	action="${path}/controller/result_pw" method="post">
	<input type="hidden" id="member_id_yn" name="member_id_yn" value="N">

	<body class="bg-gradient-primary">
		<%@include file="../common/header.jsp"%>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-10 col-lg-12 col-md-9">
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-6 d-none d-lg-block bg-password"></div>
								<div class="col-lg-6">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-2">비밀번호 찾기</h1>
											<br>
										</div>
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												id="member_id" name="member_id" placeholder="아이디를 입력해주세요."><br>
										</div>
										<div class="form-group">
											<input type="text" class="form-control form-control-user"
												id="member_name" name="member_name"
												placeholder="이름을 입력해주세요."><br>
										</div>
										<div class="form-group">
											<input type="tel" class="form-control form-control-user"
												id="member_phone" name="member_phone"
												oninput="addHypen(this)" placeholder="휴대폰 번호를 입력해주세요."><br>
										</div>
										<br> <a href="javascript:void(0)"
											onclick="fnSubmit(); return false;" class="btn-basic"> 
											임시 비밀번호 발급받기 </a><br>
										<hr>
										<div class="text-center">
											<a class="small" onclick="location.href='insertMember'">회원가입
												하기</a>
										</div>
										<div class="text-center">
											<a class="small" onclick="location.href='login'">로그인 하기</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="../common/footer.jsp"%>
	</body>
</form>
</html>