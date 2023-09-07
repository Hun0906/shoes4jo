<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>새 글 작성 | SHOES4JO</title>
    <%@ include file="../common/header-head.jsp" %>

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
<%@ include file="../common/header.jsp" %>

<div class="container">
    <h2>글 작성하기</h2>
    <div class="form-wrapper">
        <form name="freeboardWriting" method="post" enctype="multipart/form-data" action="<%= context %>/freeboard/writeOk.do">
            <table class="table table-freeboard table-hover">
                <tr>
                    <td style="width: 20%; min-width: 140px;">썸네일</td>
                    <td><input class="form-control" type="file" name="file" value="default.jpg" maxlength="260"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input class="form-control" type="text" name="member_id" maxlength="10"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select class="form-select" name="category">
                            <option value="정보">정보</option>
                            <option value="구매 후기">구매 후기</option>
                            <option value="중고 거래">중고 거래</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input class="form-control" type="text" name="title" maxlength="45"></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea class="form-control" rows="4" name="content" style="min-height: 5.4rem; max-height: 30rem;">${freeboard.content}</textarea>
                    </td>
                </tr>

            </table>

            <div class="form-button-wrapper" style="text-align:center;">
                <span class="btn-basic btn-line-basic" onclick="location.href = '<%= context %>/freeboard/list.do'">글 목록 보기</span>
                <input class="btn-basic" type="submit" value="등록">
            </div>

        </form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
