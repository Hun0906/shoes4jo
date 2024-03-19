<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매거진 관리 | SHOES4JO</title>

<%@include file="../common/header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 100%;
}
.basic {
    background-color: white;
    color: black;
}
.search-container {
  display: flex;
  justify-content: center;
}
</style>
</head>

<body>

	<%@include file="../common/header.jsp"%>

	<div class="container">
		<h2 class="text-center">
			<a href="${context}/board/list.do"
				style="text-decoration: none; color: inherit;">매거진 관리</a>
		</h2>

		<div
			style="display: flex; justify-content: space-between; margin: 1rem 0;">

			<select class="form-select" style="width: fit-content"
				onchange="window.location.href='<%=context%>/board/category.do?category=' + this.value">
				<option value="">카테고리 선택</option>
				<option value="news">뉴스</option>
				<option value="events">이벤트</option>
				<option value="columns">칼럼</option>
			</select>

			<button onclick="location.href='<%=context%>/board/write.do'"
				class="btn-basic">글쓰기</button>

		</div>



		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">카테고리</th>
					<th class="text-center">제목</th>
					<th class="text-center">작성자</th>
					<th class="text-center">조회수</th>
					<th class="text-center">등록일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="board" items="${list}">
					<tr>
						<td class="text-center">${board.bno }</td>
						<td class="text-center">${board.category}</td>
						<td class="text-center"><a
							href="<%=context %>/board/view.do?bno=${board.bno}">${board.title}
						</a></td>
						<td class="text-center">${board.writer}</td>
						<td class="text-center">${board.viewcnt}</td>
						<td class="text-center">${board.regdate.substring(0,16)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>




		<!-- 검색창 -->
<br>
<div class="search-container">
	<form action="${pageContext.request.contextPath}/board/list.do" method="get">
		<select name="searchType">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select> 
        <input type="text" name="keyword">
        <button type="submit" class="basic">검색</button>
    </form>
</div>
<br>
		<!-- 검색창 끝, 페이징 시작 -->


		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a class="page-link"
					href="<%=context %>/board/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<c:choose>
					<c:when test="${idx eq pageMaker.cri.page}">
						<li class="active"><a class="page-link"
							href="<%=context %>/board/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
					</c:when>
					<c:otherwise>
						<li><a class="page-link"
							href="<%=context %>/board/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a class="page-link"
					href="<%=context %>/board/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>

		</ul>
	</div>
	<!-- 페이징 끝 -->

	<%@include file="../common/footer.jsp"%>
</body>
</html>
