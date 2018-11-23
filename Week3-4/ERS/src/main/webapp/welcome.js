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
			$('#welcomeView').html(xhr.responseText);
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








