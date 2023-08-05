<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | 회원가입</title>
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
		let pwre = document.signupForm.pwre.value;
		let today = new Date();
		let signup_date = today.toLocaleDateString();
		
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
		if (pw!=pwre) {
			alert("비밀번호를 확인해주세요.");
			$("#pw").focus();
			return false;
		}
		if (idre==id) {
			alert("사용중인 아이디 입니다.");
			$("#id").focus();
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
			},
			success : function(response) {
				console.log("회원가입 성공");
				alert("회원 가입 하셨습니다.");
			},
			error : function(xhr, status, error) {
				console.log("Class 호출 실패: ", status, error);
			}
		});

	}
	function checkUserid() {
		let id = document.signupForm.id.value;

		$.ajax({
			method : "POST",
			url : "selectUserid",
			dataType : "text",
			data : {
				"member_id" : id
			},
			success : function(response) {
				console.log("회원가입 성공");
				alert("회원 가입 하셨습니다.");
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
				<form name="signupForm" onsubmit="return signup();">
					<div class="input-wrapper">

						<label>아이디</label><input type="text" id="id" name="id"
							placeholder="아이디" class="form-control">
						    <input type="button" id="idre" name="idre" placeholder="아이디 중복 확인"  value="아이디 중복 확인" onclick="checkUserid()">
					</div>
					
					<div class="input-wrapper">
						<label>이름</label><input type="text" id="name" name="name"
							placeholder="이름" class="form-control">
					</div>
					<div class="input-wrapper">
						<label>비밀번호</label><input type="password" id="pw" name="pw"
							placeholder="비밀번호" class="form-control" autocomplete="off">
					</div>
					<div class="input-wrapper">
						<label>비밀번호 재확인</label><input type="password" id="pwre" name="pwre"
							placeholder="비밀번호 재확인" class="form-control" autocomplete="off">
					</div>
				
					
					<div class="form-button-wrapper">
						<button class="btn-basic" type="submit">회원가입</button>
					</div>
				</form>
				<br>
				<hr>
				<br>
				<h4>간편 가입</h4>
				<div>
					<p class="simplesignup"
						style="background-img: url('/assets/img/logo_kakao.svg')"></p>
					<p class="simplesignup"></p>
				</div>
			</div>

		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>
