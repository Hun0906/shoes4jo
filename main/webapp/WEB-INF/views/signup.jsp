<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | SHOES4JO</title>
<%@include file="header-head.jsp"%>

<style>
.simplesignup {
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
	function signup() {
		let id = document.signupForm.id.value;
		let name = document.signupForm.name.value;
		let pw = document.signupForm.pw.value;
		let pwCheck = document.signupForm.MEMBER_PWCheck.value;
		let today = new Date();
		let signup_date = today.toLocaleDateString();
		let email = document.signupForm.email.value;

		if (!id) {
			alert("아이디를 입력하세요.");
			$("#id").focus();
			return false;
		}

		if (!name) {
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}

		if (!pw) {
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
	    if (!pwCheck) {
	        alert("비밀번호 확인 값을 입력하세요.");
	        $("#pwCheck").focus();
	        return false;
	    }

	    if (pw !== pwCheck) {
	        alert("비밀번호 값이 일치하지 않습니다.");
	        $("#pwCheck").focus();
	        return false;
	    }

		if (!email) {
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}

	    $.ajax({
	        method : "POST",
	        url : "insertMember",
	        dataType : "text",
	        data : {
	            "member_id" : id,
	            "member_name" : name,
	            "member_pw" : pw,
	            "signup_date" : signup_date,
	            "member_email": email,
	        },
	        success : function(response) {
	            console.log("회원가입 성공");
	            alert("회원 가입 하셨습니다.");
	            window.location.href = "login";
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
		<label>이름</label><input type="text" id="name" name="MEMBER_NAME" placeholder="이름" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>이메일</label><input type="text" id="email" name="MEMBER_EMAIL" placeholder="이메일" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>비밀번호</label><input type="password" id="pw" name="MEMBER_PW" placeholder="비밀번호" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>비밀번호 확인</label><input type="password" id="pwCheck" name="MEMBER_PWCheck" placeholder="비밀번호" class="form-control">
		</div>
		<div class="form-button-wrapper">
		<button class="btn-basic" onclick="signup();">회원가입</button>
		</div>
		</form>
		</div>
		

		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>
