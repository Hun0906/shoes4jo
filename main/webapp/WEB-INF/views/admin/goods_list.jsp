<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 | SHOES4JO</title>
<%@include file="../common/header-head.jsp"%>

</head>

<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<h2>등록 상품 목록</h2>
		<div style="text-align: right">
        	<button
            onclick="location.href='<%=request.getContextPath()%>/goodscon/insert.do'"
            class="btn-basic">새 상품 등록</button>
        </div>
		<table class="table table-board table-hover">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>판매처</th>
					<th>가격</th>
					<th>배송비</th>
					<th>등록일</th>
					<th>카테고리</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="goods" items="${goods_list}">
					<tr>
						<td>${goods.gno }</td>
<td><a href="<%=context %>/goodscon/view.do?keyword=${goods.keyword}">${goods.goods_name}</a></td> 
						<td>${goods.seller_name}</td>
						<td>${goods.goods_price}</td>
						<td>${goods.delivery_fee}</td>
						<td>${goods.date.substring(0,11)}</td>
						<td>${goods.category}</td>

<td><a href="<%=context %>/goodscon/update.do?keyword=${goods.keyword}" class="button">수정</a><br>
<a href="<%=context %>/goodscon/delete.do?gno=${goods.gno}" onclick='return confirm("등록한 상품을 삭제하시겠습니까?")' >삭제</a><br>
<a href="<%=context %>/goodscon/deleteByKeyword.do?keyword=${ goods.keyword }" onclick='return confirm("해당 키워드의 모든 상품을 삭제하시겠습니까?")'>키워드 전체 삭제</a></td>


					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
	
	
	
				<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a class="page-link"
						href="<%=context %>/goodscon/list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
				</c:if>


				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="idx">
					<c:choose>
						<c:when test="${idx eq pageMaker.cri.page}">
							<li class="active"><a class="page-link"
								href="<%=context %>/goodscon/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="page-link"
								href="<%=context %>/goodscon/list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>


				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a class="page-link"
						href="<%=context %>/goodscon/list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
				</c:if>

			</ul>
			
			

	<%@include file="../common/footer.jsp"%>
</body>
</html>
