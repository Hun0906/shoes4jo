<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리별 트렌드 | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
window.onload = function() {
  fetch('/category_trend/get_data?keyword=some_keyword')
    .then(response => response.json())
    .then(data => {
    });
};
</script>


<script>
const shoesLabels = [<c:forEach items="${labels}" var="label" varStatus="loop">${loop.last ? '' : ','}'${label}'</c:forEach>];
const shoesData = [<c:forEach items="${data}" var="datum" varStatus="loop">${loop.last ? '' : ','}${datum}</c:forEach>];
</script>

<style>
h2 {
	margin: 0 auto;
}

.header span {
	font-size: 1.6rem;
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<div class="container">
		<h1>카테고리별 트렌드</h1>
		<div
			style="display: grid; grid-template-columns: 1fr 1fr 1fr; grid-gap: 3rem;">

			<div class="subject">
				<div class="header">
					<h2>신발</h2>
					<span>인기 상품 순위</span>
				</div>
				<div class="chart-container">
					<canvas id="shoesChart"></canvas>
				</div>


			</div>

		</div>

		<%@ include file="../common/footer.jsp"%>


		<!-- 차트 생성 -->
		<script>
        const shoesChart = new Chart(document.getElementById('shoesChart'), {
            type: 'bar',
            data: {
                labels: shoesLabels,
                datasets: [{
                    label: '인기 상품 순위',
                    data: shoesData,
                    backgroundColor:'rgba(75,192,192,0.6)',
                    borderColor:'rgba(75,192,192,1)',
                    borderWidth : 1
                 }]
             },
             options:{
                 scales:{
                     yAxes:[{
                         ticks:{
                             beginAtZero:true
                         }
                     }]
                 }
             }
         });

   </script>
</body>
</html>
