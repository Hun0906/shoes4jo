<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN | SHOES4JO</title>
<%@include file="common/header-head.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<%=context%>/assets/js/script.js"></script>

<style>
.main {
	height: calc(100vh - 325px);
	display: grid;
	text-align: center;
	align-items: center;
}

#random_item {
	background-image: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #E9FFC2 90%, #FDFFAE 100%);
	background-repeat: no-repeat;
	background-position: left -5px bottom 0px;
	background-size: 100% 30%;
	/*cursor: pointer;*/
}

.main_span {
	font-size: 3rem;
	font-weight: bold;
}

#random_item::after {
	content: "|";
	color: #344D67;
	animation: blink 1s infinite step-end;
}

@keyframes blink { 0%, 100% {opacity: 0;} 50%{opacity:1;}
}

#myChart {
	top: 150px;
	z-index: -1;
	display: block;
	box-sizing: border-box;
	height: 700px;
	width: 100%;
	position: fixed;
	margin: 0 auto;
	left: 0;
	right: 0;
	filter: opacity(0.5);
}

@media (max-height: 800px){
	.container{
	height: 100vh;
	}
}

</style>

<script>
document.addEventListener("DOMContentLoaded", function() {
    var elements = document.getElementsByTagName("INPUT");
    for (var i = 0; i < elements.length; i++) {
        elements[i].oninvalid = function(e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
                e.target.setCustomValidity("SHOES4JO가 제안하는 인기 상품을 클릭해 보세요!");
            }
        };
        elements[i].oninput = function(e) {
            e.target.setCustomValidity("");
        };
    };
});

window.onload = function() {
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const code = urlParams.get('err');

	if (code === "nodata") {
		alert("데이터가 없습니다. 다른 검색어를 사용하세요.");
		window.location = "main";
    }
}

function getAPIResult() {
	let keyword = document.getElementById("keyword").value.trim();

	if (!keyword || keyword === "" || keyword === "null" || keyword === null) {
		alert("검색어를 입력하세요.");
		return false;
	}
	
	showLoading();
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/goods_trend?msg=get&keyword="+keyword;
	document.keywordTrendForm.submit();
}
</script>
</head>

<body>
	<%@include file="common/header.jsp"%>

	<div class="contents">
		<div class="container main">
			<div>
				<br>
				<span class="main_span">지금</span><br> <span class="main_span"
					id="random_item" onclick="javascript:setSearchInput();">아디다스 알파바운스 슬라이드 2.0</span><span
					class="main_span">의 쇼핑 트렌드를</span><br> <span class="main_span">알아보세요.</span>
			</div>
			<form action="javascript:getAPIResult()"
				method="post" name="keywordTrendForm">
				<input type="text" class="main_search" name="keyword" id="keyword" required>
				<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Search👀</button>
			</form>

		</div>
		<canvas id="myChart"></canvas>

	</div>

	<script src="<%=context %>/assets/js/main.js"></script>

	<%@include file="common/footer.jsp"%>

</body>
</html>
