<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>

<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<h2 class="text-center">회원 목록</h2>
		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th class="text-center">회원 아이디</th>
					<th class="text-center">회원 이름</th>
					<th class="text-center">가입일</th>
					<th class="text-center">회원 이메일</th>
					<th class="text-center">회원 연락처</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="member" items="${member_list}">
					<tr>
						<td class="text-center">${member.member_id }</td>
						<td class="text-center"><a
							href="<%=context %>/controller/showMember?member_id=${member.member_id}">${member.member_name}
						</a></td>
						<td class="text-center">${member.signup_date.substring(0,11)}</td>
						<td class="text-center">${member.member_email}</td>
						<td class="text-center">${member.member_phone}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>



	<ul class="pagination">

		<c:if test="${pageMaker.prev}">
			<li><a class="page-link"
				href="<%=context %>/controller/showMember${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		</c:if>


		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
			var="idx">
			<c:choose>
				<c:when test="${idx eq pageMaker.cri.page}">
					<li class="active"><a class="page-link"
						href="<%=context %>/controller/showMember${pageMaker.makeQuery(idx)}">${idx}</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="page-link"
						href="<%=context %>/controller/showMember${pageMaker.makeQuery(idx)}">${idx}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>


		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a class="page-link"
				href="<%=context %>/controller/showMember${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		</c:if>

	</ul>


	<%@include file="../common/footer.jsp"%>
</body>
</html>
