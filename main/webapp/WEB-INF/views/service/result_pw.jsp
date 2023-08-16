<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!DOCTYPE html>
<script>
	var path = "${pageContext.request.contextPath}";

	$(document).ready(function() {
	});
</script>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<title>search_result_pw | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
</head>

<body class="bg-gradient-primary">
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10 col-lg-12 col-md-9">
				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-2">임시 비밀번호가 발급되었습니다.</h1>
										<br>
										<br>
										<p class="mb-4">${newPw}</p>
									</div>
									<hr>
									<div class="text-center">
										<a class="small" href="/search_pw">비밀번호 찾기</a>
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
</body>
</html>
