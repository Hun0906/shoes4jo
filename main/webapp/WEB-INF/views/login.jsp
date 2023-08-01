<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | LOGIN</title>
	<%@include file="header-head.jsp"%>

<style>
.simpleLogin{
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
</head>

<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container">
		
		
		<div class="form-wrapper">
		<h1>로그인</h1>
		<form name="loginForm">
		<div class="input-wrapper">
		<label>아이디</label><input type="text" placeholder="아이디" class="form-control">
		</div>
		<div class="input-wrapper">
		<label>비밀번호</label><input type="password" placeholder="비밀번호" class="form-control">
		</div>
		<div class="form-button-wrapper">
		<a href="">아이디 찾기</a> &nbsp;&nbsp; <a href="">비밀번호 찾기</a>
		</div>
		<div class="form-button-wrapper">
		<button class="btn-basic">로그인</button>
		<button class="btn-basic btn-line-basic">가입하기</button>
		</div>
		</form>
		<br>
		<hr>
		<br>
		<h4>간편 로그인</h4>
		<div><p class="simpleLogin"></p><p class="simpleLogin"></p></div>
		</div>
		

		</div>
	</div>



	<%@include file="footer.jsp"%>

</body>
</html>