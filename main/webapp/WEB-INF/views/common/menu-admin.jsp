<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p style="text-align: center; margin: 0; padding: var(- -bs-dropdown-item-padding-y) var(- -bs-dropdown-item-padding-x); cursor: default;">
<%=sessionID %>	전용<br>관리 페이지</p>
<hr class="menu-member" style="margin: 0.6rem 0;">
<li><a class="dropdown-item" onclick="location.href='<%=context%>/member_list'">가입자 리스트</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/board_list'">게시판 관리</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/logout'">로그아웃</a></li>