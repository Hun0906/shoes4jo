<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Board_update | SHOES4JO</title>
  <%@include file="../common/header-head.jsp"%>
  <style>
    .button-group {
      text-align: center;
      margin-top: 1rem;
    }
    .button-group .btn {
      margin: 15px;
    }
  </style>
</head>
<body>
  <%@include file="../common/header.jsp"%>

  <div class="container">
    <div>
      <form action="/board/writeOk.do" method="post">
        <h2>
          <input type="text" name="title" value="${board.title}">
        </h2>
        <input type="hidden" name="bno" value="${board.bno}">
        <table class="table table-board table-hover">
          <tr>
            <td>글 번호</td>
            <td>${board.bno}</td>
          </tr>

          <tr>
            <td>작성자</td>
            <td><input type="text" name="writer" value="${board.writer}"></td>
          </tr>

          <tr>
            <td>작성일</td>
            <td>${board.regdate}</td>
          </tr>

          <tr>
            <td colspan="2"><b>내용</b></td>
          </tr>

          <tr>
            <td colspan="2"><textarea rows="10" cols="150" name="content">${board.content}</textarea></td>
          </tr>

          <tr>
            <td colspan="2">
              <div class="form-button-wrapper" style="text-align: center;">
                <input type="submit" class="btn-basic" value="수정하기">
              </div>
            </td>
          </tr>
        </table>
      </form>

      <div class="button-group">
        <button class="btn btn-secondary" onclick="history.back()">이전으로</button>
        <button class="btn btn-secondary" onclick="location.href='/board/list.do'">목록으로</button>
      </div>
    </div>

    <%@include file="../common/footer.jsp"%>
  </div>
</body>
</html>
