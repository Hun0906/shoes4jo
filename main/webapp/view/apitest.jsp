<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>네이버 쇼핑인사이트 API 사용 예시</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
// Step1: Set your API credentials here
	var clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
	var clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret

    // Define your API URL
    var apiURL = "https://openapi.naver.com/v1/datalab/shopping/top100?";
    apiURL += "url=" + encodeURIComponent("http://datalab.naver.com/shoppingInsight/sCategory.naver?cid=50000000");
    console.log(apiURL);

    // Step2: Call the API using AJAX
    $.ajax({
        method: "POST",
        url: apiURL,
        dataType: "json",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("X-Naver-Client-Id", clientId);
            xhr.setRequestHeader("X-Naver-Client-Secret", clientSecret);
        },
        success: function (response) {
            // Step3: Process the API response
            var resultHTML = '상위 100개 상품 데이터:';
            resultHTML += JSON.stringify(response);
            console.log(response);
            document.getElementById("result").innerHTML = resultHTML;
        },
        error: function (xhr, status, error) {
            console.log("API 호출 실패: ", status, error);
            document.getElementById("result").innerHTML = "Ajax 방식으로 API 호출 실패"
        }
    });
</script>
</head>
<body>
	<%@include file="header.jsp"%>

<div id="result" class="container"></div>

	<%@include file="footer.jsp"%>

</body>
</html>