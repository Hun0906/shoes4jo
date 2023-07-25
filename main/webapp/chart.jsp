<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>

<body>
<%@include file="./view/header.jsp"%>

	<div class="contents">
			
			<div class="container">
				<h1>차트 테스트</h1>
				
				<div class="item">
				<div>
  <canvas id="myChart"></canvas>
</div>

<script>
  const ctx = document.getElementById('myChart');

  new Chart(ctx, {
    type: 'line',
    data: {    	
      labels: [1,2,3],
      datasets: [{
        label: '일별 가입자 수',
        data: [322,534,222],
        borderWidth: 1,
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
</script>
				</div>
			</div>
		</div>
	
<%@include file="./view/footer.jsp"%>

</body>
</html>