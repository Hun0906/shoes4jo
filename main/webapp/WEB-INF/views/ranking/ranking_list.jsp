<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 | SHOES4JO</title>

<%@include file="../common/header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 100%;
}

.pagination {
	justify-content: center;
}

.page-link {
	color: #6ECCAF;
}

.page-link:hover {
	background: white;
	filter: brightness(95%);
}
</style>
</head>

<body>

	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h2 class="text-center">랭킹</h2>


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

				<c:choose>
					<c:when test="${empty list}">
						<tr>
							<td colspan="6" class="text-center">검색 결과가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>

						<c:forEach var="ranking" items="${list}" varStatus="status">
							<tr>
								<td class="text-center">${ranking.keyword }</td>
								<td class="text-center">${ranking.cnt}</td>
								<td class="text-center">${ranking.ranking}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

	</div>

<%-- 	<div>
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a class="page-link"
					href="/board/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a class="page-link"
					href="/board/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && page_maker.end_page > 0}">
				<li><a class="page-link"
					href="/board/list.do${page_maker.make_query(page_maker.end_page + 1)}">다음</a></li>
			</c:if>

		</ul>
	</div>
 --%>

	<%@include file="../common/footer.jsp"%>
</body>
</html>
