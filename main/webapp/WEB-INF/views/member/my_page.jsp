<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.multi.shoes4jo.member.MemberVO"%>
<%
MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
if (memberInfo == null) {
	response.sendRedirect("login");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>마이페이지 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script>
window.onload = function() {
	getCode();
}

function getCode() {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const code = urlParams.get('res');

	if (code === "-1") {
		alert("정보 수정에 실패하였습니다.");
		location.href="<%=context%>/controller/memberInfo";
    } else if (code == "0") {
        alert("비밀번호가 틀렸습니다.");
		location.href="<%=context%>/controller/memberInfo";
    } else if (code == "1") {
        alert("정보 수정에 성공하였습니다.");
		location.href="<%=context%>/controller/memberInfo";
    }
}
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<form action="<%=context%>/my_edit" method="post">
	<div class="form-wrapper">
		<h1>마이페이지</h1>
		<h2>회원 정보</h2>
		<div class="input-wrapper">
			<label>아이디</label> <input type="text" class="form-control"
				name="member_id" value="<%=memberInfo.getMember_id()%>" readonly>
		</div>
		<div class="input-wrapper">
			<label>가입일</label> <input type="text" class="form-control"
				value="<%=memberInfo.getSignup_date().substring(0,10)%>" readonly>
		</div>
		<div class="input-wrapper">
			<label>이름</label> <input type="text" class="form-control"
				name="member_name" value="<%=memberInfo.getMember_name()%>" readonly>
		</div>
		<div class="input-wrapper">
			<label>이메일</label> <input type="text" class="form-control"
				name="member_email" value="<%=memberInfo.getMember_email()%>" readonly>
		</div>
		<div class="input-wrapper">
			<label>휴대폰 번호</label> <input type="text" class="form-control"
				name="member_phone" value="<%=memberInfo.getMember_phone()%>" readonly>
		</div>
		<div class="form-button-wrapper">
		<button class="btn-basic">수정하기</button>
		</div>
		<div class="form-button-wrapper">
			<span class="btn-basic btn-line-red"
				onclick="deleteMember();">탈퇴하기</span>
		</div>
	</div>
	</form>
	
<script>
function deleteMember() {
    if(window.confirm("탈퇴하시겠습니까?")){
        $.ajax({
            method: "POST",
            url: "/controller/deleteMember",
            data: { member_id : "<%=memberInfo.getMember_id()%>" },
            success: function(response) {
                window.location.href = "/login";
            }
        }); 
    }
}
</script>

 
	<%@include file="../common/footer.jsp"%>
</body>
</html>