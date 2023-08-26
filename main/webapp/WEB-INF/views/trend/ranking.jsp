<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품별 트렌드 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>
<body>
	<%@include file="../common/header.jsp"%>

<div class="container" style="text-align: center;">
<h1>키워드 랭킹</h1>
<div style="display: grid; grid-template-columns: 1fr 1fr 1fr; gap: 5px;">
<div style="background-color: #ccc; border-radius: 10px; height: 30rem;" class="card">일간</div>
<div style="background-color: #ccc; border-radius: 10px; height: 30rem;" class="card">주간</div>
<div style="background-color: #ccc; border-radius: 10px; height: 30rem;" class="card">월간</div>
</div>
</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>