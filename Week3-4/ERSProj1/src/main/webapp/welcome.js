/**
 * 
 */

window.onload = function(){
	loadWelcomeView();
	
}

function loadWelcomeView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#welcomeView').html(xhr.responseText);
			$('#login').on('click', login);
		}
	}
	xhr.open("GET", "login.welcomeView", true);
	xhr.send();
}

function login(){
	var email = $('#inputEmail').val();
	var password = $('#inputPassword').val();
	
}