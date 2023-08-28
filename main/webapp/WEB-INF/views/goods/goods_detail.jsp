<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>상품 상세 페이지 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>
<style>
.scroll-table {
	display: block;
	width: 100%;
	overflow-x: auto; /* 스크롤 */
}

.scroll-table table {
	width: 100%;
	table-layout: fixed;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="scroll-table">
		<section class="view" style="padding-left: 100px;">
			<nav>
				<h1>상품 상세정보</h1>
				<p>
					<span>${goods.category}</span>
				</p>
			</nav>
			<article class="info">
				<div class="image">
					<img src="${goods.goods_img}" alt="상품이미지" width="600"
						height="600" />

				</div>


			</article>
		</section>
	</div>
	<div style="padding-top: 50px; padding-left: 150px;">
		<table style="border: 2px solid; width: 85%;">
			<colgroup>
				<col style="width: 25%;" />
				<col style="width: 25%;" />
				<col style="width: 25%;" />
				<col style="width: 25%;" />
			</colgroup>
			<thead>
				<tr>
					<th>판매처</th>
					<th>가격</th>
					<th>배송비</th>
					<th>바로가기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="text-align: center;">${goods.seller_name}</td>
					<td style="text-align: center;">${goods.goods_price}</td>
					<td style="text-align: center;">${goods.delivery_fee}</td>
					<td style="text-align: center;"><a
						href="${goods.seller_url}">바로가기</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>
