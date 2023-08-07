<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACKNOWLEDGEMENT | SHOES4JO</title>
	<%@include file="header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 768px;
}

.input-wrapper label{
margin: 0;
}

.ack-wrapper {
text-align: left;
margin-top: 1rem;
}

.stack-wrapper {
border-left: 1px solid;
padding-left: 1rem;
}

.stack-wrapper p {
margin: 0.5rem;
}
</style>
</head>

<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container">
		
		<div class="form-wrapper">
		<h1>ACKNOWLEDGEMENT</h1>
		<div>
		<h2>레퍼런스</h2>
		<div class="ack-wrapper">
		<div class="input-wrapper">
		<label>네이버 데이터랩</label>
		<a href="https://datalab.naver.com/keyword/trendSearch.naver">
		https://datalab.naver.com/
		</a>
		</div>
		<div class="input-wrapper">
		<label>구글 트렌드</label>
		<a href="https://trends.google.com/trends/">
		https://trends.google.com/trends/
		</a>
		</div>
		<div class="input-wrapper">
		<label>인스파일러</label>
		<a href="https://insfiler.com/detail/rt_shop_daily_kr-0001">
		https://insfiler.com/
		</a>
		</div>
		<div class="input-wrapper">
		<label>마대리</label>
		<a href="https://www.maderi.co.kr/keyword/simple">
		https://www.maderi.co.kr/
		</a>
		</div>
		</div>
		<br>
		<hr>
		<br>
		<h2>사용 기술</h2>
		<div class="ack-wrapper" style="display: grid;
    grid-template-columns: 1fr 1fr;">
    			<div class="input-wrapper">
				<label>언어</label>
				<div class="stack-wrapper">
				<p>Java 11</p>
				<p>JSP</p>
				<p>AJAX</p>
				<p>HTML5/CSS3</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>라이브러리</label>
				<div class="stack-wrapper">
				<p>jQuery</p>
				<p>Bootstrap</p>
				<p>commons DBCP</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>프레임워크</label>
				<div class="stack-wrapper">
				<p>spring</p>
				<p>MyBatis</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>데이터베이스</label>
				<div class="stack-wrapper">
				<p>MySQL</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>개발 환경</label>
				<div class="stack-wrapper">
				<p>eclipse</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>WAS</label>
				<div class="stack-wrapper">
				<p>Apache Tomcat 9.0</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>버전 관리</label>
				<div class="stack-wrapper">
				<p>git</p>
				<p>Sourcetree</p>
				<p>GitHub</p>
				</div>
			</div>
			<div class="input-wrapper">
				<label>협업툴</label>
				<div class="stack-wrapper">
				<p>Notion</p>
				<p>Google Drive</p>
				</div>
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