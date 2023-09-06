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
function getAPIResult() {
	showLoading();
	let keyword = document.getElementById("keyword").value;

	if (!keyword || keyword === "" || keyword === "null" || keyword === null) {
		alert("검색어를 입력하세요.");
		location.href="main";
	}
	
	console.log("keyword: "+keyword);
	document.keywordTrendForm.action = "<%=context%>/save/goods_trend";
	document.keywordTrendForm.submit();
}

function setSearch(obj) {
    document.getElementById("keyword").value = obj.innerHTML;
    console.log(obj.innerHTML);
    obj.style.color = "#ADE792";
}

function saveKeywordTrend() {
	showLoading();
	location.href="<%=context%>/save/keyword_crawling";
}

</script>

<style>
#ranking_list{
line-height: 1.0;
display: grid;
grid-template-columns: repeat(12,1fr);
gap: 10px;
word-break: keep-all;
}

#ranking_list span{
font-size: 8pt;
}

</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container">
		<h1>트렌드 데이터 추출</h1>
		<div>
		<h2>상품별 트렌드</h2>
			<form name="keywordTrendForm" action="javascript:showLoading();getAPIResult();">
				<%
				String keyword = request.getParameter("keyword");
				%>
				<input type="text" class="main_search" id="keyword" name="keyword"
					value="<%=(keyword == null) ? "" : keyword%>"/>
				<button class="btn-basic btn-color2">Save</button>
			</form>
			<div>
				<a target="_blank" href="https://developers.naver.com/docs/serviceapi/datalab/shopping/shopping.md#%EC%87%BC%ED%95%91%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8-%ED%82%A4%EC%9B%8C%EB%93%9C%EB%B3%84-%ED%8A%B8%EB%A0%8C%EB%93%9C-%EC%A1%B0%ED%9A%8C">
					API Docs</a>
				<a target="_blank" href="https://datalab.naver.com/keyword/trendSearch.naver">데이터랩</a>
				<a target="_blank" href="https://developers.naver.com/docs/common/openapiguide/errorcode.md#%EC%A3%BC%EC%9A%94-%EC%98%A4%EB%A5%98-%EC%BD%94%EB%93%9C">
				오류 코드</a>
			</div>
		</div>
		
		<hr>
		
		<div>
		<h2>랭킹 등록</h2>
		<div style="display: flex;" >
		<div id="ranking_list">
		<c:forEach var="list" items="${goodsList}">
			<span>${list }</span>
		</c:forEach>
		</div>
		<button class="btn-basic btn-color2" onclick="location.href='<%=context%>/save/all_ranking'">Save</button>
		</div>
		</div>
		
		<hr>
		
		<div>
		<h2>인기검색어 크롤링</h2>
		<div class="form-wrapper">
			<button class="btn-basic btn-color2" onclick="saveKeywordTrend()">Save</button>
		</div>
		</div>
		
	</div>
	</div>

	<%@include file="../common/footer.jsp"%>
	
	<script>
	document.addEventListener('DOMContentLoaded', () => {
	    Array.from(document.getElementById("ranking_list").children).forEach(e => {
	        e.onclick = function() {
	            setSearch(this);
	        };
	    });
	});
	</script>
</body>
</html>