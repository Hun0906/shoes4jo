<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
img{
width: 100%;
}

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


.btn-basic:hover{
	background: linear-gradient(160deg, 
	#000000aa 0%, 
	#6ECCAFaa 12%, 
	#ADE792aa 14%, 
	#ADE792aa 15%, 
	#E9FFC2aa 19%, 
	#FDFFAFaa 21%, 
	#000000aa 34%);
	background-color: black;
	background-size: 500% 100%;
	animation: gradient-move 10s linear infinite;
}

@keyframes gradient-move {
  0% {
    background-position: 100% 50%;
  }
  10% {
    background-position: 0% 50%;
  }
  15% {
    background-position: -50% 0%;
  }
  100% {
    background-position: -50% 0%;
  }
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
}
}
</style>
</head>

<body>
	<%@include file="../common/header.jsp"%>

	<div class="contents">
		<div class="container">
		<h2>뉴스</h2>
		<div class="card-wrapper">
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>제목 예시입니다 길어지면 말줄임표 생김</label><p>본문 텍스트 예시입니다. 이건 두 줄 이상 길어지면 말줄임표가 생깁니다. 더 자세한 내용은 더 알아보기 버튼을 클릭하세요. 창 너비에 따라 표시되는 텍스트의 양은 달라질 수 있습니다.</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		</div>
		<hr>
		<h2>이벤트</h2>
		<div class="card-wrapper">
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		</div>
		<hr>
		<h2>칼럼</h2>
		<div class="card-wrapper">
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		<div class="card"><img src="<%=context%>/assets/img/default.jpg"><label>Subject</label><p>Contents lines</p><button class="btn-basic">더 알아보기</button></div>
		</div>
		</div>
	</div>

	<%@include file="../common/footer.jsp"%>

</body>
</html>