<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 | SHOES4JO</title>
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

<script>
    function signup() {
        let id = document.signupForm.MEMBER_ID.value;
        let isDupIdCheck = document.signupForm.MEMBER_ID.readOnly;
        let name = document.signupForm.MEMBER_NAME.value;
        let pw = document.signupForm.MEMBER_PW.value;
        let pwCheck = document.signupForm.MEMBER_PWCheck.value;
        let today = new Date();
        let signup_date = today.toLocaleDateString();
        let email = document.signupForm.MEMBER_EMAIL.value;
        let phone = document.signupForm.MEMBER_PHONE.value;

		if (!id) {
			alert("아이디를 입력하세요.");
			$("#id").focus();
			return false;
		}

		if (!isDupIdCheck) {
			alert("아이디 중복 확인이 필요합니다.");
			$("#id").focus();
			return false;
		}

		if (!name) {
			alert("이름을 입력하세요.");
			$("#name").focus();
			return false;
		}

		if (!pw) {
			alert("비밀번호를 입력하세요.");
			$("#pw").focus();
			return false;
		}
	    if (!pwCheck) {
	        alert("비밀번호 확인 값을 입력하세요.");
	        $("#pwCheck").focus();
	        return false;
	    }

	    if (pw !== pwCheck) {
	        alert("비밀번호 값이 일치하지 않습니다.");
	        $("#pwCheck").focus();
	        return false;
	    }

		if (!email) {
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		
		if (!phone) {
			alert("휴대폰 번호를 입력하세요.");
			$("#phone").focus();
			return false;
		}


        $.ajax({
            method: "post",
            url: "controller/insertMember",
            dataType: "text",
            data: {
                "member_id": id,
                "member_name": name,
                "member_pw": pw,
                "signup_date": signup_date,
                "member_email": email,
                "member_phone": phone,
            },
	        success : function(response) {
	            console.log("회원가입 성공");
	            alert("회원가입이 완료되었습니다.");
	            window.location.href = "<%=context%>/login";
	        },
	        error : function(xhr, status, error) {
	            console.log("Class 호출 실패: ", status, error);
	        }
	    });

	}
    

	function duplacationId() {
		let id = document.signupForm.id.value;

		if (!id) {
			alert("아이디를 입력하세요.");
			$("#id").focus();
			return false;
		}

	    $.ajax({
	        method : "POST",
	        url : "controller/duplicationId",
	        dataType : "text",
	        data : {
	            "member_id" : id
	        },
	        success : function(response) {
	        	if(response == '1'){
		            console.log("아이디 중복 체크 > 사용할 수 없는 아이디.");
		            alert("이미 사용 중인 아이디입니다.");
	        	} else {
		            console.log("아이디 중복 체크 > 사용할 수 있는 아이디.");
		            alert("사용 가능한 아이디입니다.");
		            $('#id').attr("readonly",true); 
	        	}
	        },
	        error : function(xhr, status, error) {
	            console.log("아이디 중복 체크 > Class 호출 실패: ", status, error);
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
		<h1>회원가입</h1>
		<form name="signupForm" onsubmit="event.preventDefault(); signup();">
		<div class="input-wrapper">
		<label>아이디</label><div class="input-with-button"><input type="text" id="id" name="MEMBER_ID" placeholder="아이디" class="form-control" required>
		<span class="button-with-input" id="idre" name="idre" onclick="duplacationId()">중복 확인</span></div>
		</div>
		<div class="input-wrapper">
		<label>이름</label><input type="text" id="name" name="MEMBER_NAME" placeholder="이름" class="form-control" required>
		</div>
		<div class="input-wrapper">
		<label>이메일</label><input type="email" id="email" name="MEMBER_EMAIL" placeholder="이메일" class="form-control" pattern="^[\w.%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$" required>
		</div>
		<div class="input-wrapper">
		<label>휴대전화</label><input type="tel" id="phone" name="MEMBER_PHONE" placeholder="휴대전화" class="form-control" pattern="^01[016789]{1}-?[1-9]{1}[0-9]{2,3}-?[0-9]{4}$" title="01x-xxxx-xxxx" maxlength="13" required>
		</div>
		<div class="input-wrapper">
		<label>비밀번호</label><input type="password" id="pw" name="MEMBER_PW" placeholder="비밀번호" class="form-control" required>
		</div>
		<div class="input-wrapper">
		<label>비밀번호 확인</label><input type="password" id="pwCheck" name="MEMBER_PWCheck" placeholder="비밀번호" class="form-control" required>
		</div>
		<div class="form-button-wrapper">
		<button class="btn-basic" type="submit">회원가입</button>
		</div>
		</form>
		</div>
		

		</div>
	</div>

	<%@include file="../common/footer.jsp"%>

</body>
</html>
