<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랭킹 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.header {
    margin-bottom: 1rem;
}

h2 {
	margin: 0 auto;
	display: inline;
}

.header span {
	margin-left: 0.4rem;
	font-size: 2rem;
}

.date{
    display: block;
    font-size: 1.4rem;
    font-weight: 600;
    background: #000;
    color: white;
    letter-spacing: 1px;
    text-align: center;
    margin: 0 auto 0.5rem auto;
    overflow: hidden;
    white-space: nowrap;
    height: 2rem;
}

marquee{
    position: relative;
    top: -1px;
}

#nodata{
	font-size: 1.3rem;
	text-align: center;
	margin: 17.5rem 0;
}

.list-wrapper{
	/*border: 1px solid #ADE792;*/
    border-radius: 10px;
    padding: 1rem 0;
    box-shadow: 0 0 0 0.25rem #ADE79250;
}

.list-wrapper ul{
	padding: 0;
	margin: 0;
}

.list-wrapper b{
    font-size: 1.3rem;
}

.list-wrapper li{
	list-style: none;
    padding: 1rem;
    margin: 0;
    font-size: 1.3rem;
    border-bottom: 1px solid #f2f2f2;
    display: grid;
    grid-template-columns: 65px 1fr;
    justify-items: center;
    text-align: center;
}

.list-wrapper li:hover{
    background: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #e9ffc2 90%, #fdffae 100%);
    color: white;
    font-weight: 500;
    cursor: pointer;
    transform: scale(1.03);
    drop-shadow: 0 0 #ccc;
    box-shadow: 0 0 8px #00000020;
    font-size: 1.5rem;
}

.list-wrapper li:hover > b{
    font-size: 1.5rem;
}

@keyframes fadeIn {
  0% {
      opacity: 0;
      transform: translateY(-20px);
  }
  100% {
      opacity: 1;
      transform: translateY(0);
  }
}

.contents{
display: grid;
grid-template-columns: repeat(3, 1fr);
grid-gap: 3rem;
max-width: 1366px;
margin: auto;
padding: 0 2rem;
}

@media (max-width: 1024px){
.contents{
grid-template-columns: 1fr;
}
}

</style>

</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container">
	<h1>SHOES4JO 선정 랭킹</h1>
	</div>
		<div class="contents">

			<div class="subject">
				<div class="header">
					<h2>일간</h2><span>랭킹</span>
				</div>
				<div class="list-wrapper" id="day-rank">
					<div class="date"><marquee scrollamount="10" direction="right">${dateMap['today']}</marquee></div>
					<c:if test="${empty dayRank}"><div id="nodata"><p>표시할 랭킹 데이터가 없습니다.</p><button class="btn-basic btn-color2" onclick="location.href='<%=context%>/'">트렌드 검색하기👀</button></div></c:if>
				<ul>
					<c:forEach var="ranking" items="${dayRank}" varStatus="status">
					<li onclick="location.href='${pageContext.request.contextPath}/goodscon/view.do?keyword=${ranking.keyword}'">
							${ranking.title}</li> <!-- 클릭 시 상세정보 페이지로 이동 -->
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>주간</h2><span>랭킹</span>
				</div>
				<div class="list-wrapper" id="week-rank">
					<div class="date"><marquee scrollamount="10" direction="right">${dateMap['week']} ~ ${dateMap['today']}</marquee></div>
					<c:if test="${empty weekRank}"><div id="nodata"><p>표시할 랭킹 데이터가 없습니다.</p><button class="btn-basic btn-color2" onclick="location.href='<%=context%>/'">트렌드 검색하기👀</button></div></c:if>
				<ul>
					<c:forEach var="ranking" items="${weekRank}" varStatus="status">
					<li onclick="location.href='${pageContext.request.contextPath}/goodscon/view.do?keyword=${ranking.keyword}'">
							${ranking.title}</li> <!-- 클릭 시 상세정보 페이지로 이동 -->
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>월간</h2><span>랭킹</span>
				</div>
				<div class="list-wrapper" id="month-rank">
					<div class="date"><marquee scrollamount="10" direction="right">${dateMap['month']} ~ ${dateMap['today']}</marquee></div>
					<c:if test="${empty monthRank}"><div id="nodata"><p>표시할 랭킹 데이터가 없습니다.</p><button class="btn-basic btn-color2" onclick="location.href='<%=context%>/'">트렌드 검색하기👀</button></div></c:if>
				<ul>
					<c:forEach var="ranking" items="${monthRank}" varStatus="status">
					<li onclick="location.href='${pageContext.request.contextPath}/goodscon/view.do?keyword=${ranking.keyword}'">
							${ranking.title}</li> <!-- 클릭 시 상세정보 페이지로 이동 -->
					</c:forEach>
				</ul>
				</div>
			</div>


		</div>
	
	<%@include file="../common/footer.jsp"%>

<script>
document.addEventListener('DOMContentLoaded', () => {
	Array.from(document.getElementsByTagName("ul")).forEach(v => {
		Array.from(v.children).forEach((e, i) => { 
			let bTag = document.createElement('b');
			bTag.innerHTML = i + 1;
			e.prepend(bTag);
			e.style.animation = "fadeIn " + (i+1)/7 + "s ease-in-out";
		});
	});
});
</script>
</body>
</html>