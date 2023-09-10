<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
request.setAttribute("lineSeparator", System.getProperty("line.separator"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${freeboard.title.length() > 10 ? freeboard.title.substring(0, 10).concat("...") : freeboard.title}
	| SHOES4JO</title>
<%@ include file="../common/header-head.jsp"%>

<link rel="stylesheet" type="text/css"
	href="<%=context%>/assets/css/freeboard_view.css">
<script src="https://cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>

var loginCheck = '${sessionScope.memberInfo}';


function checkDelete(fno) {
    var remove = confirm("글을 삭제하시겠습니까?");
    if (remove) {
        location.href = '<%=context%>/freeboard/delete.do?fno=' + fno;
    }
}

</script>
</head>

<body>
	<%@ include file="../common/header.jsp"%>

	<div class="container">
		<div class="form-wrapper">
			<div style="display: flex; justify-content: space-evenly;">
				<a href="<%=context%>/freeboard/list.do?category=${freeboard.category}"
					style="font-size: 1.2rem;"><b>${freeboard.category}</b></a>
			</div>
			<p style="font-size: 2.2rem; margin-top: 1.5rem; font-weight: 500;">${freeboard.title}</p>
			<div
				style="display: flex; justify-content: space-between; color: #999">
				<div>
					<b>작성자</b> ${freeboard.member_id}
				</div>
				<div>${freeboard.viewcnt}Views|${freeboard.date.substring(0, 10)}</div>
			</div>

			<div class="line"></div>

			<div class="content" style="padding: 0 2rem; line-height: 1.8;">
				<div class="thumb">
					<c:if
						test="${freeboard.file_path != null && not empty freeboard.file_path}">
						<img src="<%=context%>/assets/img/${freeboard.file_path}">
					</c:if>
				</div>
			</div>
			<p> <c:out
					value="${fn:replace(freeboard.content, requestScope.lineSeparator, '<br/>')}"
					escapeXml="false" /></p>



			<!-- 댓글창 시작 -->
			<div class="comment-box">

				<div class="comment-count">
					😀 댓글 수 😀 <span id="count">0 </span> 개
				</div>
				<div class="comment-sbox">
					<textarea class="comment-input" id="content" cols="80" rows="2"
						name="content"></textarea>
				</div>
				<div class="regBtn">
					<button id="Comment_regist" class="btn-basic">댓글 등록</button>
				</div>
			</div>



			<div class="comment_Box" style="border: 3px solid gray;">
				<!-- 댓글이 들어갈 박스 -->
				<c:forEach var="comment" items="${comments}">
					<p style="text-indent: 0;">${comment.content}</p>

					<small>등록일: <fmt:formatDate value="${comment.date}"
							pattern="yyyy-MM-dd HH:mm:ss" /> | 수정일: <fmt:formatDate
							value="${comment.update_date}" pattern="yyyy-MM-dd HH:mm:ss" /></small>
					<!-- 날짜 출력 안되는 문제 알아보기 -->
					<c:if test="${sessionScope.memberInfo == comment.member_id}">
						<button onClick="edit(${comment.cno})" class="badge">수정</button>
						<button onClick="delete(${comment.cno})" class="badge">삭제</button>
					</c:if>
				</c:forEach>
			</div>
			<!-- 댓글창 끝 -->


			<!-- 본인 아이디 확인 후 글 수정,삭제창 보이게 함-->
			<div class="line"></div>

			<div class="form-button-wrapper">
				<c:if test="${sessionScope.memberInfo == freeboard.member_id}">
					<span class="btn-basic btn-line-red"
						onclick="checkDelete(${freeboard.fno})">삭제하기</span>
					<button class="btn-basic"
						onclick="location.href='<%=context%>/freeboard/update.do?fno=${freeboard.fno}'">수정하기</button>
				</c:if>
			</div>
			<!-- 본인 아이디 확인 후 글 수정,삭제창 끝-->
			<div class="form-button-wrapper">
				<button class="btn-basic btn-line-basic"
					onclick="location.href='<%=context%>/freeboard/list.do'">글
					목록 보기</button>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>



<script>

var fno = '${freeboard.fno}'; 
var loginCheck = '${sessionScope.memberInfo}';

$('#Comment_regist').click(function() {
    if (fno === 'undefined' || fno === '') {
        console.error('게시물 번호 못찾음');
        return;
    }

    const member_id = loginCheck; 
    const content = $('#content').val();

    if(member_id == ''){
        alert('로그인 후 이용해주세요');
        return;
    } else if(content == '') {
        alert('내용을 입력하세요');
        return;
    }

    $.ajax({
        type:'post',
        url:'<c:url value="/comment/insert.do"/>',
        data: JSON.stringify({
            "fno":fno,
            "member_id":member_id,
            "content":content
        }),
        contentType: 'application/json',
        success:function(data){
        	
        	console.log(`Received response: ${data}`); 
        	
            if(data === 'insertOk') {
                alert('댓글 등록이 완료되었습니다.');
                $('#member_id').val(member_id);
                $('#content').val('');
                getList();
            } else {
                alert('로그인 이후 이용해주시기 바랍니다.');
            }
         },
         error:function(){
             alert('통신 실패');
         }
     });
 });

 getList();

 function getList() {
	    const fno = ${freeboard.fno};
	    const member_id = $('#member_id').val();
	    const content = $('#content').val();

	    $.getJSON("<%=request.getContextPath()%>/comment/CommentList/"+fno, function(data) {
	        if(data.total > 0){
	            var list = data.list;
	            var comment_html = "<div>";
	            $('#count').html(data.total);
	            for(i = 0;i < list.length;i++){
	                var content=list[i].content;
	                var member_id=list[i].member_id;

	                comment_html += "<div><span id='member_id'><strong>" + member_id + "</strong></span><br/>";
	                comment_html += "<span id='com-content'>" + content + "</span><br>";
	                 
	                if(loginCheck === list[i].member_id){
	                    comment_html += "<span class='edit' style='cursor:pointer;' data-id =" + list[i].cno+">[수정]</span>";
	                    comment_html += "<span class='delete' style='cursor:pointer;' data-id =" + list[i].cno+">[삭제]</span><br></div><hr>";
	                } else{
	                    comment_html += "</div><hr>";
	                }
	            }

	            $(".comment_Box").html(comment_html);

	        } else{
	              var comment_html="<div>등록된 댓글이 없습니다.</div>";
	              $(".comment_Box").html(comment_html);
	        }
	    });
	} // getList() 종료

	
	
	function editComment(cno, newContent) {
	    $.ajax({
	        type: 'post',
	        url: '<%=request.getContextPath()%>/comment/update.do/' + cno,
	        data: JSON.stringify({
	            "content": newContent
	        }),
	        contentType: 'application/json',
	        success:function(data){
	            if (data === 'updateOk') {
	                alert('댓글이 수정되었습니다');
	                getList();
	            } 
	         },
	         error:function(){
	             alert('통신 실패');
	         }
	    });
	}


	
	function deleteComment(cno) {
	    const confirmDelete = confirm('댓글을 삭제하시겠습니까?');
	    if (!confirmDelete) return;

	    $.ajax({
	        type: 'post',
	        url: '<%=request.getContextPath()%>/comment/delete.do/' + cno,
	        success: function(data){
	            if (data === 'deleteOk') {
	                alert('댓글이 삭제되었습니다');
	                getList();
	            } else {
	                alert('댓글 삭제 실패');
	            }
	        },
	        error:function(){
	            alert('통신 실패');
	        }
	    });
	}
	
	
	
	$(document).on("click", ".edit", function(){
	    const cno = $(this).data("id");
	    const contentElement = $(this).siblings("#com-content");

	    const oldContent = contentElement.text();
	    contentElement.html(`<input type="text" id="edit-field-${cno}" value="${oldContent}"> <button class="btn-basic save-edit" data-id="${cno}">저장</button>`);
	});

	$(document).on("click", ".save-edit", function(){
	   const cno = $(this).data("id");

	   const newContent = $("#edit-field-" + cno).val();

	   editComment(cno, newContent);
	});

	$(document).on("click", ".delete", function(){
	   const cno = $(this).data("id");
	   deleteComment(cno);
	});
</script>

</html>
