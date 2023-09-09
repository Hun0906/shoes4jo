<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p style="text-align: center; margin: 0; padding: var(- -bs-dropdown-item-padding-y) var(- -bs-dropdown-item-padding-x); cursor: default;">
<%=sessionID %>	전용<br>관리 페이지</p>
<hr class="menu-member" style="margin: 0.6rem 0;">
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/showMember'">👥가입자 리스트</a></li> 
<li><a class="dropdown-item" onclick="location.href='<%=context%>/goodscon/list.do'">🥾등록 상품 관리</a></li> 
<li><a class="dropdown-item" onclick="location.href='<%=context%>/board/list.do'">📚매거진 관리</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/save/trend_save'">🛒트렌드 데이터 추출</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/logout'">🔑로그아웃</a></li> 
