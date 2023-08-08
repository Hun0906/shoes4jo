<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String context = ((HttpServletRequest)request).getContextPath(); 
String sessionID = (String) session.getAttribute("memberInfo");
%>

<!-- 스타일시트 -->
<link href="<%=context %>/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=context %>/assets/css/main.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Noto+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

<!-- 기능 라이브러리 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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