<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<style>
.form-wrapper{
max-width: 768px;
}

.table{
vertical-align: middle;
}

.thumb img{
width: 50%;
min-width: 400px;
margin: 1rem 0;
}

table td:nth-child(1){
width: 20%;
font-weight: bold;}
table td:nth-child(2){
text-align:left;}
</style>
<script>
function checkDelete(bno){
    var remove = confirm("글을 삭제하시겠습니까?");

    if(remove) {
        location.href = '<%=context%>/board/delete.do?bno=' + bno;
    }
}
</script>
</head>

<body>
    <%@include file="../common/header.jsp"%>
    <div class="container">
        <div class="form-wrapper">
        <div style="display: flex; justify-content: space-between;"><div><b>카테고리</b> ${board.category}</div><div><b>번호</b> ${board.bno}</div></div>
        <h2>${board.title }</h2>
        <div style="display: flex; justify-content: space-between;"><div><b>작성자</b> ${board.writer}</div></div>
        <div style="display: flex; justify-content: space-between;"><div><b>작성일</b> ${board.regdate}</div><div><b>조회수</b> ${board.viewcnt}</div></div>
        <div class="thumb"><img src="<%=context%>/assets/img/${board.thumb}"></div>

<p>${board.content}</p>
<a href="${board.link}">더 알아보기</a>

<hr>

                    <div class="form-button-wrapper">
                        <button class="btn-basic" onclick="location.href='<%=context%>/board/update.do?bno=${board.bno }'">수정하기</button>
                    </div>
                    <div class="form-button-wrapper">
                        <button class="btn-basic btn-line-basic" onclick="location.href='<%=context%>/board/list.do'">글 목록 보기</button>
                        <button class="btn-basic btn-line-red" onclick="checkDelete(${board.bno})">삭제하기</button>
                    </div>
    </div>
</div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>
