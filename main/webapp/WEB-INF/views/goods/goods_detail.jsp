<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
    <meta charset="UTF-8">
    <title>상품 상세페이지 | SHOES4JO</title>
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
                신발 &gt;
                <span>아동</span>
                &gt;
                <strong>운동화</strong>
            </p>
        </nav>
        <article class="info">
            <div class="image">
                <img src="https://via.placeholder.com/460x460" alt="상품이미지">
            </div>
            <div class="summary">
                </div>
                <div class="button">
                    <input type="button" class="bookmark" value="즐겨찾기" formaction = "bookmark/insert.do">
                </div>
            </div>
        </article>
    </section>
</div>

<div style="padding-top: 50px; padding-left: 150px;">
	<table style="border: 2px solid; width: 85%">
		<colgroup>
			<col style="width: 25%;"/>
			<col style="width: 25%;"/>
			<col style="width: 25%;"/>
			<col style="width: 25%;"/>
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
				<td style="text-align: center;">${goodsInfo.seller_name}</td>
				<td style="text-align: center;">${goodsInfo.goods_price}</td>
				<td style="text-align: center;">${goodsInfo.delivery_fee}</td>
				<td style="text-center"><a href="${goodsInfo.seller_url}">바로가기</a></td>
			</tr>
		</tbody>
	</table>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>
