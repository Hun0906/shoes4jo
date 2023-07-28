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

function jsonParse(){
	let string = '{"startDate":"2017-08-01","endDate":"2023-07-28","timeUnit":"month","results":[{"title":"아디다스","keyword":["아디다스"],"data":[{"period":"2017-08-01","ratio":36.45826},{"period":"2017-09-01","ratio":43.05661},{"period":"2017-10-01","ratio":33.66105},{"period":"2017-11-01","ratio":10.57836},{"period":"2017-12-01","ratio":18.34683},{"period":"2018-01-01","ratio":22.99383},{"period":"2018-02-01","ratio":29.93376},{"period":"2018-03-01","ratio":35.39546},{"period":"2018-04-01","ratio":28.17627},{"period":"2018-05-01","ratio":30.23033},{"period":"2018-06-01","ratio":26.19608},{"period":"2018-07-01","ratio":17.2598},{"period":"2018-08-01","ratio":16.15776},{"period":"2018-09-01","ratio":30.9504},{"period":"2018-10-01","ratio":24.44205},{"period":"2018-11-01","ratio":19.13845},{"period":"2018-12-01","ratio":19.64273},{"period":"2019-01-01","ratio":26.91269},{"period":"2019-02-01","ratio":26.14876},{"period":"2019-03-01","ratio":24.42936},{"period":"2019-04-01","ratio":18.69994},{"period":"2019-05-01","ratio":25.58794},{"period":"2019-06-01","ratio":26.41879},{"period":"2019-07-01","ratio":33.26871},{"period":"2019-08-01","ratio":83.24678},{"period":"2019-09-01","ratio":40.06785},{"period":"2019-10-01","ratio":28.9552},{"period":"2019-11-01","ratio":39.72281},{"period":"2019-12-01","ratio":26.71767},{"period":"2020-01-01","ratio":24.64054},{"period":"2020-02-01","ratio":28.1405},{"period":"2020-03-01","ratio":34.98465},{"period":"2020-04-01","ratio":38.94158},{"period":"2020-05-01","ratio":35.90089},{"period":"2020-06-01","ratio":23.06653},{"period":"2020-07-01","ratio":21.53407},{"period":"2020-08-01","ratio":19.81698},{"period":"2020-09-01","ratio":40.33326},{"period":"2020-10-01","ratio":37.36527},{"period":"2020-11-01","ratio":21.55484},{"period":"2020-12-01","ratio":18.90881},{"period":"2021-01-01","ratio":35.53393},{"period":"2021-02-01","ratio":21.73832},{"period":"2021-03-01","ratio":24.70862},{"period":"2021-04-01","ratio":23.94239},{"period":"2021-05-01","ratio":32.01204},{"period":"2021-06-01","ratio":29.67065},{"period":"2021-07-01","ratio":24.0924},{"period":"2021-08-01","ratio":40.21902},{"period":"2021-09-01","ratio":30.75307},{"period":"2021-10-01","ratio":40.01592},{"period":"2021-11-01","ratio":57.80885},{"period":"2021-12-01","ratio":56.48757},{"period":"2022-01-01","ratio":43.15239},{"period":"2022-02-01","ratio":28.41514},{"period":"2022-03-01","ratio":30.29726},{"period":"2022-04-01","ratio":31.37044},{"period":"2022-05-01","ratio":31.74548},{"period":"2022-06-01","ratio":32.57748},{"period":"2022-07-01","ratio":12.22737},{"period":"2022-08-01","ratio":10.74107},{"period":"2022-09-01","ratio":13.27863},{"period":"2022-10-01","ratio":18.4553},{"period":"2022-11-01","ratio":20.06854},{"period":"2022-12-01","ratio":33.08984},{"period":"2023-01-01","ratio":36.22977},{"period":"2023-02-01","ratio":59.66788},{"period":"2023-03-01","ratio":100},{"period":"2023-04-01","ratio":52.42447},{"period":"2023-05-01","ratio":39.11121},{"period":"2023-06-01","ratio":25.38023},{"period":"2023-07-01","ratio":19.23538}]}]}';
	let result = JSON.parse(string); //점 표기법으로 데이터를 불러올 수 있게 됨
	
    document.getElementById("parse_result").innerHTML = result;

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
	<a href="#" onclick="javascript:jsonParse();">파싱 테스트</a>
	
	<div id="result"></div>
	
	<div id="parse_result"></div>
	
	</div>
</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>