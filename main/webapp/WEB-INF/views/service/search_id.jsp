<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>search_id | SHOES4JO</title>
    <script src="/assets/js/addHypen.js"></script>
    <%@include file="../common/header-head.jsp"%>
</head>
<body class="bg-gradient-primary">
    <%@include file="../common/header.jsp"%>
    <form Name="searchVO" id="searchForm" action="${path}/controller/result_id" method="post">
        <div class="container">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-2">아이디 찾기</h1> <br>
                <br>
            </div>
            <div class="form-group">
                <input type="text" class="form-control form-control-user" id="member_name" name="member_name" placeholder="이름 입력">
            </div>
            <br>
            <div class="form-group">
                <input type="tel" class="form-control form-control-user" id="member_phone" name="member_phone" oninput="addHypen(this)" placeholder="휴대폰 번호 입력">
            </div>
            <br>
            <br>
            <a href="javascript:void(0)" onclick="fnSubmit(); return false;" class="btn-basic">아이디 찾기</a>
            <hr>
            <div class="text-center">
                <a class="small" onclick="location.href='insertMember'">회원가입 하기</a>
            </div>
            <div class="text-center">
                <a class="small" onclick="location.href='login'">로그인 하기</a>
            </div>
        </div>
        <%@include file="../common/footer.jsp"%>
    </form>

    <script>
        var path = "${pageContext.request.contextPath}";

        $(document).ready(function () {
            var msg = "${msg}";
            if (msg != "") {
                alert(msg);
            }
        });

        function fnSubmit() {
            var email_rule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            var tel_rule = /^\d{2,3}-\d{3,4}-\d{4}$/;

            if ($("#member_name").val() == null || $("#member_name").val() == "") {
                alert("이름을 입력해주세요.");
                $("#member_name").focus();
                return false;
            }

            if ($("#member_phone").val() == null || $("#member_phone").val() == "") {
                alert("전화번호를 입력해주세요.");
                $("#member_phone").focus();
                return false;
            }

            if (!tel_rule.test($("#member_phone").val())) {
                alert("형식에 맞게 입력해주세요.");
                return false;
            }

            if (confirm("아이디를 찾으시겠습니까?")) {
                $("#searchForm").submit();
                return false;
            }
        }
    </script>
</body>
</html>
