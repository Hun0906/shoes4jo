<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="utf-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>

$(document).ready(function(){
    var gno = "${goods_list[0].gno}";
    var keyword = "${goods_list[0].keyword}"; 

    $("#bookmark").click(function(){
        $.ajax({
            url: "/bookmarkcon/insert.do",
            type: "POST",
            data: JSON.stringify({gno: gno, keyword: keyword}), 
            contentType: "application/json; charset=UTF-8",
            dataType: "json", 
            success: function(data) {
                console.log('Response data:', data);
                if(data.result == 1) {  
                    alert("북마크에 추가되었습니다.");
                    $("#bookmark img").attr("src", "/assets/icon/heart_icon.svg");
                } else if (data.result == -1) {   
                    alert("북마크에서 제거되었습니다.");
                    $("#bookmark img").attr("src", "/assets/icon/emptyheart_icon.svg");
                }
            },
	    error : function(xhr, status, error) {
		console.error('Error', status, error.toString());
	    }
        });
    });
});


</script> 


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

		<section class="view" style="padding-left: 100px;">
			<nav>
				<h1>상품 상세정보</h1>
				<p>
					<span>${goods_list[0].category}</span>
				</p>
			</nav>
			<article class="info">
				<div class="image">
					<img src="${goods_list[0].goods_img}" alt="상품이미지" width="600"
						height="600" />
				</div>
				
				
                <div class='bookmark'>
                    <button id='bookmark' style='background:none;border:none;'>
                        <img src='/assets/icon/emptyheart_icon.svg' alt='Bookmark' style='width:70px;height:70px;cursor:pointer;'/>
                    </button>    
                </div>	
			</article>
		</section>
		
		
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

						<th style="text-align: center;">판매처</th>
						<th style="text-align: center;">가격</th>
						<th style="text-align: center;">배송비</th>
						<th style="text-align: center;">바로가기</th>
					</tr>
				</thead>


				<c:forEach var='goods' items='${goods_list}'>
					<tbody>
						<tr>

							<td style="text-align: center;">${goods.seller_name}</td>
							<td style="text-align: center;">${goods.goods_price}</td>
							<td style="text-align: center;">${goods.delivery_fee}</td>
							<td style="text-align: center;"><a
								href="${goods.seller_url}">바로가기</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

		<%@include file="../common/footer.jsp"%>
		

</body>
</html>