<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.multi.shoes4jo.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<script type="text/javascript">
	function enableEditing() {
		var inputs = document.querySelectorAll('.form-control');
		for (var i = 0; i < inputs.length; i++) {
			inputs[i].removeAttribute('readonly');
		}
		document.getElementById('btnEdit').style.display = 'none';
		document.getElementById('btnSaveCancel').style.display = 'block';
	}
	
	function updateMemberInfo() {
        var formData = new FormData(document.getElementById("updateForm"));

        $.ajax({
            method: "POST",
            url: "/controller/updateMember",
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                alert("회원 정보가 업데이트되었습니다.");
                location.reload(); // 현재 페이지 새로고침
            },
            error: function(xhr, status, error) {
                console.log("회원 정보 업데이트 실패:", status, error);
                alert("회원 정보 업데이트에 실패하였습니다.");
            }
        });
    }
	
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="form-wrapper">
		<h1>마이페이지</h1>
		<h2>회원 정보</h2>
		<form id="updateForm" enctype="multipart/form-data">
			<%
			MemberVO memberInfo = (MemberVO) request.getAttribute("memberInfo");
			if (memberInfo == null) {
				out.println("로그인이 필요합니다.");
			} else {
			%>
			<div class="input-wrapper">
				<label>이름</label> <input type="text" class="form-control"
					name="member_name" value="<%=memberInfo.getmember_name()%>"
					>
			</div>
			<div class="input-wrapper">
				<label>아이디</label> <input type="text" class="form-control"
					name="member_id" value="<%=memberInfo.getmember_id()%>" readonly>
			</div>
			<div class="input-wrapper">
				<label>비밀번호</label> <input type="text" class="form-control"
					name="member_pw" value="<%=memberInfo.getmember_pw()%>">
			</div>
			<div class="input-wrapper">
				<label>가입일</label> <input type="text" class="form-control"
					value="<%=memberInfo.getsignup_date()%>" readonly>
			</div>
			<div class="input-wrapper">
				<label>이메일</label> <input type="text" class="form-control"
					name="member_email" value="<%=memberInfo.getmember_email()%>"
					>
			</div>
			<div class="input-wrapper">
				<label>휴대폰 번호</label> <input type="text" class="form-control"
					name="member_phone" value="<%=memberInfo.getmember_phone()%>"
					>
			</div>
			<div class="form-button-wrapper">
            	<span class="btn-basic" id="btnEdit" onclick="enableEditing()">수정하기</span>
            	<div id="btnSaveCancel" style="display: none;">
                	<button onclick="updateMemberInfo()">저장</button>
                	<button type="button" onclick="location.href='/my_page'">취소</button>
            	</div>
            </div>
			<%
			}
			%>
		</form>
	</div>

	<%@include file="../common/footer.jsp"%>