<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_view | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<style>
    .button-group {
        text-align: center;
        margin-top: 1rem;
    }
    .button-group .btn-basic {
        margin: 0 0.5rem;
    }
    th, td { 
        text-align: center;
    }
    .content-title {
        font-weight: bold;
    }
    .content-cell {
        white-space: pre-wrap;
    }
    .col-bno, .col-writer, .col-regdate {
        width: 15%;
    }
</style>
<script>
function checkDelete(bno){
    var remove = confirm("삭제하시겠습니까?");

    if(remove) {
        location.href = '/board/delete.do?bno=' + bno;
    }
}
</script>
</head>

<body>
    <%@include file="../common/header.jsp"%>
    <div class="container">
        <h2>${board.title }</h2>
        <table class="table table-board table-hover">
            <tr>
                <th class="col-bno">번호</th>
                <td class="col-bno">${board.bno}</td>
                <th class="col-writer">작성자</th>
                <td class="col-writer">${board.writer}</td>
                <th class="col-regdate">등록일</th>
                <td class="col-regdate">${board.regdate}</td>
            </tr>

            <tr>
                <td colspan="6" class="content-title">내용</td>
            </tr>

            <tr>
                <td colspan="6" class="content-cell">${board.content }</td> 
            </tr>

            <tr>
                <td colspan="6">
                    <div class="button-group">
                        <button class="btn-basic"
                            onclick="location.href='/board/update.do?bno=${board.bno }'">수정하기</button>
                        <button class="btn-basic" onclick="location.href='/board/list.do'">목록보기</button>
                        <button class="btn-basic" onclick="checkDelete(${board.bno})">삭제하기</button>
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <%@include file="../common/footer.jsp"%>
</body>
</html>
