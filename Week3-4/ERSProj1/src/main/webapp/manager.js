/**
 * 
 */
window.onload = function(){
	loadFrontView();
	loadUser();
	$('#homeNav').on('click', loadFrontView);
	$('#allNav').on('click', loadAllView);
	$('#pastNav').on('click', loadPastView);
	$('#submitNav').on('click', loadSubmitView);
}