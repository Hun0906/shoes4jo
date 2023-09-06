<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리별 트렌드 | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>

<!-- Chart.js 라이브러리를 포함시킵니다. -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

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
        <div style="display: grid; grid-template-columns: 1fr 1fr 1fr; grid-gap: 3rem;">

            <div class="subject">
                <div class="header">
                    <h2>신발</h2>
                    <span>인기 상품 순위</span>
                </div>
                <div class="chart-container">
                    <canvas id="shoesChart"></canvas>
                </div>
            </div>

            <div class="subject">
                <div class="header">
                    <h2>의류</h2>
                    <span>인기 상품 순위</span>
                </div>
                <div class="chart-container">
                    <canvas id="apparelChart"></canvas>
                </div>
            </div>

            <!-- 다른 카테고리를 추가하려면 이곳에 비슷한 구조의 코드를 추가하십시오. -->

        </div>
    </div>
    <%@ include file="../common/footer.jsp"%>

    <!-- 차트를 생성하는 JavaScript 코드를 여기에 추가합니다. -->
    <script>
        // 샘플 데이터..
        const shoesLabels = ['나이키', '아디다스', '뉴발란스', '슬리퍼', '운동화'];
        const shoesData = [20, 18, 15, 12, 10];

        const apparelLabels = ['티셔츠', '바지', '원피스', '자켓', '스웨터'];
        const apparelData = [25, 22, 18, 15, 10];

        // 차트를 생성합니다.
        const shoesChart = new Chart(document.getElementById('shoesChart'), {
            type: 'bar',
            data: {
                labels: shoesLabels,
                datasets: [{
                    label: '인기 상품 순위',
                    data: shoesData,
                    backgroundColor: 'rgba(75, 192, 192, 0.6)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
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

        const apparelChart = new Chart(document.getElementById('apparelChart'), {
            type: 'bar',
            data: {
                labels: apparelLabels,
                datasets: [{
                    label: '인기 상품 순위',
                    data: apparelData,
                    backgroundColor: 'rgba(255, 99, 132, 0.6)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
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

        // 다른 카테고리에 대한 차트 생성 코드도 추가하십시오.
    </script>
</body>
</html>