<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | 회원가입</title>
	<%@include file="header-head.jsp"%>

<style>
.simplesignup{
border: 1px solid black;
background-color: #ccc;
border-radius: 10rem;
height: 64px;
width: 64px;
display: inline-block;
margin: 1rem;
cursor: pointer;
}
</style>

<script>

function signup(){
	
let id = document.signupForm.id.value;
let pw = document.signupForm.pw.value;

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

$.ajax({
	method : "POST",
	url : "controller/signup",
	dataType : "json",
	data : {
		"id" : id,
		"pw" : pw,
	},
	success : function(response) {
		console.log("회원가입 성공");
	},
	error : function(xhr, status, error) {
		console.log("Class 호출 실패: ", status, error);
	}
});

}

</script>
</head>

<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container">
		
		<div class="form-wrapper">
		<h1>회원가입</h1>
		<form name="signupForm" action="javascript:signup();">
		<div class="input-wrapper">
		<label>아이디</label><input type="text" id="id" name="MEMBER_ID" placeholder="아이디" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>이름</label><input type="text" id="id" name="MEMBER_NAME" placeholder="아이디" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>비밀번호</label><input type="password" id="pw" name="MEMBER_PW" placeholder="비밀번호" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>비밀번호 확인</label><input type="password" id="pw" placeholder="비밀번호" class="form-control">
		</div>
		<div class="form-button-wrapper">
		<button class="btn-basic">회원가입</button>
		</div>
		</form>
		</div>
		

		</div>
	</div>



	<%@include file="footer.jsp"%>

</body>
</html>