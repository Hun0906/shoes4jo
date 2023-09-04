<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랭킹 | SHOES4JO</title>

<%@include file="../common/header-head.jsp"%>

</head>

<body>

	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h2 class="text-center">키워드별 검색 순위</h2>
	</div>

	<table class="table table-ranking table-hover">
		<thead>
			<tr>
				<th class="text-center">키워드</th>
				<th class="text-center">건수</th>
				<th class="text-center">랭킹</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="ranking" items="${list}" varStatus="status">
				<tr>
					<td class="text-center">
						<!-- 키워드 클릭하면 해당 상품의 상세 정보 페이지로 이동 --> <a
						href="${pageContext.request.contextPath}/goodscon/view.do?keyword=${ranking.keyword}">
							${ranking.keyword} </a>
					</td>
					<td class="text-center">${ranking.cnt}</td>
					<td class="text-center">${ranking.ranking}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<%@include file="../common/footer.jsp"%>
</body>
</html>
