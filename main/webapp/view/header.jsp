<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String context = ((HttpServletRequest)request).getContextPath(); 
String sessionID = (String) session.getAttribute("id");
%>

<!-- 스타일시트 -->
<link href="<%=context %>/assets/css/main.css" rel="stylesheet">
<link href="<%=context %>/assets/css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Noto+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<script src="<%=context %>/assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<!-- 기능 라이브러리 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script>
function menuToggle() {
	if ("<%=sessionID%>" == "null") {
		Array.from(document.getElementsByClassName('menu-member')).forEach(item => {
		    item.style.display = 'none';
		  });
		Array.from(document.getElementsByClassName('menu-visitor')).forEach(item => {
		    item.style.display = '';
		  });
	} else {
		Array.from(document.getElementsByClassName('menu-member')).forEach(item => {
		    item.style.display = '';
		  });
		Array.from(document.getElementsByClassName('menu-visitor')).forEach(item => {
		    item.style.display = 'none';
		  });
	}
}
</script>

<header>
<img src="<%=context %>/assets/img/logo01.svg" style="width: 100%; padding: 1rem;" onclick="location.href='<%=context %>/'">
<div class="menu_container">
<a href="/">메인</a>
<a href="chart.jsp">차트 예시</a>
<a href="keyword_trend.jsp">상품별 트렌드</a>
<a href="category_trend.jsp">카테고리별 트렌드</a>
</div>
<div onclick="javascript:menuToggle()" style="
    text-align: right;
    margin-right: 2rem;
    cursor: pointer;
" data-bs-toggle="dropdown" aria-expanded="false">
<svg xmlns="http://www.w3.org/2000/svg" width="40" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16" style="height: auto;width: 40px;">
  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"></path>
</svg>

  <ul class="dropdown-menu">
    <li><a class="dropdown-item menu-visitor" onclick="location.href='<%=context %>/view/login.jsp'">로그인</a></li>
    <li><a class="dropdown-item menu-visitor" onclick="location.href='<%=context %>/view/signup.jsp'">회원가입</a></li>
    <li><a class="dropdown-item menu-member" onclick="location.href='<%=context %>/view/mypage.jsp'">마이페이지</a></li>
    <li><a class="dropdown-item menu-member" onclick="location.href='<%=context %>/view/logout'">로그아웃</a></li>
  </ul>

</div>


</header>