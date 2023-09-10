<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p style="text-align: center; margin: 0; padding: var(- -bs-dropdown-item-padding-y) var(- -bs-dropdown-item-padding-x); cursor: default;">
	반가워요🙌<br><%=sessionID %>님!</p>
<hr style="margin: 0.6rem 0;">
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/memberInfo'">👤마이페이지</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/bookmarkcon/list.do'">❤️북마크</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/freeboard/myBoardList.do'">✏️내 게시글</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/comment/myCommentList.do'">💬내 댓글</a></li>
<li><a class="dropdown-item" onclick="location.href='<%=context%>/controller/logout'">🔑로그아웃</a></li>