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
	showLoading();
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
    	if (confirm("데이터가 없습니다. 추가하시겠습니까?")){
			showLoading();
    		getAPIResult();
    	} else {
    		location.href="<%=context%>/main";
    	}
    }
	drawChart();
	closeLoading();
	$('body').css({
    	'overflow': '',
    })
}

function getAPIResult() {
	showLoading();
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
	let xArr = document.getElementById("selectAll_x").innerHTML.trim().split(" ").reverse(); //내림차순 정렬이기 때문에 reverse
	let yArr1 = document.getElementById("selectAll_y").innerHTML.trim().split(" ").reverse();
	let yArr2 = document.getElementById("search_y").innerHTML.trim().split(" ").reverse();
	drawLineChart(yArr1.map(e=>e/Math.max(...yArr1)), yArr2.map(e=>e/Math.max(...yArr2)), xArr.map(e=>e.slice(5,7)+"/"+e.slice(8))); //최대값으로 정규화
	
	let fArr = document.getElementById("selectGen_f").innerHTML.trim().split(" ");
	let mArr = document.getElementById("selectGen_m").innerHTML.trim().split(" ");
	let fVal = fArr.reduce((acc,e)=>e,0); //기간 내 데이터 합산
	let mVal = mArr.reduce((acc,e)=>e,0);
	drawPieChart((fVal*100)/(fVal+mVal),(mVal*100)/(fVal+mVal)); //퍼센티지화
	
	let pcArr = document.getElementById("selectDev_pc").innerHTML.trim().split(" ");
	let moArr = document.getElementById("selectDev_mo").innerHTML.trim().split(" ");
	let pcVal = pcArr.reduce((acc,e)=>e,0); //기간 내 데이터 합산
	let moVal = moArr.reduce((acc,e)=>e,0);
	drawDoughnutChart((pcVal*100)/(pcVal+moVal),(moVal*100)/(pcVal+moVal)); //퍼센티지화
	
	let selectAge_10 = document.getElementById("selectAge_10").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let selectAge_20 = document.getElementById("selectAge_20").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let selectAge_30 = document.getElementById("selectAge_30").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let selectAge_40 = document.getElementById("selectAge_40").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let selectAge_50 = document.getElementById("selectAge_50").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let selectAge_60 = document.getElementById("selectAge_60").innerHTML.trim().split(" ").reduce((acc,e)=>e);
	let barArr = [selectAge_10,selectAge_20,selectAge_30,selectAge_40,selectAge_50,selectAge_60];
	drawBarChart(barArr.map(e=>e/Math.max(...barArr)));
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
		<div class="container" id="container" style="text-align: center;">
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
			<a href="">⭐즐겨찾기 등록</a><a href="">🔎상품 상세페이지</a>
			<hr>
			<h2><%=(keyword == null) ? "" : keyword%></h2><span class="normal">에 대한 사람들의 관심도는?</span>
			</div>
			<div style="display: none;">
				<a target="_blank" href="https://developers.naver.com/docs/serviceapi/datalab/shopping/shopping.md#%EC%87%BC%ED%95%91%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8-%ED%82%A4%EC%9B%8C%EB%93%9C%EB%B3%84-%ED%8A%B8%EB%A0%8C%EB%93%9C-%EC%A1%B0%ED%9A%8C">
					API Docs</a>
				<a target="_blank" href="https://datalab.naver.com/keyword/trendSearch.naver">데이터랩</a>
				<a href="#" onclick="javascript:drawChart();">파싱 테스트</a>
				<a target="_blank" href="https://developers.naver.com/docs/common/openapiguide/errorcode.md#%EC%A3%BC%EC%9A%94-%EC%98%A4%EB%A5%98-%EC%BD%94%EB%93%9C">
				오류 코드</a>
			</div>
			<div style="display: none;">
			<span id="selectAll_x"><c:forEach var="selectAll" items="${selectAll}">${selectAll.period_sdata} </c:forEach></span>
			<span id="selectAll_y"><c:forEach var="selectAll" items="${selectAll}">${selectAll.ratio_cnt} </c:forEach></span>
			<span id="search_y"><c:forEach var="search" items="${search}">${search.ratio_cnt} </c:forEach></span>
			<span id="selectGen_f"><c:forEach var="selectFemale" items="${selectFemale}">${selectFemale.ratio_cnt} </c:forEach></span>
			<span id="selectGen_m"><c:forEach var="selectMale" items="${selectMale}">${selectMale.ratio_cnt} </c:forEach></span>
			<span id="selectDev_pc"><c:forEach var="selectPC" items="${selectPC}">${selectPC.ratio_cnt} </c:forEach></span>
			<span id="selectDev_mo"><c:forEach var="selectMobile" items="${selectMobile}">${selectMobile.ratio_cnt} </c:forEach></span>
			<span id="selectAge_10"><c:forEach var="selectAge10" items="${selectAge10}">${selectAge10.ratio_cnt} </c:forEach></span>
			<span id="selectAge_20"><c:forEach var="selectAge20" items="${selectAge20}">${selectAge20.ratio_cnt} </c:forEach></span>
			<span id="selectAge_30"><c:forEach var="selectAge30" items="${selectAge30}">${selectAge30.ratio_cnt} </c:forEach></span>
			<span id="selectAge_40"><c:forEach var="selectAge40" items="${selectAge40}">${selectAge40.ratio_cnt} </c:forEach></span>
			<span id="selectAge_50"><c:forEach var="selectAge50" items="${selectAge50}">${selectAge50.ratio_cnt} </c:forEach></span>
			<span id="selectAge_60"><c:forEach var="selectAge60" items="${selectAge60}">${selectAge60.ratio_cnt} </c:forEach></span>
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

		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="<%=context%>/assets/js/drawChart.js"></script>

	<%@include file="../common/footer.jsp"%>
</body>
</html>