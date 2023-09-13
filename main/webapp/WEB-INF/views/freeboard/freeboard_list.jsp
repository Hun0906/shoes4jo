<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 | SHOES4JO</title>

<%@include file="../common/header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 100%;
}

.comment-num {
	color: gray;
	border-radius: 5px;
	padding: 0 0.3rem;
	font-size: 0.9rem;
	cursor: default;
}

.commnet-num svg {
	margin-right: 5px;
}
.board-search-wrapper button{
	padding: 0 1rem;
}
.board-search-wrapper select{
	width: fit-content;
}
.board-search-wrapper input{
	width: 16rem;
}
.board-search-wrapper{
    display: flex;
    justify-content: center;
    gap: 5px;
}
</style>
</head>

<body>

	<%@include file="../common/header.jsp"%>

	<div class="container">
		<div class="form_wrapper">
			<h1 onclick="location.href='<%=context%>/freeboard/list.do'">커뮤니티</h1>
			<h2>자유게시판</h2>
			<div
				style="display: flex; justify-content: space-between; margin: 1rem 0;">

				<select class="form-select" style="width: fit-content"
					onchange="window.location.href='<%=context%>/freeboard/category.do?category=' + this.value">
					<option value="">카테고리 선택</option>
					<option value="정보">정보</option>
					<option value="구매 후기">구매 후기</option>
					<option value="중고 거래">중고 거래</option>
				</select>

				<button onclick="location.href='<%=context%>/freeboard/write.do'"
					class="btn-basic">글쓰기</button>

			</div>

			<table class="table table-freeboard table-hover">
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th class="text-center">카테고리</th>
						<th class="text-center">제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">조회수</th>
						<th class="text-center">등록일</th>
						<th class="text-center">수정일</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="freeboard" items="${list}">
						<tr>
							<td class="text-center">${freeboard.fno }</td>
							<td class="text-center">${freeboard.category}</td>
							<td class="text-center"><a
								href="<%=context %>/freeboard/view.do?fno=${freeboard.fno}">${freeboard.title}</a>
								<c:if test="${freeboard.comment_cnt ne 0 }">
									<span class="comment-num"><svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-chat-left"
											viewBox="0 0 20 20">
  <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
</svg>${freeboard.comment_cnt}</span>
								</c:if></td>

							<td class="text-center">${freeboard.member_id}</td>
							<td class="text-center">${freeboard.viewcnt}</td>
							<td class="text-center">${freeboard.date.substring(0,16)}</td>
							<td class="text-center">${freeboard.update_date.substring(0,16)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>


			<!-- 검색창 -->
			<br>
				<form action="${pageContext.request.contextPath}/freeboard/list.do" method="get">
			<div class="board-search-wrapper">
					<select name="searchType" class="form-select">
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="member_id">작성자</option>
					</select> <input type="text" name="keyword" class="form-control">
					<button type="submit" class="btn-line-basic">검색</button>
			</div>
				</form>
			<br>
			<!-- 검색창 끝, 페이징 시작 -->


			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a class="page-link"
						href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
				</c:if>


				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="idx">
					<c:choose>
						<c:when test="${idx eq pageMaker.cri.page}">
							<li class="active"><a class="page-link"
								href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="page-link"
								href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>


				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a class="page-link"
						href="<%=context %>/freeboard/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
				</c:if>

			</ul>
		</div>
	</div>


	<%@include file="../common/footer.jsp"%>
</body>
</html>
