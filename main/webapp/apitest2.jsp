<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>네이버 쇼핑인사이트 API 사용 예시 - Fetch API</title>
</head>
<body>

	<%@include file="./view/header.jsp"%>

<div id="result" class="container"></div>

	<%@include file="./view/footer.jsp"%>
</body>

<script>

//Step1: Set your API credentials here
		var clientId = "Client ID : JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
		var clientSecret = "secret : 9fgwNuy1pM"; // 애플리케이션의 Client Secret

// Define your API URL
    var apiURL = "https://openapi.naver.com/v1/datalab/shopping/top100?";
    apiURL += "url=" + encodeURIComponent("http://datalab.naver.com/shoppingInsight/sCategory.naver?cid=50000000");

    // Step2: Call the API using Fetch API
    fetch(apiURL, {
        method: 'GET',
        headers: {
            'X-Naver-Client-Id': clientId,
            'X-Naver-Client-Secret': clientSecret
        }
    })
    .then(response => response.json())
    .then(data => {
        // Step3: Process the API response
        var resultHTML = '상위 100개 상품 데이터:';
        resultHTML += JSON.stringify(data);
        document.getElementById("result").innerHTML = resultHTML;
    })
    .catch(error => {
        console.log("API 호출 실패: ", error);
        document.getElementById("result").innerHTML = "Fetch API 호출 실패";
    });
</script>

</html>