
//데이터파싱
function jsonParse(target){
	//string에는 ajax로 불러온 리턴값이 들어가야 함
	let string = document.getElementById("result").innerHTML;
	let string_parse = JSON.parse(string); //점 표기법으로 데이터를 불러올 수 있게 됨
	let data = string_parse.results[0].data; //차트 그리기용 데이터셋
	
	if (data == "") {
		alert("검색 결과가 없습니다.");
		window.location="main";
	}
	
	
	if (target == "y"){
		let y_arr = [];
		
		data.forEach((e) => {
			y_arr.push(e.period.substring(5,7)+"월 "+e.period.substring(8)+"일");
		});
		
		return y_arr;
	} else if (target == "x") {
		let x_arr = [];
		
		data.forEach((e) => {
			x_arr.push(e.ratio);
		});
			
		return x_arr;
	}
}

//차트그리기
const ctx = document.getElementById('myChart');
let myChart;

function drawChart() {
  document.forms['keywordTrendForm'].setAttribute('style', '');

  if (myChart) {
      myChart.destroy();
  }
  
  y_arr = jsonParse("y");
  x_arr = jsonParse("x");
  
  datasets_label = document.getElementById("keyword").value;

  myChart = new Chart(ctx, {
      type: 'line',
      data: {
			labels: y_arr,
          datasets: [{
              label: datasets_label + " 검색 추이",
              data: x_arr,
              borderColor: "#6ECCAF",
              borderWidth: 1,
              pointRadius: 3,
          }]
      },
      options: {
          plugins: {
              legend: {
                  display: true
              },
          },
          scales: {
              x: {
                  display: true,
                  title: {
                      display: true,
                      text: "period (month)"
                  },
                  grid: {
                      display: true
                  }
              },
              y: {
                  title: {
                      display: true,
                      text: "ratio (arb. unit)"
                  },
                  grid: {
                      display: true
                  },
                  beginAtZero: true
              }
          }
      }
  });

}