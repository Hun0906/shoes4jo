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
							<br>
							<span>스프링 & 마이바티스 개발환경 설정</span>
							<span>커뮤니티(회원용 자유게시판)</span>
							<span>매거진 관리(관리자용 게시판)</span>
							<span>커뮤니티 댓글</span>
							<span>아이디 & 비밀번호 찾기</span>
							<span>상품 상세페이지</span>
							<span>상품 리스트 관리</span>
							<span>북마크 (즐겨찾기)</span>
							<span>최종 산출물 작성</span>
						</div>
						<div class="team-card">
							<img
								src="https://avatars.githubusercontent.com/u/134472331?s=100&v=4"
								onclick="window.open('https://github.com/heebanggg')">
							<h3>박희범</h3>
							<br>
							<span>회원가입</span> 
							<span>회원 목록 조회</span>
							<span>DB 설계</span>
							<span>상품 상세 데이터 수집</span>
							<span>랭킹 페이지</span>
							<span>SNS 유행 신발 조사</span>
						</div>
						<div class="team-card">
							<img src="https://avatars.githubusercontent.com/u/134472216?v=4"
								onclick="window.open('https://github.com/yumalg12')">
							<h3>유맑음</h3>
							<br>
							<span>프로젝트 기획 & UI 설계 & 디자인 총괄</span>
							<span>메인 페이지 & 로그인</span> 
							<span>헤더 & 푸터</span>
							<span>매거진</span> 
							<span>상품별 트렌드</span>
							<span>키워드 트렌드</span>
							<span>연관 주제(워드 클라우드)</span>
							<span>깃허브 협업 주도</span>
							<span>코드 리팩토링</span>
						</div>
						<div class="team-card">
							<img src="https://avatars.githubusercontent.com/u/134472292?v=4"
								onclick="window.open('https://github.com/Hun0906')">
							<h3>이동훈</h3>
							<br>
							<span>마이페이지</span> 
							<span>분류별 트렌드</span>
							<span>API 자료조사 & 계정 생성</span>
							<span>API & 크롤링 데이터 추출</span>
							<span>내 게시물 보기</span>
							<span>내 댓글 보기</span>
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