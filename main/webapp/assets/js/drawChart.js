function drawLineChart(line_y_arr, line_x_arr) {
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
        label: datasets_label + " 검색 추이",
        data: line_y_arr,
        borderColor: "#6ECCAF",
        borderWidth: 1,
        pointRadius: 3,
      }]
    },
    options: {
      responsive: true,
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
            text: "날짜"
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
	  backgroundColor: ['#FF0000', '#00FF00'], // 섹션의 색상 설정
	  hoverBackgroundColor: ['#FF6384', '#36A2EB'], // 호버 시의 색상 설정
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
          text: 'Chart.js Pie Chart'
        }
      }
    }
  });
}

function drawDoughnutChart(pie_w_data, pie_m_data) {
  const ctx = document.getElementById('doughnutChart');
  let doughnutChart;

  if (doughnutChart) {
    doughnutChart.destroy();
  }

  let datasets_label = document.getElementById("keyword").value;
  
  doughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ['여성', '남성'],
	  datasets: [{
	  data: [pie_w_data, pie_m_data],
	  backgroundColor: ['#FF0000', '#00FF00'], // 섹션의 색상 설정
	  hoverBackgroundColor: ['#FF6384', '#36A2EB'], // 호버 시의 색상 설정
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
          text: 'Chart.js Doughnut Chart'
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
        label: datasets_label + " 검색 추이",
        data: bar_data,
        borderColor: "#6ECCAF",
        borderWidth: 1,
        pointRadius: 3,
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
          text: 'Chart.js Bar Chart'
        }
      }
    }
  });
}
