<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.simpleLogin {
	border: 1px solid #ccc;
	background-color: #ccc;
	border-radius: 10rem;
	height: 64px;
	width: 64px;
	display: inline-block;
	margin: 1rem;
	cursor: pointer;
	background-position: center;
	background-size: 100%;
}
</style>

<script>

window.onload = function() {
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const code = urlParams.get('res');

	if (code === "-1") {
		// 로그인 실패 처리
		alert("로그인에 실패하였습니다.");
		window.location = "login";
    } else if (code == "0") {
        alert("아이디 또는 비밀번호 오류입니다.");
        window.location = "login";
    } else if (code == "1") {
        alert("로그인에 성공하였습니다.");
        window.location = "main";
    } else if (code == "109") {
        alert("로그아웃에 성공하였습니다.");
        window.location = "main";
    }
}

function login() {

	let id = document.loginForm.id.value;
	let pw = document.loginForm.pw.value;

	if (!id) {
		alert("아이디를 입력하세요.");
		$("#id").focus();
		return false;
	}

	if (!pw) {
		alert("비밀번호를 입력하세요.");
		$("#pw").focus();
		return false;
	}

	document.loginForm.action = "<%=context%>/controller/login";
	document.loginForm.submit();
}
</script>
</head>

<body>
	<%@include file="../common/header.jsp"%>
	
	<div class="contents">
		<div class="container">

			<div class="form-wrapper">
				<h1>로그인</h1>
				<form name="loginForm" method="post" action="javascript:login();">
					<div class="input-wrapper">
						<label>아이디</label><input type="text" id="id" name="member_id"
							placeholder="아이디" class="form-control">
					</div>
					<div class="input-wrapper">
						<label>비밀번호</label><input type="password" id="pw" name="member_pw"
							placeholder="비밀번호" class="form-control">
					</div>
					<div class="form-button-wrapper">
						<a href="">아이디 찾기</a> &nbsp;&nbsp; <a href="">비밀번호 찾기</a>
					</div>
					<div class="form-button-wrapper">
						<button class="btn-basic">로그인</button>
						<span class="btn-basic btn-line-basic"
							onclick="location.href='/signup'">가입하기</span>
					</div>
				</form>
				<br>
				<hr>
				<br>
				<h4>간편 로그인</h4>
				<div>
					<p class="simpleLogin"
						style="background-image: url(<%=context%>../assets/img/logo_kakao.svg);"></p>
					<p class="simpleLogin"
						style="background-image: url(<%=context%>../assets/img/logo_google.svg);"></p>
				</div>
			</div>

		</div>
	</div>

	<%@include file="../common/footer.jsp"%>

</body>
</html>
