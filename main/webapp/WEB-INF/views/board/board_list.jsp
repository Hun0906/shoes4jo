<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>

<body>
<%@include file="../common/header.jsp"%>
	<div class="container">
		<h2 class="text-center">게시판</h2>
		<div class="form-button-wrapper" style="text-align: right;">
		<input type="button" class="btn-basic" value="글쓰기" id="writeBtn"
						onclick="location.href='<%=context %>/board/write.do'">
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
						<td class="text-center"><a href="<%=context %>/board/view.do?bno=${board.bno}">${board.title} </a></td>
						<td class="text-center">${board.writer}</td>
						<td class="text-center">${board.viewcnt}</td>
						<td class="text-center">${board.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>
