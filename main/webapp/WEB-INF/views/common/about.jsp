<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ABOUT | SHOES4JO</title>
<%@include file="header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 1024px;
}

.team-wrapper {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr 1fr;
}

.team-card {
	padding: 0.5rem;
	margin: 1rem;
}

.team-card img {
	border: 1px solid #ccc;
	border-radius: 10rem;
	width: 100%;
	object-fit: cover;
	object-position: center;
	cursor: pointer;
}

.team-card h3 {
	margin-top: 1rem;
}

.team-card span {
	display: block;
	line-height: 1.8;
}
</style>
</head>

<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container">

			<div class="form-wrapper">
				<h1>ABOUT</h1>
				<div>
					<h2>"신발 전문 트렌드리서치 플랫폼"</h2>
					<br>
					<p>신발 산업의 트렌드를 웹에서 간편하고 쉽게 파악할 수 있는<br>
					신발 전문 <b>트렌드리서치</b> 플랫폼입니다.
					</p>
					<p>웹 여기저기 파편화된 신발 관련 정보를 모아 신발 쇼핑의 포털로 기능합니다!</p>
					<br>
					<hr>
					<br>
					<h2>TEAM</h2>
					<div class="team-wrapper">
						<div class="team-card">
							<img
								src="https://avatars.githubusercontent.com/u/130541650?s=100&v=4"
								onclick="window.open('https://github.com/0123aqq')">
							<h3>하세라</h3>
							<span>아이디, 비밀번호 찾기</span> <span>마이바티스 세팅</span>
						</div>
						<div class="team-card">
							<img
								src="https://avatars.githubusercontent.com/u/134472331?s=100&v=4"
								onclick="window.open('https://github.com/heebanggg')">
							<h3>박희범</h3>
							<span>회원가입</span> <span>2차 DB 설계</span>
						</div>
						<div class="team-card">
							<img src="https://avatars.githubusercontent.com/u/134472216?v=4"
								onclick="window.open('https://github.com/yumalg12')">
							<h3>유맑음</h3>
							<span>메인</span> <span>로그인</span> <span>상품별 트렌드</span> <span>검색량
								트렌드</span>
						</div>
						<div class="team-card">
							<img src="https://avatars.githubusercontent.com/u/134472292?v=4"
								onclick="window.open('https://github.com/Hun0906')">
							<h3>이동훈</h3>
							<span>마이페이지</span> <span>카테고리별 트렌드</span>
						</div>
					</div>

				</div>
				<br>
			</div>


		</div>
	</div>



	<%@include file="footer.jsp"%>

</body>
</html>