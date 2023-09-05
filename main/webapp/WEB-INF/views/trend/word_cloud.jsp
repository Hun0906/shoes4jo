<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연관 주제 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3-cloud/1.2.5/d3.layout.cloud.min.js"></script>

</head>
<body>
	<%@include file="../common/header.jsp"%>

<div class="container" style="text-align: center;">
<h1>연관 주제</h1>
  <svg id="wordcloud" width="960" height="600"></svg>

    <script>
        var words = [ // 단어와 크기 데이터
            {text: "Hello", size: 30},
            {text: "World", size: 20},
            {text: "Normally", size: 25},
            {text: "You", size: 15}
        ];

        var layout = d3.layout.cloud()
            .size([960, 600])
            .words(words)
            .padding(5)
            .rotate(function() { return ~~(Math.random() * 2) * 90; })
            .font("Impact")
            .fontSize(function(d) { return d.size; })
            .on("end", draw);

        layout.start();

        function draw(words) {
          d3.select("#wordcloud").append("g")
              .attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
              .selectAll("text")
              .data(words)
              .enter().append("text")
              .style("font-size", function(d) { return d.size + "px"; })
              .style("font-family", "Impact")
              .attr("text-anchor", "middle")
              .attr("transform", function(d) {
                return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
              })
              .text(function(d) { return d.text; });
        }
    </script>
</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>