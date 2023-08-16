//추후 인기검색어로 변경 예정
const random_items = [
	"나이키 에어포스 1",
	"아디다스 알파바운스 슬라이드 2.0",
	"닥터마틴 2976 첼시 스무스",
	"아디다스 슈퍼스타",
	"컨버스 척테일러 올스타 코어",
	"크록스 클래식 클로그",
	"에어 조던 레거시 312 로우",
	"반스 올드스쿨",
	"우포스 OORIGINAL BLACK",
	"닥터마틴 1461 3홀 모노",
	"어그 퍼 카라 스웨이드 플랫폼 슬리퍼",
	"반스 어센틱",
	"뉴발란스 530",
	"나이키 덩크 로우 프로 프리미엄",
	"조던 1 로우",
	"아식스 젤 1130",
	"나이키 레볼루션6 넥스트 네이처",
	"아식스 젤 벤쳐 6",
	"아디다스 쇼더웨이 2.0",
	"나이키 플렉스 러너2",
	"아식스 조그 100T 우먼스",
	"나이키 코트 레거시",
	"아디다스 알파바운스 슬라이드 2.0",
	"나이키 코트 버로우 로우2",
	"나이키 에어맥스 SC",
	"아디다스 아딜렛 클로그",
	"아식스 젤 소노마 15-50",
	"아디다스 니짜 트레포일",
	"프레드페리 로티 레더",
	"팔렛 탑스티치 웨스턴 부츠",
	"케즈 볼드 메리제인",
	"엘칸토 마쯔 남성 페니 로퍼",
	"레더리 토루프 모던 샌들 슬라이드",
	];
	
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
	const nextIndex = Math.round(Math.random() * random_items.length);
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
