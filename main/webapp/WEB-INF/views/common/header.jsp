<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<!-- 반응형 메뉴 버튼 -->
<div class="dropdown" id="responsive-menu" style="display: none; cursor: pointer;" onclick="javascript:showResponsiveMenus();">
    <svg xmlns="http://www.w3.org/2000/svg" width="40" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16" style="height: auto;width: 40px;">
  <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"></path>
</svg>
</div>

<!-- 헤더 -->
<img src="<%=context %>/assets/img/logo01.svg" onclick="location.href='<%=context %>/'">
<div class="menu_container">
<a href="<%=context %>/main">상품별 트렌드</a>
<a href="<%=context %>/">분류별 트렌드</a>
<a href="<%=context %>/keyword_trend">키워드 트렌드</a>
<a href="<%=context %>/ranking.do">랭킹</a>
<a href="<%=context %>/word_cloud">연관 주제</a>
<a href="<%=context %>/freeboard/list.do">자유게시판</a>
<a href="<%=context %>/board/magazine">매거진</a>
</div>

<!-- 메뉴토글 -->
<div class="dropdown" style="
    text-align: right;
    margin-right: 1.5rem;
    cursor: pointer;
">
  <div onclick="javascript:menuToggle()" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
<svg xmlns="http://www.w3.org/2000/svg" width="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg>
  </div>
  <ul class="dropdown-menu" id="dropdown-menu" aria-labelledby="dropdownMenuButton1">

  </ul>
</div>
</header>

<div class="responsive-menu-wrapper">
<div><a href="<%=context %>/main">상품별 트렌드</a></div>
<div><a href="<%=context %>/">분류별 트렌드</a></div>
<div><a href="<%=context %>/keyword_trend">키워드 트렌드</a></div>
<div><a href="<%=context %>/ranking.do">랭킹</a></div>
<div><a href="<%=context %>/word_cloud">연관 주제</a></div>
<div><a href="<%=context %>/freeboard/list.do">자유게시판</a></div>
<div><a href="<%=context %>/board/magazine">매거진</a></div>
</div>

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
  
function showResponsiveMenus() {
	let menu = document.getElementsByClassName("responsive-menu-wrapper")[0];
	if (menu.style.display === "grid"){
		menu.style.display = "none";
	} else {
		menu.style.display = "grid";
	}
		console.log(menu.style.display);
}
</script>