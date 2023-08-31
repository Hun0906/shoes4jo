<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p style="text-align: center; margin: 0; padding: var(- -bs-dropdown-item-padding-y) var(- -bs-dropdown-item-padding-x); cursor: default;">
	반가워요🙌<br><%=sessionID %>님!</p>
<hr style="margin: 0.6rem 0;">
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/memberInfo'">👤마이페이지</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/bookmarkcon/list.do'">❤즐겨찾기</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/logout'">🔑로그아웃</a></li>