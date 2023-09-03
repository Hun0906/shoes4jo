<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색어 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.container {
	text-align: center;
}

.header {
	text-align: center;
}

h2 {
	margin: 0 auto;
}

.header span {
	font-size: 1.6rem;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h1>키워드 트렌드</h1>
		<div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 3rem;">

			<div class="subject">
				<div class="header">
					<h2>SHOES4JO</h2>
					<span>추천 상품</span>
				</div>
				<div class="list" id="shoes4jo">
				<ul>
					<c:forEach><li>${}</li></c:forEach>
				</ul>
				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2>신발</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="shoes">

				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="select-shoes">운동화</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="kind">

				</div>
			</div>

			<div class="subject">
				<div class="header">
					<h2 class="select-shoes">나이키</h2>
					<span>인기 키워드</span>
				</div>
				<div class="list" id="brand">

				</div>
			</div>

		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>