<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분류별 트렌드 | SHOES4JO</title>
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

	const msg = urlParams.get('msg');
	if (msg == 'get') {
		showLoading();
    	location.href="<%=context%>/category_trend/model";
    } else if (msg == 'error'){
    	alert("오류가 발생했습니다.");
    	location.href="<%=context%>/";
    }
	
	drawChart();
	$('body').css({
    	'overflow': '',
    })
}

function drawChart() {
	let xArr = [];
	<c:forEach var="list" items="${data50000000}">xArr.push("${list.period_sdata}");</c:forEach>
	xArr = xArr.reverse(); //내림차순 정렬이기 때문에 reverse
	
	let yArr = [];
	<c:forEach var="list" items="${data50000000}">yArr.push("${list.ratio_cnt}");</c:forEach>
	yArr = yArr.map(Number).reverse();

	drawLineChart(yArr.map(e=>e/Math.max(...yArr)), xArr.map(e=>e.slice(5,7)+"/"+e.slice(8))); //최대값으로 정규화
}

function drawLineChart(line_y_arr, line_x_arr) {
	  const ctx = document.getElementById('lineChart');
	  let lineChart;

	  lineChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	      labels: line_x_arr,
	      datasets: [{
	        label: "카테고리 클릭량",
	        data: line_y_arr,
	        borderColor: "#6ECCAF",
	        borderWidth: 2,
	        pointRadius: 3
	      }]
	    },
	    options: {
	      responsive: true ,
	      plugins: {
		    title: {
		      display: false ,
		    },
		    legend: {
		      display: true
		    },
		  },
	      scales: {
	        x: {
	          display: true ,
	          title: {
	            display: true ,
	            text: "날짜",
	          }
	         },
	         y: { 
	           beginAtZero: true,
			   title: { 
			     display: true ,
			     text: "상대 비율 (arb. units)",
			   }
	         }
	       }  
	     }  
	   });
	}
	
</script>

<style>

h2{
display: inline;
	margin: 0 auto;
}

.normal{
	background: none;
	font-size: 2rem;
}

.header {
    margin-bottom: 1rem;
}

.header span {
	font-size: 2rem;
}

.header select{
	word-wrap: normal;
    font-size: 2rem;
    width: fit-content;
    text-align: center;
    background-image: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #E9FFC2 90%, #FDFFAE 100%);
    background-repeat: no-repeat;
    background-position: left 0 bottom -4px;
    background-size: 120% 6px;
    border: none;
    outline: none;
    font-weight: 500;
}

.header option {
	font-size: 1.5rem;
}

.header option:hover {
	background: #E9FFC2;
}

</style>

</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container">
		<h1>분류별 트렌드</h1>
				<div class="header">
					<h2 class="category-selector"><select onchange="javascript:selectCategory(this.value);">
						<c:forEach var="cat" items="${catList}"><option value=${cat.catId}>${cat.category_name}</option></c:forEach>
						</select></h2>
					<span> 카테고리에 대한 사람들의 관심도는?</span>
				</div>

			<div>
				<canvas id="lineChart"></canvas>
			</div>
			
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<%@include file="../common/footer.jsp"%>
</body>
</html>