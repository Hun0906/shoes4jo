<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품별 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>
<body>
	<%@include file="../common/header.jsp"%>

	<script type="text/javascript"
		src="https://ssl.gstatic.com/trends_nrtr/3349_RC01/embed_loader.js"></script>

<div class="container">
<div style="display:grid; grid-template-columns: 1fr 1fr; grid-gap: 3rem;">


	<div>
	<h2>신발 관련 검색어</h2>
		<script type="text/javascript">
			trends.embed.renderExploreWidget("RELATED_QUERIES", {
				"comparisonItem" : [ {
					"keyword" : "/m/06rrc",
					"geo" : "KR",
					"time" : "now 1-d"
				} ],
				"category" : 0,
				"property" : ""
			}, {
				"exploreQuery" : "q=%2Fm%2F06rrc&date=now%201-d&geo=KR&hl=ko",
				"guestPath" : "https://trends.google.com:443/trends/embed/"
			});
		</script>
	</div>

	<div>
	<h2>운동화 관련 인기 검색어</h2>
				<script type="text/javascript"
					src="https://ssl.gstatic.com/trends_nrtr/3349_RC01/embed_loader.js"></script>
				<script type="text/javascript">
					trends.embed
							.renderExploreWidget(
									"RELATED_QUERIES",
									{
										"comparisonItem" : [ {
											"keyword" : "운동화",
											"geo" : "KR",
											"time" : "now 1-d"
										} ],
										"category" : 0,
										"property" : ""
									},
									{
										"exploreQuery" : "q=%EC%9A%B4%EB%8F%99%ED%99%94&date=now%201-d&geo=KR&hl=ko",
										"guestPath" : "https://trends.google.com:443/trends/embed/"
									});
				</script>
			</div>

	<div>
	<h2>신발 관련 주제</h2>
		<script type="text/javascript">
			trends.embed
					.renderExploreWidget(
							"RELATED_TOPICS",
							{
								"comparisonItem" : [ {
									"keyword" : "/m/06rrc",
									"geo" : "KR",
									"time" : "now 1-d"
								} ],
								"category" : 18,
								"property" : ""
							},
							{
								"exploreQuery" : "cat=18&date=now%201-d&geo=KR&q=%2Fm%2F06rrc&hl=ko",
								"guestPath" : "https://trends.google.com:443/trends/embed/"
							});
		</script>
	</div>



	<div>
	<h2>일별 시간에 따른 관심도</h2>
		<script type="text/javascript">
			trends.embed.renderExploreWidget("TIMESERIES", {
				"comparisonItem" : [ {
					"keyword" : "/m/06rrc",
					"geo" : "KR",
					"time" : "now 1-d"
				} ],
				"category" : 0,
				"property" : ""
			}, {
				"exploreQuery" : "q=%2Fm%2F06rrc&date=now%201-d&geo=KR&hl=ko",
				"guestPath" : "https://trends.google.com:443/trends/embed/"
			});
		</script>
	</div>
	
	<div>
	<h2>일별 지역별 관심도</h2>
		<script type="text/javascript">
			trends.embed.renderExploreWidget("GEO_MAP", {
				"comparisonItem" : [ {
					"keyword" : "/m/06rrc",
					"geo" : "KR",
					"time" : "now 1-d"
				} ],
				"category" : 0,
				"property" : ""
			}, {
				"exploreQuery" : "q=%2Fm%2F06rrc&date=now%201-d&geo=KR&hl=ko",
				"guestPath" : "https://trends.google.com:443/trends/embed/"
			});
		</script>
	</div>

	
</div>
</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>