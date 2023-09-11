<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>글 수정 | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 768px;
}

.table {
	vertical-align: middle;
}

table td:nth-child(1) {
	width: 20%;
	font-weight: bold;
}
</style>
</head>


<body>
	<%@ include file="../common/header.jsp"%>

	<div class="container">
		<h2>글 수정하기</h2>
		<div class="form-wrapper">
			<form name="boardUpdate" method="post" enctype="multipart/form-data"
				action="<%=context%>/board/updateOk.do">
                <input type='hidden' name='bno' value='${board.bno}'/>
<!-- 글 번호 실제 데이터 전송!!!!이거때문에 수정 안되던거였음 -->
				<table class="table table-board table-hover">
					<tr>
						<td>글 번호</td>
						<td style="text-align: left;">${board.bno}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td style="text-align: left;">${board.regdate}</td>
					</tr>
					<tr>
						<td style="width: 20%; min-width: 140px;">썸네일</td>
						<td style="text-align: left;"><input class="form-control"
							type="file" name="file" maxlength="260"></td>
					</tr>

					<tr>
						<td>작성자</td>
						<td><input class="form-control" type="text" name="writer"
							maxlength=10 value="${board.writer}"></td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td><select class="form-select" name="category">
								<option value="news"
									${board.category == 'news' ? 'selected' : ''}>뉴스</option>
								<option value="events"
									${board.category == 'events' ? 'selected' : ''}>이벤트</option>
								<option value="columns"
									${board.category == 'columns' ? 'selected' : ''}>칼럼</option>
						</select></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input class="form-control" type="text" name="title"
							maxlength=45 value="${board.title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" rows="4" name="content"
								style="min-height: 5.4rem; max-height: 30rem;">${board.content}</textarea>
						</td>
					</tr>
					<tr>
						<td>더 알아보기 링크</td>
						<td><input class="form-control" type="text" name="link"
							maxlength=260 value="${board.link}"></td>
					</tr>
				</table>

				<div class="form-button-wrapper" style="text-align: center;">
					<span class="btn-basic btn-line-basic" onclick="history.back()">수정
						취소</span> <input type="submit" class="btn-basic" value="수정하기">
				</div>
			</form>
			<div class="form-button-wrapper" style="text-align: center;">
				<button class="btn-basic btn-line-basic"
					onclick="location.href='<%=context%>/board/list.do'">글 목록
					보기</button>
			</div>

		</div>

	</div>
	<%@ include file="../common/footer.jsp"%>
</body>

</html>
