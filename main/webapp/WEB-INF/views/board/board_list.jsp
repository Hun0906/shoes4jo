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
.form-wrapper{
	max-width: 100%;
}

.pagination{
    justify-content: center
}

.page-link{
color: #6ECCAF;
}

.page-link:hover{
background: white;
filter: brightness(95%);
}
</style>
</head>

<body>
	<%@include file="../common/header.jsp"%>
	
	<div class="container">
	<div class="form-wrapper">
		<h2>게시판</h2>
		<div style="display: flex; justify-content: space-between; margin: 1rem 0;">
			<select class="form-select" style="width: fit-content"
				onchange="window.open(value,'_self')">
				<option value="">카테고리 선택</option>
				<option value="list.do">전체 글 보기</option>
				<option value="list.do?category=news">뉴스</option>
				<option value="list.do?category=events">이벤트</option>
				<option value="list.do?category=columns">칼럼</option>
			</select> <input type="button" class="btn-basic" value="글쓰기" id="writeBtn"
				onclick="location.href='<%=context%>/board/write.do'">
		</div>

		<!-- 검색 창 -->
		<div style="margin-bottom: 1rem;">
			<form action="list.do" method="get" style="display: flex;">
            <input type="text" name="searchValue" placeholder="검색어를 입력해주세요" value="${param.searchValue}" style="margin-right: 0.5rem;">
            <select name="searchType" style="margin-right: 0.5rem;">
                <option value="title" ${param.searchType == 'title' ? 'selected' : ''}>제목</option>
                <option value="content" ${param.searchType == 'content' ? 'selected' : ''}>내용</option>
                <option value="writer" ${param.searchType == 'writer' ? 'selected' : ''}>작성자</option>
            </select>
            <input type="submit" value=" 검색 ">
			</form>
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
<c:choose>
    <c:when test="${empty list}">
        <tr>
            <td colspan="6" class="text-center">검색 결과가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="board" items="${list}" varStatus="status">
							<tr>
								<td class="text-center">${board.bno}</td>
								<td class="text-center">${board.category}</td>
								<td class="text-center"><a
									href="<%=context %>/board/view.do?bno=${board.bno}">${board.title}</a></td>
								<td class="text-center">${board.writer}</td>
								<td class="text-center">${board.viewcnt}</td>
								<td class="text-center">${board.regdate.substring(0,16)}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<!-- pageInfo 확인 -->
				<tr>
					<td colspan="6">
						<h3>pageInfo 확인(테스트용)</h3>
						<p>currentPage: ${pageInfo.currentPage}<br>
						start: ${pageInfo.start}<br>
						end: ${pageInfo.end}<br>
						prevPage: ${pageInfo.prevPage}<br>
						nextPage: ${pageInfo.nextPage}</p>
					</td>
				</tr>
			</tfoot>
		</table>
		<!-- 페이지네이션 -->
		<div class="form-button-wrapper">
	<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="list.do?page=${pageInfo.prevPage}${param.category != null ? '&category=' + param.category : ''}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${pageInfo.start}" end="${pageInfo.end}" step="1" varStatus="status">
		<c:choose>
			<c:when test="${status.index + pageInfo.start -1 == pageInfo.currentPage}">
				<li class="page-item"><span class="page-link current">${status.index + pageInfo.start - 1}</span></li>
			</c:when>
			<c:otherwise>
			    <li class="page-item"><a class="page-link" href="list.do?page=${status.index + pageInfo.start}&${param.category != null ? 'category=' + param.category : '' }">
			    ${status.index + pageInfo.start - 1}
			    </a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach> 
    <li class="page-item">
      <a class="page-link" href="list.do?page=${pageInfo.nextPage}${param.category != null ? '&category=' + param.category : ''}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
		</div>
	</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>
