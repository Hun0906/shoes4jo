<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.multi.shoes4jo.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
 
<style>
.simplesignup {
	border: 1px solid black;
	background-color: #ccc;
	border-radius: 10rem;
	height: 64px;
	width: 64px;
	display: inline-block;
	margin: 1rem;
	cursor: pointer;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
<% 
String memberInfo = (String)request.getSession().getAttribute("memberInfo");
String member_id = "";
if (memberInfo != null) {
    member_id = memberInfo;
}
%>

    
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("deleteMemberBtn").addEventListener("click", function() {
        var confirmed = confirm("정말로 회원 정보를 삭제하시겠습니까?");
        if (!confirmed) {
            // 사용자가 취소를 선택한 경우 이전 페이지로 돌아감
            window.history.back();
            return;
        }
        var member_id = '<%= member_id %>';
        deleteMember(member_id);
    });
});



    function deleteMember(id) {
        $.ajax({
            method: "POST",
            url: "/controller/member_delete",
            data: { member_id: id },
            dataType: "json",
            success: function(response) {
            	   if (response.result == 1) {
                    alert("회원 정보가 성공적으로 삭제되었습니다.");
                    window.location.href = "/";
                } else {
                    alert("회원 정보 삭제에 실패하였습니다.");
                }
            },
            error: function(xhr, status, error) {
                console.log("Class 호출 실패: ", status, error);
            }
        });
    }
</script>
</head>
<body>
    <%@include file="../common/header.jsp"%>

    <div class="contents">
        <div class="container">

            <div class="form-wrapper">
                <h1>회원 탈퇴</h1>
                <form name="deleteForm" onsubmit="return false;">
                    <div class="form-button-wrapper">
                        <button class="btn-basic btn-red" id="deleteMemberBtn"
                            type="submit">회원 탈퇴</button>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <%@include file="../common/footer.jsp"%>

</body>
</html>
