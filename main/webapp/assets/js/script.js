function showLoading() {
    //화면에 로딩 레이어 추가
    let mask = "<div id='mask' style='display: none;'><img id='mask-img' src='/Shoes4Jo/assets/img/gooey_ring.svg'></div>";
    $('body').css({
    	'overflow': 'hidden',
    })
 
    $('body').append(mask)
    $('#mask').css({
	    'z-index': '9999',
	    'position': 'absolute',
	    'height': '150%',
	    'width': '100%',
	    'backdrop-filter': 'brightness(0.85) blur(2px)',
	    'top': '0',
	    'display': 'flex',
	    'justify-content': 'center',
	    'align-items': 'center',
	    'left': '0',
    }); 
    
    $('#mask-img').css({
    	'width': '8rem',
    	'margin-bottom': '50vh'
    });
  
    //마스크 표시
    $('#mask').show();
}
 
function closeLoading() {
    $('#mask').hide();
}
