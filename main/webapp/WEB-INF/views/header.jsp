<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>
<img src="<%=context %>/assets/img/logo01.svg" style="width: 100%; padding: 1rem;" onclick="location.href='<%=context %>/'">
<div class="menu_container">
<a href="<%=context %>/">메인</a>
<a href="keyword_trend">상품별 트렌드</a>
<a href="category_trend">카테고리별 트렌드</a>
</div>

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
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1" style="">
    <li><a class="dropdown-item menu-visitor" onclick="location.href='login'">로그인</a></li>
    <li><a class="dropdown-item menu-visitor" onclick="location.href='signup'">회원가입</a></li>
    <li><a class="dropdown-item menu-member" onclick="location.href='mypage'">마이페이지</a></li>
    <li><a class="dropdown-item menu-member" onclick="location.href='logout'">로그아웃</a></li>
  </ul>
</div>

</header>