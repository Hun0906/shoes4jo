<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품별 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script src="<%=context%>/assets/js/script.js"></script>
<script>
window.onload = function() {
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	
	if (queryString == ""){
		getAPIResult();
	} else {
		const urlParams = new URLSearchParams(queryString);
		const code = urlParams.get('do');
		if (code == "show"){
		showAPIResult();
		}
	}
}

function getAPIResult() {
	var keyword = document.getElementById("keyword").value;

	if (!keyword || keyword === "" || keyword === "null" || keyword === null) {
		alert("검색어를 입력하세요.");
		location.href="main";
	}
	var keyword = document.getElementById("keyword").value;

	showLoading();
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/keyword_trend/con/insert.do";
	document.keywordTrendForm.submit();
}

function showAPIResult() {
	closeLoading();
	alert("성공");
	document.getElementById("result").innerHTML = //DB data...
	drawChart();
}
</script>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container" style="text-align: center;">
			<form name="keywordTrendForm" action="javascript:getAPIResult();">
				<%
				String keyword = request.getParameter("keyword");
				%>
				<input type="text" class="main_search" id="keyword" name="keyword"
					value="<%=(keyword == null) ? "" : keyword%>"/>
				<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Search👀</button>
			</form>
			<br>
			<div style="display: none;">
				<a target="_blank" href="https://developers.naver.com/docs/serviceapi/datalab/shopping/shopping.md#%EC%87%BC%ED%95%91%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8-%ED%82%A4%EC%9B%8C%EB%93%9C%EB%B3%84-%ED%8A%B8%EB%A0%8C%EB%93%9C-%EC%A1%B0%ED%9A%8C">
					API Docs</a>
				<a target="_blank" href="https://datalab.naver.com/keyword/trendSearch.naver">데이터랩</a>
				<a href="#" onclick="javascript:drawChart();">파싱 테스트</a>
				<a target="_blank" href="https://developers.naver.com/docs/common/openapiguide/errorcode.md#%EC%A3%BC%EC%9A%94-%EC%98%A4%EB%A5%98-%EC%BD%94%EB%93%9C">
				오류 코드</a>
			</div>

			<div id="result" style="display: none"></div>

			<div id="parse_result">
				<canvas id="myChart"></canvas>
			</div>

		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="<%=context%>/assets/js/drawChart.js"></script>

	<%@include file="../common/footer.jsp"%>
</body>
</html>