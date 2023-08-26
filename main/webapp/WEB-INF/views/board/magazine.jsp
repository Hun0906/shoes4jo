<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매거진 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
hr{
margin: 4rem;
}

.card-wrapper{
display: grid;
grid-template-columns: 1fr 1fr 1fr;
gap: 1rem;
}

.card{
text-align: center;
padding-bottom: 1rem;
border: none;
}

.card label{
font-weight: 500;
padding: 1rem 1rem 0.3rem 1rem;
font-size: 1.5rem;
overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
}

.card p {
display: -webkit-box;
-webkit-line-clamp: 2;
-webkit-box-orient: vertical;
overflow: hidden;
text-overflow: ellipsis;
height: 3.3rem;
font-weight: 300;
}

.thumb{
width: 100%;
padding-bottom: 100%;
margin: 0 auto;
background-size: cover;
background-position: center;
}

.btn-basic:hover{
	animation: gradient 3s linear infinite;
}

@keyframes gradient {
  0% { color: #6ECCAF }
  20% { color: #ADE792 }
  40% { color: #ADE792 }
  80% { color: #E9FFC2 }
  90% { color: #FDFFAF }
  100% { color: #6ECCAF }
}

@media (max-width: 1024px){
.card-wrapper{
grid-template-columns: 1fr 1fr;
}
}

@media (max-width: 768px){
.card-wrapper{
grid-template-columns: 1fr;
padding: 1rem 2rem;
gap: 3rem;
}

</style>
</head>

<body>
	<%@include file="../common/header.jsp"%>

	<div class="contents">
	<div class="form-wrapper">
		<h1>매거진</h1>
	</div>
		<div class="container">
		<h2>뉴스</h2>
		<div class="card-wrapper">
	<c:forEach var="board" items="${newslist}">
		<div class="card"><div class="thumb" style="background-image: url(<%=context%>/assets/img/${board.file_path})"></div><label>${board.title}</label><p>${board.content}</p><button class="btn-basic" onclick="window.open('${board.link}')">더 알아보기</button></div>
	</c:forEach>
		</div>
		<hr>
		<h2>이벤트</h2>
		<div class="card-wrapper">
	<c:forEach var="board" items="${eventslist}">
		<div class="card"><div class="thumb" style="background-image: url(<%=context%>/assets/img/${board.file_path})"></div><label>${board.title}</label><p>${board.content}</p><button class="btn-basic" onclick="window.open('${board.link}')">더 알아보기</button></div>
	</c:forEach>
		</div>
		<hr>
		<h2>칼럼</h2>
		<div class="card-wrapper">
	<c:forEach var="board" items="${columnslist}">
		<div class="card"><div class="thumb" style="background-image: url(<%=context%>/assets/img/${board.file_path})"></div><label>${board.title}</label><p>${board.content}</p><button class="btn-basic" onclick="window.open('${board.link}')">더 알아보기</button></div>
	</c:forEach>
		</div>
		</div>
	</div>

	<%@include file="../common/footer.jsp"%>

</body>
</html>