<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goods_list | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>

<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
        <button
            onclick="location.href='<%=request.getContextPath()%>/goodscon/insert.do'"
            class="btn-basic">새 상품 등록</button>

		<h2 class="text-center">등록 상품 목록</h2>
		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th class="text-center">상품번호</th>
					<th class="text-center">상품명</th>
					<th class="text-center">판매처</th>
					<th class="text-center">가격</th>
					<th class="text-center">배송비</th>
					<th class="text-center">등록일</th>
					<th class="text-center">카테고리</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="goods" items="${goods_list}">
					<tr>
						<td class="text-center">${goods.gno }</td>
<td class="text-center"><a href="<%=context %>/goodscon/view.do?keyword=${goods.keyword}">${goods.goods_name}</a></td> 
						<td class="text-center">${goods.seller_name}</td>
						<td class="text-center">${goods.goods_price}</td>
						<td class="text-center">${goods.delivery_fee}</td>
						<td class="text-center">${goods.date.substring(0,11)}</td>
						<td class="text-center">${goods.category}</td>

<td class="text-center"><a href="<%=context %>/goodscon/update.do?keyword=${goods.keyword}" class="butten">수정하기</a></td> 

<td class='text-center'><a href="<%=context %>/goodscon/delete.do?gno=${goods.gno}" onclick='return confirm("등록 상품을 삭제하시겠습니까?")' >삭제하기</a></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

	<%@include file="../common/footer.jsp"%>
</body>
</html>
