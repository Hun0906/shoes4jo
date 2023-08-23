function showLoading() {
    //화면에 로딩 레이어 추가
    let mask = "<div id='mask' style='display: none;'><img id='mask-img' src='/Shoes4Jo/assets/img/gooey_ring.svg'></div>";
    $('body').append(mask)
 
    $('#mask').css({
	    'z-index': '9999',
	    'position': 'absolute',
	    'height': '100vh',
	    'width': '100%',
	    'background': 'rgba(0, 0, 0, 0.15)',
	    'top': '0',
	    'display': 'flex',
	    'justify-content': 'center',
	    'align-items': 'center',
	    'left': '0',
    }); 
    
    $('#mask-img').css({
    	'width': '8rem',
    	'margin-bottom': '4rem'
    });
  
    //마스크 표시
    $('#mask').show();
}
 
function closeLoading() {
    $('#mask').hide();
}
