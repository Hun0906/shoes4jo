const random_items = [
"골든구스 슈퍼스타", 
"나이키 데이브레이크", 
"나이키 레볼루션6 넥스트 네이처", 
"나이키 에어맥스 SC", 
"나이키 에어맥스 퓨전", 
"나이키 에어줌 파이어", 
"나이키 에어포스", 
"나이키 와플레이서", 
"나이키 와플트레이너", 
"나이키 울프그레이", 
"나이키 조던1 미드", 
"나이키 코트 레거시", 
"나이키 코트 버로우 로우2", 
"나이키 킬샷", 
"나이키 플렉스 러너2", 
"뉴발란스 327", 
"뉴발란스 410v5", 
"뉴발란스 530", 
"뉴발란스 574 클래식", 
"뉴발란스 990v3", 
"뉴발란스 993", 
"디스커버리 조거 플렉스", 
"반스 어센틱", 
"반스 올드스쿨", 
"빅토리아 오다 메리제인", 
"아디다스 가젤", 
"아디다스 네오조그", 
"아디다스 니짜 트레포일", 
"아디다스 삼바", 
"아디다스 삼바로즈", 
"아디다스 쇼더웨이 2.0", 
"아디다스 슈퍼스타", 
"아디다스 아딜렛 클로그", 
"아디다스 알파바운스 슬라이드 2.0", 
"아디다스 오즈위고", 
"아식스 젤 1130", 
"아식스 젤 벤쳐 6", 
"아식스 젤 소노마 15-50", 
"아식스 조그 100 2", 
"오니츠카타이거 멕시코66", 
"조던 1 로우", 
"컨버스 런스타 하이크", 
"컨버스 척테일러", 
"케즈 볼드 메리제인", 
"케즈 블루 클라우드", 
"크록스 클래식 클로그", 
"푸마 스웨이드 클래식", 
"휠라 디스럽터2"];
	
const random_item_span = document.getElementById('random_item');
let currentItemIndex = 0;

function typeWriterEffect(idx, characterIdx) {
    if (characterIdx < random_items[idx].length) {
        random_item_span.innerHTML += random_items[idx].charAt(characterIdx);
        setTimeout(typeWriterEffect, 50, idx, characterIdx + 1);
    } else {
        setTimeout(() => {
            changeRandomItem();
            drawChart();
        }, 6000 - 50*(characterIdx + 1));
    }
}

function changeRandomItem() {
    random_item_span.innerHTML = "";
	const nextIndex = Math.round(Math.random() * (random_items.length - 1));
    currentItemIndex = nextIndex;
    typeWriterEffect(nextIndex, 0);
}

function setSearchInput() {
	//랜덤 아이템 클릭하면 search input에 값이 입력됨
	document.getElementById("keyword").value = document.getElementById("random_item").innerHTML;
}

// Initial run
document.addEventListener("DOMContentLoaded", () => {
    changeRandomItem();
    setTimeout(drawChart, 200);
});


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
               responsive: true,
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
