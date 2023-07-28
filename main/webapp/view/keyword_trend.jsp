<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | 상품별 트렌드</title>

	<%@include file="header.jsp"%>

<script>
function getAPIResult() {
	// Step1: Set your API credentials here
	const clientId = "JzcrBZHimsCICRuNqbzk"; // 애플리케이션의 Client ID
	const clientSecret = "9fgwNuy1pM"; // 애플리케이션의 Client Secret
	
	//Step2: 값 입력하기
	let date = new Date();
	let today = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');

	let keyword = document.getElementById("keyword").value;
	console.log(keyword);
	
	if (!keyword) {
		alert("검색어를 입력하세요.");
        setTimeout(function () { $("#keyword").focus(); }, 100);
        return false;
	}
	
	<!--
    // Step3: Call the API directly using AJAX
    $.ajax({
        method: "POST",
        url: "https://openapi.naver.com/v1/datalab/shopping/category/keywords",
        dataType: "json",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("X-Naver-Client-Id", clientId);
            xhr.setRequestHeader("X-Naver-Client-Secret", clientSecret);
        },
        data: {
        	"startDate": "2017-08-01",
        	"endDate": today,
        	"timeUnit": "month",
        	"category": "100000022",
        	"keyword": [{name: keyword, param: [keyword]}],
        	},
        success: function (response) {
            // Step3: Process the API response
            var resultHTML = '성공함!:';
            resultHTML += JSON.stringify(response);
            console.log(response);
            document.getElementById("result").innerHTML = resultHTML;
        },
        error: function (xhr, status, error) {
            console.log("API 호출 실패: ", status, error);
            document.getElementById("result").innerHTML = "API 호출 실패...."
        }
    });
	-->
	
	// Step3: java 이용해서 호출
    $.ajax({
        method: "POST",
        url: "keywordtrend",
        dataType: "json",
        data: {
        	"keyword": keyword,
        	},
        success: function (response) {
            // Step3: Process the API response
            var resultHTML = '성공함!:';
            resultHTML += JSON.stringify(response);
            console.log(response);
            document.getElementById("result").innerHTML = resultHTML;
        },
        error: function (xhr, status, error) {
            console.log("API 호출 실패: ", status, error);
            document.getElementById("result").innerHTML = "API 호출 실패...."
        }
    });
	
}
</script>

</head>
<body>

<div class="contents">
	<div class="container" style="text-align: center;">
	<form action="javascript:getAPIResult();">
		<input type="text" class="main_search" id="keyword">
		<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Search👀</button>
	</form>
	<a target="_blank" href="https://developers.naver.com/docs/serviceapi/datalab/shopping/shopping.md#%EC%87%BC%ED%95%91%EC%9D%B8%EC%82%AC%EC%9D%B4%ED%8A%B8-%ED%82%A4%EC%9B%8C%EB%93%9C%EB%B3%84-%ED%8A%B8%EB%A0%8C%EB%93%9C-%EC%A1%B0%ED%9A%8C">
	API Docs</a>
	<a target="_blank" href="https://datalab.naver.com/keyword/trendSearch.naver">데이터랩</a>
	
	<div id="result"></div>
	
	</div>
</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>