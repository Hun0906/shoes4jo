<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOES4JO | MAIN</title>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
.main{
height: calc(100vh - 325px);
display: grid;
text-align: center;
align-items: center;
}

#random_item{
background-image: linear-gradient(60deg, #6ECCAF 0%, #ADE792 30%, #ADE792 50%, #E9FFC2 90%, #FDFFAE 100%);
    background-repeat: no-repeat;
    background-position: left -5px bottom 0px;
    background-size: 100% 30%;
    }
    
.main_span{
font-size: 3rem;
font-weight: bold;
}

#random_item::after {
    content: "|";
    color: #344D67;
    animation: blink 1s infinite step-end;
}

@keyframes blink {
    0%, 100% {
        opacity: 0;
    }
    50% {
        opacity: 1;
    }
}

#myChart{
    top: 150px;
    z-index: -1;
    display: block;
    box-sizing: border-box;
    height: 700px;
    width: 100%;
    position: fixed;
    margin: 0 auto;
    left: 0;
    right: 0;
    filter: opacity(0.5);
    }
    </style>
</head>

<body>
	<%@include file="/view/header.jsp"%>

	<div class="contents">
		<div class="container main">
		<div><br><span class="main_span">지금</span><br>
		<span class="main_span" id="random_item">test0</span><span class="main_span">의 쇼핑 트렌드를</span><br>
		<span class="main_span">알아보세요.</span></div>
		<form style="position: relative; top: -5rem;" action="keyword_trend.jsp" method="get"><input type="text" class="main_search" name="keyword">
		<button class="btn-basic btn-color2" style="font-size: 1.5rem;">Search👀</button></form>
		
		</div>
		  <canvas id="myChart"></canvas>
		
	</div>

    <script>
    const random_items = [
    	"나이키 에어포스 1",
    	"아디다스 알파바운스 슬라이드 2.0",
    	"닥터마틴 2976 첼시 스무스",
    	"아디다스 슈퍼스타",
    	"컨버스 척테일러 올스타 코어",
    	"크록스 클래식 클로그",
    	"에어 조던 레거시 312 로우",
    	"반스 올드스쿨",
    	"락피쉬웨더웨어 HAYDEN BOOTS",
    	"우포스 OORIGINAL BLACK",
    	"닥터마틴 1461 3홀 모노",
    	"어그 퍼 카라 스웨이드 플랫폼 슬리퍼",
    	"배럴 스웰 아쿠아 슈즈",
    	"머렐 HYDRO MOC",
    	"반스 어센틱",
    	"뉴발란스 530",
    	"나이키 덩크 로우 프로 프리미엄",
    	"조던 1 로우",
    	"아식스 젤 1130",
    	];
    const random_item_element = document.getElementById('random_item');
    let currentItemIndex = 0;

    const ctx = document.getElementById('myChart');
    let myChart;

    function drawChart() {
        if (myChart) {
            myChart.destroy();
        }

        myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                datasets: [{
                    label: "Shoes Trend Research",
                    data: [
                        Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20,
                        Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20,
                        Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20, Math.random() * 100+20
                    ],
                    borderColor: "#6ECCAF",
                    borderWidth: 1,
                }]
            },
            options: {
                plugins: {
                    legend: {
                        display: false
                    },
                },
                scales: {
                    x: {
                        display: true,
                        grid: {
                            display: true
                        }
                    },
                    y: {
                        display: false,
                        grid: {
                            display: true
                        },
                        beginAtZero: true
                    }
                }
            }
        });
    }

    function typeWriterEffect(idx, characterIdx) {
        if (characterIdx < random_items[idx].length) {
            random_item_element.innerHTML += random_items[idx].charAt(characterIdx);
            setTimeout(typeWriterEffect, 80, idx, characterIdx + 1);
        } else {
            setTimeout(() => {
                changeRandomItem();
                drawChart();
            }, 6000 - 80*(characterIdx + 1));
        }
    }

    function changeRandomItem() {
        random_item_element.innerHTML = "";
        const nextIndex = (currentItemIndex + 1) % random_items.length;
        currentItemIndex = nextIndex;
        typeWriterEffect(nextIndex, 0);
    }

    // Initial run
    document.addEventListener("DOMContentLoaded", () => {
        changeRandomItem();
        setTimeout(drawChart, 200);
    });

      
    </script>

	<%@include file="./view/footer.jsp"%>

</body>
</html>