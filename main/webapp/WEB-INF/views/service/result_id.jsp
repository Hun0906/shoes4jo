<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<head>
<title>아이디 찾기 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<style>
.search-wrapper b{
	font-size: 2.5rem;
}
</style>
</head>

<body>
	<%@include file="../common/header.jsp"%>

	<div class="form-wrapper">
		<h1>계정 찾기</h1>

		<h2>아이디 찾기</h2>
		<div class="search-wrapper">

			<c:choose>
				<c:when test="${empty searchVO}">
					<b>입력된 정보로 가입된 계정이 없습니다.</b>
				</c:when>
				<c:otherwise>
					<b>${searchVO.member_id}</b>
				</c:otherwise>
			</c:choose>

		</div>
	<div class="form-button-wrapper">
		<button class="btn-basic" onclick="location.href='login'">로그인</button>
		<span class="btn-basic btn-line-basic" onclick="location.href='signup'">가입하기</span>
	</div>
	</div>

	<%@include file="../common/footer.jsp"%>
</body>
</html>
