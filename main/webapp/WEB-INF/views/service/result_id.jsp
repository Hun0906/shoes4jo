<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha384-KyZXEAg3QhqLMpG8r+KnujslD/7++XK0KzbQzUP2q0U11fdsojspornfooONU65"
	crossorigin="anonymous"></script>
<title>result_id | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
</head>

<body class="bg-gradient-primary">
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<!-- Outer Row -->
		<div class="row justify-content-center">
			<div class="col-xl-10 col-lg-12 col-md-9">
				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-password"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-2">아이디를 확인해주세요.</h1>
										<br>
										<br>
										<c:choose>
											<c:when test="${empty searchVO}">
												<p class="mb-4">조회결과가 없습니다.</p>
											</c:when>
											<c:otherwise>
												<p class="mb-4">${searchVO.member_id}</p>
											</c:otherwise>
										</c:choose>
									</div>
									<hr>
									<div class="text-center">
										<a class="small" href="search_id">아이디 찾기</a>
									</div>
									<div class="text-center">
										<a class="small" onclick="location.href='insertMember'">회원가입
											하기</a>
									</div>
									<div class="text-center">
										<a class="small" onclick="location.href='login'">로그인 하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
	<script>
		var path = "${pageContext.request.contextPath}";

		$(document).ready(function() {
		});
	</script>
</body>
</html>
