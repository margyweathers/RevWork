/**
 * 
 */

window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#booksNav').on('click', loadBooksView);
	$('#genreNav').on('click', loadGenreView);
	$('#authorNav').on('click', loadAuthorView);
	
}

function loadHomeView(){
	/*
	 * AJAX functions can be used to retrieve all types 
	 * of data from a server. Including HTML!
	 * We will send a request to a servlet which will 
	 * forward our desired HTML page as a response, 
	 * then, in the onreadystatechange function, we will 
	 * designate what we would like to do with the response 
	 * as usual -- but in this case, we will apply event listeners
	 * to the new DOM elements
	 */
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}
function loadBooksView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "books.view", true);
	xhr.send();	
}

function loadGenreView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
			// manipulate genre view
			getGenres();
			$('#addGenre').on('click', addGenre);
		}
	}
	xhr.open("GET", "genre.view", true);
	xhr.send();	
}

function loadAuthorView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//do things w response
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "author.view", true);
	xhr.send();	
}

function getGenres(){
	//send request to /genres
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let genres = JSON.parse(xhr.responseText);
			for(let g of genres){
				var li = $(`<li>${g.name}</li>`);
				$('#genreList').append(li);
			}
		}
	}
	xhr.open("GET", "genres");
	xhr.send();
}

function addGenre(){
	
	var genre = $('#newGenre').val();
	var obj = {
			name: genre
	};
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status)
			console.log(xhr.responseText)
			console.log(xhr.responseType)
		}
	}
	xhr.open("POST", "genres");
	xhr.send(toSend);
	
	
}





