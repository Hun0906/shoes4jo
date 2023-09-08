<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta charset="UTF-8" />
<title>상품 상세 페이지 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

<script>
$(document).ready(
	function() {
		var gno = "${goods_list[0].gno}";
		var keyword = "${goods_list[0].keyword}";

		if (!gno) {
			alert("상품 상세 정보가 없습니다.");
			history.back();
		}
	  		
		$("#bookmark").click(function() {
		  	if ("<%=sessionID%>" != null && "<%=sessionID%>" != "null") {
				$.ajax({
					url : "<%=context%>/bookmarkcon/insert.do",
					type : "POST",
					data : JSON.stringify({
						gno : gno,
						keyword : keyword
					}),
					contentType : "application/json; charset=UTF-8",
					dataType : "json",
					success : function(data) {
						console.log('Response data:', data);
						if (data.result == 1) {
							alert("북마크에 추가되었습니다.");
							$("#bookmark").attr("src", "<%=context%>/assets/icon/heart_icon.svg");
						} else if (data.result == -1) {
							alert("북마크에서 제거되었습니다.");
							$("#bookmark").attr("src", "<%=context%>/assets/icon/emptyheart_icon.svg");
						}
					},
					error : function(xhr, status, error) {
						console.error('Error', status, error.toString());
					}
				});
		  	} else {
		  		if (confirm("로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?")){
		  			location.href="<%=context%>/login"
		  		}
		  	}
		});
	});
</script>

<style>
.grid {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 2rem;
}

.grid img {
	aspect-ratio: 1/1;
	width: 100%;
}

.grid p {
	text-align: left;
	font-size: 1.1em;
	background: white;
	width: fit-content;
	padding: 0 0.65rem;
	border-radius: 8px;
	border: 2px solid #6ECCAF;
	color: #6ECCAF;
	cursor: default;
	margin: 0;
}

.bookmark {
	display: flex;
	margin: 1rem 0;
}

.bookmark img {
	width: 2.5rem;
	cursor: pointer;
	margin-top: 0.3rem;
}

.bookmark h2 {
	margin: 0.8rem;
}

table {
	width: 100%;
	overflow-x: scroll;
}

td {
	padding: 10px !important;
	border-width: 1px;
	border-color: black;
}

th {
	background: black;
	padding: 10px !important;
	color: white;
	border-width: 1px;
	border-color: white;
}

@media ( max-width :1024px) {
	.grid {
		grid-template-columns: repeat(1, 1fr);
		padding: 0 2rem;
	}
}
</style>


</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<h1>상품 상세정보</h1>
		<div class="grid">
			<img src="${goods_list[0].goods_img}" alt="상품이미지" width="100%" />
			<div>
				<p>${goods_list[0].category}</p>
				<div class='bookmark'>
					<img src='<%=context%>/assets/icon/${img}_icon.svg'
						id="bookmark" alt='Bookmark' title="즐겨찾기"/>
					<h2>${goods_list[0].goods_name}</h2>
				</div>
				<hr>
				<div>
					<table class="table-hover">
						<thead>
							<tr>
								<th>판매처</th>
								<th>가격</th>
								<th>배송비</th>
								<th style="width: 8rem;">쇼핑몰</th>
							</tr>
						</thead>

						<c:forEach var='goods' items='${goods_list}'>
							<tbody>
								<tr>
									<td>${goods.seller_name}</td>
									<td><fmt:formatNumber value="${goods.goods_price}"
											pattern="#,###" />원</td>
									<td><fmt:formatNumber value="${goods.delivery_fee}"
											pattern="#,###" />원</td>
									<td><a href="${goods.seller_url}">🛒바로가기</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../common/footer.jsp"%>

</body>
</html>