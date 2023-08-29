<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark_list | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
   
</head>

<body>
<%@include file="../common/header.jsp"%>
    <div class="container">
        <h2 class="text-center">북마크 목록</h2>
        <table class="table table-board table-hover">
            <thead>
                <tr>
                    <th class="text-center">번호</th>
                    <th class="text-center">키워드</th>
                    <th class="text-center">카테고리</th>
                    <th class="text-center">등록일</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="goods" items="${bookmark_list}">
                    <tr>
                        <td class="text-center">${bookmark.bookmark_no }</td>
                        <td class="text-center"><a href="<%=context %>/bookmarkcon/view.do?bookmark_no=${bookmark.bookmark_no}">${bookmark.member_id} </a></td>
                        <td class="text-center">${bookmark.keywords}</td>
                        <td class="text-center">${bookmark.category}</td>
                        <td class="text-center">${bookmark.add_date}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>
