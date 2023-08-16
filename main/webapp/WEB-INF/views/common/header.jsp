<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<!-- 헤더 -->
<img src="<%=context %>/assets/img/logo01.svg" style="width: 100%; padding: 1rem;" onclick="location.href='<%=context %>/'">
<div class="menu_container">
<a href="<%=context %>/main">상품별 트렌드</a>
<a href="<%=context %>/">분류별 트렌드</a>
<a href="<%=context %>/">검색어 트렌드</a>
<a href="<%=context %>/ranking">랭킹</a>
<a href="<%=context %>/word_cloud">연관 주제</a>
<a href="<%=context %>/">시장 규모</a>
<a href="<%=context %>/magazine">매거진</a>
</div>

<!-- 메뉴토글 -->
<div class="dropdown" style="
    text-align: right;
    margin-right: 2rem;
    cursor: pointer;
">
  <div onclick="javascript:menuToggle()" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    <svg xmlns="http://www.w3.org/2000/svg" width="40" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16" style="height: auto;width: 40px;">
  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"></path>
</svg>
  </div>
  <ul class="dropdown-menu" id="dropdown-menu" aria-labelledby="dropdownMenuButton1">

  </ul>
</div>
</header>

<script>
function menuToggle() {
  	if ("<%=sessionID%>" == null || "<%=sessionID%>" == "null") {
  		document.getElementById("dropdown-menu").innerHTML = (`<%@ include file="menu-visitor.jsp" %>`);
  	} else if ("<%=sessionID%>" == "admin") {
  		document.getElementById("dropdown-menu").innerHTML = (`<%@ include file="menu-admin.jsp" %>`);
  	} else {
  		document.getElementById("dropdown-menu").innerHTML = (`<%@ include file="menu-member.jsp" %>`);
  	}
  }
</script>