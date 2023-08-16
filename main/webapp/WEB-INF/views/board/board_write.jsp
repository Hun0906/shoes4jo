<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

    
<meta charset="UTF-8">
<title>Board_write | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
</head>
<body>
    <%@include file="../common/header.jsp"%>

    <div class="container">
        <h2>글 작성</h2>
        <div class="write-form"> <!-- 수정: 글 작성폼에 클래스 추가 -->
            <form method="post" action="/board/writeOk.do">
                <table class="table table-board table-hover">
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" name="writer"></td>
                    </tr>


                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title"></td>
                    </tr>

                    <tr>
                        <td colspan="2">내용</td>
                    </tr>

                    <tr>
                        <td colspan="2"><textarea rows="10" cols="150" name="content"></textarea>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"><input class="btn-basic" type="submit" value="등록"><!-- 수정: btn-basic 클래스 추가 -->
                        </td>
                    </tr>
                </table>

            </form>

            <button class="btn btn-secondary" onclick="location.href = '/board/list.do'">목록으로 돌아가기<!-- 수정: btn-basic 클래스 추가 --></button>
        </div>

    </div>

    <%@include file="../common/footer.jsp"%>
</body>
</html>
