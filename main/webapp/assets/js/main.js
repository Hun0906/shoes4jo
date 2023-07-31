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
        const nextIndex = (currentItemIndex + 1) % random_items.length;
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