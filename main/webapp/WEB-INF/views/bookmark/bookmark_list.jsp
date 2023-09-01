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
		<h2 class="text-center">북마크 목록</h2>
		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th class="text-center">상품 번호</th>
					<th class="text-center">키워드</th>
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
	<%@include file="../common/footer.jsp"%>
</body>
</html>
