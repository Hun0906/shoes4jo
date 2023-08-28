<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 추출 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script src="<%=context%>/assets/js/script.js"></script>
<script>
window.onload = function() {
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const code = urlParams.get('show');
	if (code == 'f') {
    	getDBdata();
    } else {
    }
}

function getAPIResult() {
	showLoading();
	let keyword = document.getElementById("keyword").value;

	if (!keyword || keyword === "" || keyword === "null" || keyword === null) {
		alert("검색어를 입력하세요.");
		location.href="main";
	}

	showLoading();
	
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/save/goods_trend";
	document.keywordTrendForm.submit();
	
	closeLoading();
}

</script>

<style>
.goods_trend_header{
margin-bottom: 2rem;
}

.goods_trend_header a{
	position: relative;
    top: -0.8rem;
    margin: 0.3rem;
    border-radius: 10px;
    padding: 3px 10px 5px 10px;
    background: #f7f7f7;
    color: #5c5c5c;
    text-decoration: none;
}
</style>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container" style="text-align: center;">
		<h1>API 데이터 추출</h1>
		<h2>상품별 트렌드</h2>
			<form name="keywordTrendForm" action="javascript:getAPIResult();">
				<%
				String keyword = request.getParameter("keyword");
				%>
				<input type="text" class="main_search" id="keyword" name="keyword"
					value="<%=(keyword == null) ? "" : keyword%>"/>
				<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Save</button>
			</form>
			<div>
				<a target="_blank" href="https://developers.naver.com/docs/serviceapi/datalab/shopping/shopping.md#%EC%87%BC%ED%95%91%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8-%ED%82%A4%EC%9B%8C%EB%93%9C%EB%B3%84-%ED%8A%B8%EB%A0%8C%EB%93%9C-%EC%A1%B0%ED%9A%8C">
					API Docs</a>
				<a target="_blank" href="https://datalab.naver.com/keyword/trendSearch.naver">데이터랩</a>
				<a target="_blank" href="https://developers.naver.com/docs/common/openapiguide/errorcode.md#%EC%A3%BC%EC%9A%94-%EC%98%A4%EB%A5%98-%EC%BD%94%EB%93%9C">
				오류 코드</a>
			</div>
			<div>
			<p id="selectAll_x"><c:forEach var="selectAll" items="${selectAll}">${selectAll.period_sdata} </c:forEach></p>
			<p id="selectAll_y"><c:forEach var="selectAll" items="${selectAll}">${selectAll.ratio_cnt} </c:forEach></p>
			<p id="selectGen_f"><c:forEach var="selectFemale" items="${selectFemale}">${selectFemale.ratio_cnt} </c:forEach></p>
			<p id="selectGen_m"><c:forEach var="selectMale" items="${selectMale}">${selectMale.ratio_cnt} </c:forEach></p>
			<p id="selectAge_10"><c:forEach var="selectAge10" items="${selectAge10}">${selectAge10.ratio_cnt} </c:forEach></p>
			<p id="selectAge_20"><c:forEach var="selectAge20" items="${selectAge20}">${selectAge20.ratio_cnt} </c:forEach></p>
			<p id="selectAge_30"><c:forEach var="selectAge30" items="${selectAge30}">${selectAge30.ratio_cnt} </c:forEach></p>
			<p id="selectAge_40"><c:forEach var="selectAge40" items="${selectAge40}">${selectAge40.ratio_cnt} </c:forEach></p>
			<p id="selectAge_50"><c:forEach var="selectAge50" items="${selectAge50}">${selectAge50.ratio_cnt} </c:forEach></p>
			<p id="selectAge_60"><c:forEach var="selectAge60" items="${selectAge60}">${selectAge60.ratio_cnt} </c:forEach></p>
			</div>

		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="<%=context%>/assets/js/drawChart.js"></script>

	<%@include file="../common/footer.jsp"%>
</body>
</html>