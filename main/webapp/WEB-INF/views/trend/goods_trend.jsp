<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품별 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script src="<%=context%>/assets/js/script.js"></script>

<script>
window.onload = function() {
	closeLoading();
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

	const keyword = urlParams.get('keyword');
	if (!keyword){
		alert("검색어를 입력하세요.");
		location.href="<%=context%>/main";
	}
	
	const msg = urlParams.get('msg');
	if (msg == 'get') {
		showLoading();
    	getDBdata();
    } else if (msg == 'err') {
		showLoading();
    	if (confirm("데이터가 없습니다. 추가하시겠습니까?")){
    		getAPIResult();
    	} else {
    		location.href="<%=context%>/main";
    	}
    }
	drawChart();
	$('body').css({
    	'overflow': '',
    })
}

function getAPIResult() {
	let keyword = document.getElementById("keyword").value;
	
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/save/goods_trend";
	document.keywordTrendForm.submit();
}

function getDBdata() {
	let keyword = document.getElementById("keyword").value;

	if (!keyword || keyword === "" || keyword === "null" || keyword === null) {
		alert("검색어를 입력하세요.");
		location.href="main";
	}
	
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/goods_trend/get_data";
	document.keywordTrendForm.submit();
}

function drawChart() {
	let xArr = [];
	<c:forEach var="selectAll" items="${selectAll}">xArr.push("${selectAll.period_sdata}");</c:forEach>
	xArr = xArr.reverse(); //내림차순 정렬이기 때문에 reverse
	
	let yArr1 = [];
	<c:forEach var="selectAll" items="${selectAll}">yArr1.push("${selectAll.ratio_cnt}");</c:forEach>
	yArr1 = yArr1.map(Number).reverse();

	let yArr2 = [];
	<c:forEach var="search" items="${search}">yArr2.push("${search.ratio_cnt}");</c:forEach>
	yArr2 = yArr2.map(Number).reverse();
	
	drawLineChart(yArr1.map(e=>e/Math.max(...yArr1)), yArr2.map(e=>e/Math.max(...yArr2)), xArr.map(e=>e.slice(5,7)+"/"+e.slice(8))); //최대값으로 정규화
	
	
	let fArr = [];
	<c:forEach var="selectFemale" items="${selectFemale}">fArr.push("${selectFemale.ratio_cnt}");</c:forEach>
	let fVal = fArr.map(Number).reduce((acc,e)=>acc+e,0); //기간 내 데이터 합산

	let mArr = [];
	<c:forEach var="selectMale" items="${selectMale}">mArr.push("${selectMale.ratio_cnt}");</c:forEach>
	let mVal = mArr.map(Number).reduce((acc,e)=>acc+e,0); //기간 내 데이터 합산

	drawPieChart(Math.round((fVal*100)/(fVal+mVal)),Math.round((mVal*100)/(fVal+mVal))); //퍼센티지화
	
	
	let pcArr = [];
	<c:forEach var="selectPC" items="${selectPC}">pcArr.push("${selectPC.ratio_cnt}");</c:forEach>
	let pcVal = pcArr.map(Number).reduce((acc,e)=>acc+e,0); //기간 내 데이터 합산

	let moArr = [];
	<c:forEach var="selectMobile" items="${selectMobile}">moArr.push("${selectMobile.ratio_cnt}");</c:forEach>
	let moVal = moArr.map(Number).reduce((acc,e)=>acc+e,0); //기간 내 데이터 합산

	drawDoughnutChart(Math.round((pcVal*100)/(pcVal+moVal)),Math.round((moVal*100)/(pcVal+moVal))); //퍼센티지화
	
	
	let age10Arr = [];
	<c:forEach var="age" items="${selectAge10}">age10Arr.push("${age.ratio_cnt}");</c:forEach>
	let age20Arr = [];
	<c:forEach var="age" items="${selectAge20}">age20Arr.push("${age.ratio_cnt}");</c:forEach>
	let age30Arr = [];
	<c:forEach var="age" items="${selectAge30}">age30Arr.push("${age.ratio_cnt}");</c:forEach>
	let age40Arr = [];
	<c:forEach var="age" items="${selectAge40}">age40Arr.push("${age.ratio_cnt}");</c:forEach>
	let age50Arr = [];
	<c:forEach var="age" items="${selectAge50}">age50Arr.push("${age.ratio_cnt}");</c:forEach>
	let age60Arr = [];
	<c:forEach var="age" items="${selectAge60}">age60Arr.push("${age.ratio_cnt}");</c:forEach>

	let ageValues = [
	    age10Arr.map(Number).reduce((acc,e)=>acc+e,0),
	    age20Arr.map(Number).reduce((acc,e)=>acc+e,0),
	    age30Arr.map(Number).reduce((acc,e)=>acc+e,0),
	    age40Arr.map(Number).reduce((acc,e)=>acc+e,0),
	    age50Arr.map(Number).reduce((acc,e)=>acc+e,0),
	    age60Arr.map(Number).reduce((acc,e)=>acc+e,0)
	];
	
	let ageSum = ageValues.reduce((acc,e)=>acc+e);
	
	drawBarChart(ageValues.map(e=>Math.round((e/ageSum)*100)));
}
</script>

<style>
.goods_trend_header{
margin: 2rem 0;
}

.goods_trend_header a{
	position: relative;
    top: -0.5rem;
    margin: 0.3rem;
    border-radius: 10px;
    padding: 3px 10px 5px 10px;
    background: #f7f7f7;
    color: #5c5c5c;
    text-decoration: none;
}

h2{
display: inline;
}

.normal{
	background: none;
	font-size: 2rem;
}

hr{
margin: 2.25rem 0;
}
</style>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container">
		<h1>상품별 트렌드</h1>
			<form name="keywordTrendForm" action="javascript:getDBdata();">
				<%
				String keyword = request.getParameter("keyword");
				%>
				<input type="text" class="main_search" id="keyword" name="keyword"
					value="<%=(keyword == null) ? "" : keyword%>"/>
				<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Search👀</button>
			</form>
			<div class="goods_trend_header">
			<a href="<%=context%>/goodscon/view.do?keyword=<%=keyword.replaceAll(" ","")%>">🔎상품 상세페이지</a>
			<hr>
			<h2><%=(keyword == null) ? "" : keyword%></h2><span class="normal">에 대한 사람들의 관심도는?</span>
			</div>

			<div style="display: grid; row-gap: 3rem;">
				<canvas id="lineChart"></canvas>
				<div style="display: grid; grid-template-columns: 1fr 1fr; justify-items: center; gap: 1rem;">
					<div>
					<canvas id="pieChart"></canvas>
					</div>
					<div>
					<canvas id="doughnutChart"></canvas>
					</div>
				</div>
				<canvas id="barChart"></canvas>
			</div>
			
			<h2></h2>

		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="<%=context%>/assets/js/drawChart.js"></script>

	<%@include file="../common/footer.jsp"%>
</body>
</html>