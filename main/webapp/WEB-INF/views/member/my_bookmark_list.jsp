<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark_list | SHOES4JO</title>



<%@include file="../common/header-head.jsp"%>

</head>

<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
	<h1>나의 북마크 목록</h1>
		<h2 class="text-center">즐겨찾기</h2>
		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th class="text-center">상품 번호</th>
					<th class="text-center">상품 키워드</th>
					<th class="text-center">북마크 등록일</th>
					<th class="text-center">바로가기</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="bookmark" items="${bookmark_list}">
					<tr>
						<td class="text-center">${bookmark.gno}</td>
						<td class="text-center">${bookmark.keyword}</td>
						<td class="text-center">${bookmark.add_date.substring(0,11)}</td>
						<td class="text-center"><a
							href="${pageContext.request.contextPath}/goodscon/view.do?keyword=${bookmark.keyword}">
								바로가기 </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
					<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a class="page-link"
						href="<%=context %>/bookmark/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="idx">
					<c:choose>
						<c:when test="${idx eq pageMaker.cri.page}">
							<li class="active"><a class="page-link"
								href="<%=context %>/bookmark/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="page-link"
								href="<%=context %>/bookmark/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a class="page-link"
						href="<%=context %>/bookmark/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
				</c:if>
			</ul>
			
	<%@include file="../common/footer.jsp"%>
</body>
</html>
