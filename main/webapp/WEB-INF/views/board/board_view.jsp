<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>${board.title.length() > 10 ? board.title.substring(0, 10).concat("...") : board.title} | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=context%>/assets/css/board_view.css">

<script>
        function checkDelete(bno) {
            var remove = confirm("글을 삭제하시겠습니까?");
            if (remove) {
                location.href = '<%=context%>/board/delete.do?bno=' + bno;
            }
        }
    </script>
</head>

<body>
	<%@ include file="../common/header.jsp"%>
	<div class="container">
		<div class="form-wrapper">
			<div style="display: flex; justify-content: space-evenly;">
				<a href="<%=context%>/board/list.do?category=${board.category}"
					style="font-size: 1.2rem;"><b>${board.category}</b></a>
			</div>
			<p style="font-size: 2.2rem; margin-top: 1.5rem; font-weight: 500;">${board.title}</p>
			<div style="display: flex; justify-content: space-between; color: #999">
				<div>
					<b>작성자</b> ${board.writer}
				</div>
				<div>${board.viewcnt} Views | ${board.regdate.substring(0, 10)}</div>
			</div>

			<div class="line"></div>

			<div class="content" style="padding: 0 2rem; line-height: 1.8;">
			<div class="thumb">
				<c:if test="${board.file_path != null && not empty board.file_path}">
					<img src="<%=context%>/assets/img/${board.file_path}" onerror="this.src='<%=context%>/assets/img/default.jpg'">
				</c:if>
			</div>
			</div>

			<p>${board.content}</p>

			<div class="form-button-wrapper">
				<button class="btn-basic btn-color1"
					onclick="window.open('${board.link}')">👟더 알아보기</button>

			</div>


		<div class="line"></div>

		<div class="form-button-wrapper">
			<span class="btn-basic btn-line-red"
				onclick="checkDelete(${board.bno})">삭제하기</span>
			<button class="btn-basic"
				onclick="location.href='<%=context%>/board/update.do?bno=${board.bno}'">수정하기</button>
		</div>
		<div class="form-button-wrapper">
			<button class="btn-basic btn-line-basic"
				onclick="location.href='<%=context%>/board/list.do'">글 목록
				보기</button>
		</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>

</html>
