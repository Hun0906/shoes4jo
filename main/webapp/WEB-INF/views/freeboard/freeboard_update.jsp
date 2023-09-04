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
			<form name="freeboardUpdate" method="post" enctype="multipart/form-data"
				action="<%=context%>/freeboard/updateOk.do">
                <input type='hidden' name='fno' value='${freeboard.fno}'/>
<!-- 글 번호 실제 데이터 전송!!!!이거때문에 수정 안되던거였음 -->
				<table class="table table-freeboard table-hover">
					<tr>
						<td>글 번호</td>
						<td style="text-align: left;">${freeboard.fno}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td style="text-align: left;">${freeboard.date}</td>
					</tr>
					<tr>
						<td style="width: 20%; min-width: 140px;">썸네일</td>
						<td style="text-align: left;"><input class="form-control"
							type="file" name="file" maxlength="260"></td>
					</tr>

					<tr>
						<td>작성자</td>
						<td><input class="form-control" type="text" name="member_id"
							maxlength=10 value="${freeboard.member_id}"></td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td><select class="form-select" name="category">
								<option value="정보"
									${freeboard.category == '정보' ? 'selected' : ''}>정보</option>
								<option value="구입 후기"
									${freeboard.category == '구입 후기' ? 'selected' : ''}>구입 후기</option>
								<option value="중고 거래"
									${freeboard.category == '중고 거래' ? 'selected' : ''}>중고 거래</option>
						</select></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input class="form-control" type="text" name="title"
							maxlength=45 value="${freeboard.title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" rows="4" name="content"
								style="min-height: 5.4rem; max-height: 30rem;">${freeboard.content}</textarea>
						</td>
					</tr>
				</table>

				<div class="form-button-wrapper" style="text-align: center;">
					<span class="btn-basic btn-line-basic" onclick="history.back()">수정
						취소</span> <input type="submit" class="btn-basic" value="수정하기">
				</div>
			</form>
			<div class="form-button-wrapper" style="text-align: center;">
				<button class="btn-basic btn-line-basic"
					onclick="location.href='<%=context%>/freeboard/list.do'">글 목록
					보기</button>
			</div>

		</div>

	</div>
	<%@ include file="../common/footer.jsp"%>
</body>

</html>
