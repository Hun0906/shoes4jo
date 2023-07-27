<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%String context = ((HttpServletRequest)request).getContextPath(); %>

<link href="<%=context %>/css/main.css" rel="stylesheet">
<link href="<%=context %>/css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Noto+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

<header>
<img src="../repo/logo01.svg" style="width: 100%; padding: 1rem;" onclick="location.href='/'">
<div class="menu_container">
<a href="/">메인</a>
<a href="chart.jsp">차트 예시</a>
<a href="keyword_trend.jsp">상품별 트렌드</a>
<a href="category_trend.jsp">카테고리별 트렌드</a>
</div>
<div>메뉴</div>


</header>