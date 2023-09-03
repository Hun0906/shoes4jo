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
    obj.style.color = "yellow";
}

</script>

<style>
#ranking_list{
line-height: 1.0;
word-break: keep-all;
}
#ranking_list span{
font-size: 8pt;
}
.ranking_list span::after{
content:" /";
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="contents">
		<div class="container" id="container" style="text-align: center;">
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
		
		<div>
		<h2>랭킹 등록</h2>
		<div style="display: flex;" >
		<div id="ranking_list">
		<span>나이키 데이브레이크</span>
		<span>나이키 조던1 미드</span>
		<span>뉴발란스 993</span>
		<span>나이키 에어포스</span>
		<span>컨버스 런스타 하이크</span>
		<span>몽클레어 컨버스 척70</span>
		<span>오니츠카타이거 멕시코66</span>
		<span>컨버스 척테일러</span>
		<span>반스 올드스쿨</span>
		<span>뉴발란스 327</span>
		<span>나이키 킬샷</span>
		<span>나이키 와플레이서</span>
		<span>나이키 에어줌 파이어</span>
		<span>나이키 와플트레이너</span>
		<span>아디다스 네오조그</span>
		<span>나이키 에어맥스 퓨전</span>
		<span>나이키 울프그레이</span>
		<span>뉴발란스 990v3</span>
		<span>휠라 디스럽터2</span>
		<span>반스 어센틱</span>
		<span>아디다스 로우 클라우드</span>
		<span>뉴발란스 410v5</span>
		<span>푸마 스웨이드 클래식</span>
		<span>아식스 조그 100 2</span>
		<span>아디다스 삼바로즈</span>
		<span>나이키 데이브레이크</span>
		<span>아디다스 가젤</span>
		<span>뉴발란스 574 클래식</span>
		<span>케즈 블루 클라우드</span>
		<span>오트리 메달리스트 블루탭</span>
		<span>리복 클럽X 리벤지</span>
		<span>디올 워크앤디올 스니커즈</span>
		<span>골든구스 슈퍼스타</span>
		<span>알렉산더 맥퀸 오버사이즈드 스니커즈</span>
		<span>나이키 에어포스 1</span>
		<span>아디다스 알파바운스 슬라이드 2.0</span>
		<span>닥터마틴 2976 첼시 스무스</span>
		<span>아디다스 슈퍼스타</span>
		<span>컨버스 척테일러 올스타 코어</span>
		<span>크록스 클래식 클로그</span>
		<span>에어 조던 레거시 312 로우</span>
		<span>반스 올드스쿨</span>
		<span>우포스 OORIGINAL BLACK</span>
		<span>닥터마틴 1461 3홀 모노</span>
		<span>어그 퍼 카라 스웨이드 플랫폼 슬리퍼</span>
		<span>반스 어센틱</span>
		<span>뉴발란스 530</span>
		<span>나이키 덩크 로우 프로 프리미엄</span>
		<span>조던 1 로우</span>
		<span>아식스 젤 1130</span>
		<span>나이키 레볼루션6 넥스트 네이처</span>
		<span>아식스 젤 벤쳐 6</span>
		<span>아디다스 쇼더웨이 2.0</span>
		<span>나이키 플렉스 러너2</span>
		<span>아식스 조그 100T 우먼스</span>
		<span>나이키 코트 레거시</span>
		<span>아디다스 알파바운스 슬라이드 2.0</span>
		<span>나이키 코트 버로우 로우2</span>
		<span>나이키 에어맥스 SC</span>
		<span>아디다스 아딜렛 클로그</span>
		<span>아식스 젤 소노마 15-50</span>
		<span>아디다스 니짜 트레포일</span>
		<span>프레드페리 로티 레더</span>
		<span>팔렛 탑스티치 웨스턴 부츠</span>
		<span>케즈 볼드 메리제인</span>
		<span>엘칸토 마쯔 남성 페니 로퍼</span>
		<span>레더리 토루프 모던 샌들 슬라이드</span>
		</div>
		<button class="btn-basic btn-color2" onclick="location.href='<%=context%>/save/all_ranking'">Save</button>
		</div>
		</div>

		</div>
		
		<div>
		<h2>인기검색어 크롤링</h2>
		<button class="btn-basic btn-color2" onclick="location.href='<%=context%>/save/crawling'">Save</button>
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