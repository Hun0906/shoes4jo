<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키워드 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.container {
	text-align: center;
}

.header {
	text-align: center;
    margin-bottom: 1rem;
}

h2 {
	margin: 0 auto;
}

.header span {
	font-size: 1.6rem;
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
}

.list-wrapper li:hover{
    background: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #e9ffc2 90%, #fdffae 100%);
    color: white;
    font-weight: 500;
    cursor: default;
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

.brand-ul{
display: none;
}

.kind-ul{
display: none;
}

.contents{
display: grid;
grid-template-columns: repeat(2, 1fr);
grid-gap: 5rem;
max-width: 1024px;
margin: auto;
}

@media (max-width: 1024px){
.contents{
grid-template-columns: 1fr;
}
}

@media (max-width: 600px){
.contents{
padding: 0 2rem;
}
}
</style>

</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h1>키워드 트렌드</h1>
		<div class="contents">

			<div class="subject">
				<div class="header">
					<h2>SHOES4JO</h2>
					<span>추천 상품</span>
				</div>
				<div class="list-wrapper" id="shoes4jo">
				<ul>
					<c:forEach var="keywords" items="${shoes4jo}">
					<li>${keywords}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>신발</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list-wrapper" id="shoes">
				<ul>
					<c:forEach var="keywords" items="${shoes}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="kind-selector">
						<select onchange="javascript:selectKind(this.value);">
							<option value="runningshoes">운동화</option>
							<option value="slipper">슬리퍼</option>
							<option value="sneakers">스니커즈</option>
							<option value="slipon">슬립온</option>
							<option value="trakingshoes">등산화</option>
							<option value="sandal">샌들</option>
							<option value="boots">부츠</option>
						</select>
					</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list-wrapper" id="kind">
				<ul class="kind-ul" id="runningshoes">
					<c:forEach var="keywords" items="${runningshoes}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="slipper">
					<c:forEach var="keywords" items="${slipper}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="sneakers">
					<c:forEach var="keywords" items="${sneakers}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="slipon">
					<c:forEach var="keywords" items="${slipon}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="trakingshoes">
					<c:forEach var="keywords" items="${trakingshoes}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="sandal">
					<c:forEach var="keywords" items="${sandal}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="kind-ul" id="boots">
					<c:forEach var="keywords" items="${boots}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="brand-selector">
						<select onchange="javascript:selectBrand(this.value);">
							<option value="nike">나이키</option>
							<option value="adidas">아디다스</option>
							<option value="newbalance">뉴발란스</option>
							<option value="drmartin">닥터마틴</option>
							<option value="asics">아식스</option>
							<option value="leebok">리복</option>
							<option value="crocs">크록스</option>
							<option value="canvas">컨버스</option>
							<option value="vans">반스</option>
							<option value="sketchers">스케쳐스</option>
						</select>
					</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list-wrapper" id="brand">
				<ul class="brand-ul" id="nike">
					<c:forEach var="keywords" items="${nike}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="adidas">
					<c:forEach var="keywords" items="${adidas}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="newbalance">
					<c:forEach var="keywords" items="${newbalance}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="drmartin">
					<c:forEach var="keywords" items="${drmartin}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="asics">
					<c:forEach var="keywords" items="${asics}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="leebok">
					<c:forEach var="keywords" items="${leebok}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="crocs">
					<c:forEach var="keywords" items="${crocs}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="canvas">
					<c:forEach var="keywords" items="${canvas}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="vans">
					<c:forEach var="keywords" items="${vans}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				
				<ul class="brand-ul" id="sketchers">
					<c:forEach var="keywords" items="${sketchers}">
					<li>${keywords.query}</li>
					</c:forEach>
				</ul>
				</div>
			</div>

		</div>
	</div>
	
	<%@include file="../common/footer.jsp"%>
	
<script>
document.addEventListener('DOMContentLoaded', () => {
	let kindArray = ["runningshoes","slipper","sneakers","slipon","trakingshoes","sandal","boots"];
	let firstKind = kindArray[Math.floor(Math.abs(Math.random()*kindArray.length))];
	selectKind(firstKind);
	document.getElementsByClassName("kind-selector")[0].children[0].value = firstKind;
	
	let brandArray = ["nike","adidas","newbalance","drmartin","asics","leebok","crocs","canvas","vans", "sketchers"];
	let firstBrand = brandArray[Math.floor(Math.abs(Math.random()*brandArray.length))];
	selectBrand(firstBrand);
	document.getElementsByClassName("brand-selector")[0].children[0].value = firstBrand;

	Array.from(document.getElementsByTagName("ul")).forEach(v => {
		Array.from(v.children).forEach((e, i) => { 
			let bTag = document.createElement('b');
			bTag.innerHTML = i + 1;
			e.prepend(bTag);
			e.style.animation = "fadeIn " + (i+1)/7 + "s ease-in-out";
		});
	});
});



function selectKind(value){
	console.log(value);
	Array.from(document.getElementsByClassName("kind-ul")).forEach(e=>e.style.display = "none");
	document.getElementById(value).style.display = "block";
}

function selectBrand(value){
	console.log(value);
	Array.from(document.getElementsByClassName("brand-ul")).forEach(e=>e.style.display = "none");
	document.getElementById(value).style.display = "block";
}

</script>
</body>
</html>