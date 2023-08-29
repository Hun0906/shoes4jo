<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>글 수정 | SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>

<style>
.form-wrapper {
	max-width: 768px;
}

.table {
	vertical-align: middle;
}

table td:nth-child(1) {
	width: 20%;
	font-weight: bold;
}
</style>
</head>


<body>
	<%@ include file="../common/header.jsp"%>

	<div class="container">
		<h2>상품 정보 수정하기</h2>
		<div class="form-wrapper">
			<form name="goodsUpdate" method="post" enctype="multipart/form-data"
				action="<%=context%>/goodscon/updateOk.do">
<input type='hidden' name='gno' value='${goods.gno}' /> 
				<table class="table table-goods table-hover">

					<tr>
						<td>키워드</td>
						<td><input class="form-control" type="text" name="keyword"
							value="${goods.keyword}"></td>
					</tr>


					<tr>
						<td>카테고리</td>
						<td><select class="form-select" name="category">
								<option value="Sneakers"
									${ goods.category == 'Sneakers' ? 'selected' : '' }>운동화</option>

								<option value="HouseShoes"
									${ goods.category == 'HouseShoes' ? 'selected' : '' }>실내화</option>
								<option value="Slippers"
									${ goods.category == 'Slippers' ? 'selected' : '' }>슬리퍼</option>
								<option value="HikingBoots"
									${ goods.category == 'HikingBoots' ? 'selected' : '' }>등산화</option>
								<option value="Sandals"
									${ goods.category == 'Sandals' ? 'selected' : '' }>샌들</option>
								<option value="military boots"
									${ goods.category == 'military boots' ? 'selected' : '' }>워커</option>
								<option value="Shoes"
									${ goods.category == 'Shoes' ? 'selected' : '' }>구두</option>
								<option value="Boots"
									${ goods.category == 'Boots' ? 'selected' : '' }>부츠</option>
								<option value="RubberBoots"
									${ goods.category == 'RubberBoots' ? 'selected' : '' }>장화</option>
								<option value="WomensShoes"
									${ goods.category == 'WomensShoes' ? 'selected' : '' }>여성신발</option>
								<option value="MensShoes"
									${ goods.category == 'MensShoes' ? 'selected' : '' }>남성신발</option>
								<option value="RunningShoes"
									${ goods.category == 'RunningShoes' ? 'selected' : '' }>런닝화</option>
						</select></td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><input class="form-control" type="text" name="goods_name"
							value="${goods.goods_name}"></td>
					</tr>
					<tr>
						<td>판매처</td>
						<td><input class="form-control" type="text"
							name="seller_name" value="${goods.seller_name}"></td>
					</tr>
					<tr>
						<td>바로가기</td>
						<td><input class="form-control" type="text" name="seller_url"
							value="${goods.seller_url}"></td>
					</tr>
					<tr>
						<td>가격</td>
						<td><input class="form-control" type="text"
							name="goods_price" value="${goods.goods_price}"></td>
					</tr>
					<tr>
						<td>배송비</td>
						<td><input class="form-control" type="text"
							name="delivery_fee" value="${goods.delivery_fee}"></td>
					</tr>
					<tr>
						<td>상품 이미지</td>
						<td><input class="form-control" type="text" name="goods_img"
							value="${goods.goods_img}"></td>
					</tr>


				</table>

				<div class="form-button-wrapper" style="text-align: center;">
					<span class="btn-basic btn-line-basic"
						onclick="location.href = '<%=context%>/goodscon/list.do'">상품
						목록 보기</span> <span class="btn-basic btn-line-basic"
						onclick="history.back()">수정 취소</span> <input type="submit"
						class="btn-basic" value="수정하기">
				</div>

			</form>
		</div>
	</div>

	<%@ include file="../common/footer.jsp"%>
</body>

</html>
