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
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function loadImage(event) {
	  var reader = new FileReader();  
	  reader.onload = function() {
	    var thumb_img = document.getElementById("thumb_img");  
	    thumb_img.src = reader.result;
	  };
	  reader.readAsDataURL(event.target.files[0]);  
	}
</script>
    
    
</head>
<body>
<%@ include file="../common/header.jsp" %>

<div class="container">
    <h2>글 작성하기</h2>
    <div class="form-wrapper">
        <form name="boardWriting" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/board/writeOk.do">
            <table class="table table-board table-hover">
                <tr>
                    <td style="width: 20%; min-width: 140px;">썸네일</td>
<td>
    <input type="file" id="imageUpload" name="thumb_img" accept="/*" onchange="loadImage(event)" maxlength="255">
    <img id="thumb_img" src="/assets/img/default.jpg" alt="Thumbnail" width="200" height="200" style="margin-top: 10px;">
</td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input class="form-control" type="text" name="writer" maxlength="10"></td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select class="form-select" name="category">
                            <option value="news">뉴스</option>
                            <option value="events">이벤트</option>
                            <option value="columns">칼럼</option>
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
                        <textarea class="form-control" rows="4" name="content" style="min-height: 5.4rem; max-height: 30rem;">${board.content}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>더 알아보기 링크</td>
                    <td><input class="form-control" type="text" name="link" maxlength="260"></td>
                </tr>
            </table>

            <div class="form-button-wrapper" style="text-align:center;">
                <span class="btn-basic btn-line-basic" onclick="location.href = '<%= context %>/board/list.do'">글 목록 보기</span>
                <input class="btn-basic" type="submit" value="등록">
            </div>

        </form>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
