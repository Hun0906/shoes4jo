<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_list | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>

<body>
<%@include file="../common/header.jsp"%>
    <div class="container">
        <h2 class="text-center">회원 목록</h2>
        <table class="table table-board table-hover">
            <thead>
                <tr>
                    <th class="text-center">회원 아이디</th>
                    <th class="text-center">회원 이름</th>
                    <th class="text-center">가입일</th>
                    <th class="text-center">회원 이메일</th>
                    <th class="text-center">회원 연락처</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="member" items="${member_list}">
                    <tr>
                        <td class="text-center">${member.member_id }</td>
                        <td class="text-center"><a href="/controller/showMember?member_id=${member.member_id}">${member.member_name} </a></td>
                        <td class="text-center">${member.signup_date}</td>
                        <td class="text-center">${member.member_email}</td>
                        <td class="text-center">${member.member_phone}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>
