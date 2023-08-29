<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색어 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.container {
	text-align: center;
}

.header {
	text-align: center;
}

h2 {
	margin: 0 auto;
}

.header span {
	font-size: 1.6rem;
}
</style>
<script type="text/javascript"
	src="https://ssl.gstatic.com/trends_nrtr/3461_RC01/embed_loader.js"></script>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h1>키워드 트렌드</h1>
		<div
			style="display: grid; grid-template-columns: 1fr 1fr 1fr; grid-gap: 3rem;">

			<div class="subject">
				<div class="header">
					<h2>신발</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "신발",
												"geo" : "KR",
												"time" : "today 3-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%201-m&geo=KR&q=%EC%8B%A0%EB%B0%9C",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>운동화</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "운동화",
												"geo" : "KR",
												"time" : "today 3-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%203-m&geo=KR&q=%EC%9A%B4%EB%8F%99%ED%99%94",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>슬리퍼</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "슬리퍼",
												"geo" : "KR",
												"time" : "today 3-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%201-m&geo=KR&q=%EC%8A%AC%EB%A6%AC%ED%8D%BC",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>나이키</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "나이키",
												"geo" : "KR",
												"time" : "today 1-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%201-m&geo=KR&q=%EB%82%98%EC%9D%B4%ED%82%A4",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>아디다스</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "아디다스",
												"geo" : "KR",
												"time" : "today 1-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%201-m&geo=KR&q=%EC%95%84%EB%94%94%EB%8B%A4%EC%8A%A4",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>뉴발란스</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list">
					<script type="text/javascript">
						trends.embed
								.renderExploreWidget(
										"RELATED_QUERIES",
										{
											"comparisonItem" : [ {
												"keyword" : "뉴발란스",
												"geo" : "KR",
												"time" : "today 1-m"
											} ],
											"category" : 0,
											"property" : ""
										},
										{
											"exploreQuery" : "date=today%201-m&geo=KR&q=%EB%89%B4%EB%B0%9C%EB%9E%80%EC%8A%A4",
											"guestPath" : "https://trends.google.com:443/trends/embed/"
										});
					</script>
				</div>
			</div>

		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>