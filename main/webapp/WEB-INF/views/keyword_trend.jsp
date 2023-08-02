<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | 상품별 트렌드</title>
<%@include file="header-head.jsp"%>

<script>
	function getAPIResult() {
		// Step1: Set your API credentials here
		const clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
		const clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret

		//Step2: 값 입력하기
		let date = new Date();
		let today = date.getFullYear() + '-'
				+ String(date.getMonth() + 1).padStart(2, '0') + '-'
				+ String(date.getDate()).padStart(2, '0');

		var keyword = document.getElementById("keyword").value;

		if (!keyword) {
			alert("검색어를 입력하세요.");
			setTimeout(function() {
				$("#keyword").focus();
			}, 100);
			return false;
		}

		console.log("keyword: "+keyword);
		// Step3: java 이용해서 호출
		$.ajax({
			method : "GET",
			url : "api/keywordtrend",
			dataType : "json",
			data : {
				"keyword" : keyword,
			},
			success : function(response) {
				// Step4: Process the API response
				var resultData = '';
				resultData += JSON.stringify(response);
				document.getElementById("result").innerHTML = resultData;
				drawChart();
			},
			error : function(xhr, status, error) {
				console.log("API 호출 실패: ", status, error);
			}
		});
	}
</script>

</head>
<body>
	<%@include file="header.jsp"%>

	<div class="contents">
		<div class="container" style="text-align: center; height: calc(100vh - 330px);">
			<form name="keywordTrendForm" action="javascript:getAPIResult();" style="
    position: relative;
    top: calc(50vh - 192px);
">
				<%
				String keyword = request.getParameter("keyword");
				%>
				<input type="text" class="main_search" id="keyword"
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
<script>
var keyword = document.getElementById("keyword").value;

if (keyword != "" && keyword != "null" && keyword != null) {
	document.keywordTrendForm.submit();
}

setPosition();
</script>
	<%@include file="footer.jsp"%>
</body>
</html>