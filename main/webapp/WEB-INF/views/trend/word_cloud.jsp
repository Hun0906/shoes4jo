<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연관 주제 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script src="<%=context %>/assets/js/script.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3-cloud/1.2.5/d3.layout.cloud.min.js"></script>

<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap"
	rel="stylesheet">

<style>
#wordcloud{
	cursor: default;
	background: #ADE79240;
    border-radius: 5rem;
    box-shadow: 0px 8px 12px 0px #00000010;
    border: 3px solid white;
}

text:hover{
    font-size: 70px !important;
}

#wordcloud-wrapper {
	display: grid;
    justify-items: center;
    gap: 2rem;
}
#wordcloud-wrapper span {
    font-size: 2rem;
}
#wordcloud-wrapper h2 {
    display: inline;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<div class="container" style="text-align: center;">
		<h1>연관 주제</h1>
		
<span id="data" style="display: none;"><c:forEach var="list" items="${list}">{"text":"${list.query}","size":${list.query_value/2+15}},</c:forEach></span>
<div id="wordcloud-wrapper">
	<div>
	<h2>신발</h2><span>에 대한 사람들의 관심사는?</span>
	</div>
	<svg id="wordcloud" width="1024" height="768"></svg>
</div>
	
		
		<script>
		function getRandomGreen() {
		    var r = Math.floor(Math.random() * 172);
		    var g = Math.floor(Math.random() * 50 + 195);
		    var b = Math.floor(Math.random() * 188);

		    return "rgb(" + r + "," + g + "," + b + ")";
		}
		
		var wordsData = "[" + document.getElementById("data").innerHTML.slice(0,-1) + "]";
		var words = JSON.parse(wordsData);

        var layout = d3.layout.cloud()
            .size([1024, 768])
            .words(words)
            .padding(6)
            .rotate(function() { return ~~(Math.random() * 2) * 90; })
            .fontSize(function(d) { return d.size; })
            .on("end", draw);

        layout.start();

        function draw(words) {
            var cloud = d3.select("#wordcloud").append("g")
				.attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
				.selectAll("text")
				.data(words)
				.enter().append("text");

            cloud.style("font-size", function(d) { return d.size + "px"; })
				.style("fill", function(d) { return getRandomGreen(); })
				.style("font-weight", function(d) { return 30 < d.size && d.size < 60? "600" : "400"; })
				.style("font-family", function(d) { return d.size > 60 ? "Black Han Sans" :"Noto Sans KR"; })
				.style("letter-spacing", "-0.1rem")
				.style("text-shadow", function(d) { return d.size > 60 ? "1px 6px 0px #fff" :''; })
				.attr("text-anchor", "middle")
				.style('opacity', '0')
				.attr('transform', function(d) {
				   return 'translate(' + [d.x, d.y] + ')rotate(' + d.rotate + ')';
				})
				.text(function(d) { return d.text; });
				
            cloud.transition()
				.delay(function(){return Math.random()*1000;})
				.duration(1500)
				.ease(d3.easeBounce)
				.attr('transform', function(d) {
					let scale= 1.1;
				    return 'translate(' + [d.x*scale, d.y*scale] + ')rotate(' + d.rotate + ')';
				 })
				.attr('transform', function(d) {
					let scale= 0.9;
				    return 'translate(' + [d.x*scale, d.y*scale] + ')rotate(' + d.rotate + ')';
				 })
				.styleTween('opacity', function() { return d3.interpolate('0', '1'); });
   
        }
    </script>

	</div>
	<%@include file="../common/footer.jsp"%>

</body>
</html>