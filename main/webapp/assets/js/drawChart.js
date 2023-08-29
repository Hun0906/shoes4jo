function drawLineChart(line_y_arr1, line_y_arr2, line_x_arr) {
  const ctx = document.getElementById('lineChart');
  let lineChart;

  if (lineChart) {
    lineChart.destroy();
  }

  let datasets_label = document.getElementById("keyword").value;

  lineChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: line_x_arr,
      datasets: [{
        label: "쇼핑 클릭량",
        data: line_y_arr1,
        borderColor: "#6ECCAF",
        borderWidth: 2,
        pointRadius: 3
      },
	  {
		label : "검색량",
		data : line_y_arr2,
		borderColor : "#ADE792",
		borderWidth : 1,
		pointRadius :3
	  }]
    },
    options:{
      responsive:true ,
	  title:{
	    display:true ,
	    text:"Keyword Trend"
	  },
      plugins:{
	    legend:{
	      display:true
	    }
	  },
      scales:{
        x:{
          display:true ,
          title:{
            display:true ,
            text:"날짜"
          }
        },
       y:{ 
         beginAtZero:true,
		 title:{ 
		   display:true ,
		   text:"상대 비율 (arb. units)"
		 }
       }
     }  
   }  
 });
}



function drawPieChart(pie_w_data, pie_m_data) {
  const ctx = document.getElementById('pieChart');
  let pieChart;

  if (pieChart) {
    pieChart.destroy();
  }

  let datasets_label = document.getElementById("keyword").value;
  
  pieChart = new Chart(ctx, {
    type: 'pie',
    data: {
      labels: ['여성', '남성'],
	  datasets: [{
	  data: [pie_w_data, pie_m_data],
	  backgroundColor: ['#6ECCAF', '#ADE792'], // 섹션의 색상 설정
	  hoverBackgroundColor: ['#6ECCAFaa', '#ADE792aa'], // 호버 시의 색상 설정
	  }]
	},
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top',
        },
        title: {
          display: true,
          text: "성별 별 "+ datasets_label + " 관심도",
        }
      }
    }
  });
}

function drawDoughnutChart(dn_w_data, dn_m_data) {
  const ctx = document.getElementById('doughnutChart');
  let doughnutChart;

  if (doughnutChart) {
    doughnutChart.destroy();
  }

  let datasets_label = document.getElementById("keyword").value;
  
  doughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ['PC', 'Mobile'],
	  datasets: [{
		  data: [dn_w_data, dn_m_data],
		  backgroundColor: ['#6ECCAFaa', '#ADE792aa'], // 섹션의 색상 설정
		  borderColor: ['#6ECCAF', '#ADE792'], // 섹션의 색상 설정
		  hoverBackgroundColor: ['#6ECCAFaa', '#ADE792aa'], // 호버 시의 색상 설정
	  }]
	},
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top',
        },
        title: {
          display: true,
          text: "기기 별 "+ datasets_label + " 관심도",
        }
      }
    }
  });
}

function drawBarChart(bar_data) {
  const ctx = document.getElementById('barChart');
  let barChart;

  if (barChart) {
    barChart.destroy();
  }

  let datasets_label = document.getElementById("keyword").value;
  
  barChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['10대','20대','30대','40대','50대','60대 이상'],
      datasets: [{
        label: "Trend",
        data: bar_data,
        borderColor: "#6ECCAF",
        borderWidth: 1,
        pointRadius: 3,
        fill: "#6ECCAFaa",
        backgroundColor: "#6ECCAFaa",
      }]
    },
    options: {
      responsive: true,
      plugins: {
		legend: {
        position: 'top',
        },
        title: {
          display: true,
          text: "세대 별 "+ datasets_label + " 관심도",
        },
      scales: {
        x: {
          display: true,
          title: {
            display: true,
            text: "세대"
          },
          grid: {
            display: true
          }
        },
        y: {
          title: {
            display: true,
            text: "상대 비율 (arb. unit)"
          },
          grid: {
            display: true
          },
          beginAtZero: true
        }
      }
      }
    }
  });
}
