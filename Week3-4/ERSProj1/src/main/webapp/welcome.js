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
//			$('#login').on('click', login);
			$('#createAccount').on('click', createAccount);
		}
	}
	xhr.open("GET", "login.welcomeView", true);
	xhr.send();
}

function createAccount(){
	console.log('In createAccount in welcome.js');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#welcomeView').html(xhr.responseText);
		}
	}
	xhr.open("GET", "create-account.welcomeView", true);
	xhr.send();	
}


//function login(){
//	console.log('In login in welcome.js');
//	var email = $('#inputEmail').val();
//	var password = $('#inputPassword').val();
//	console.log(email);
//	console.log(password);
//}






