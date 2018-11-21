/**
 * 
 */

window.onload = function(){
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#viewAllNav').on('click', loadViewAll);
	$('#ViewResidentsNav').on('click', loadResidentsView);
}

function loadHomeView(){
//	console.log("in LoadHomeView of assignment.js");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();	
}

function loadViewAll(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getAllPlanets();
		}
	}
	xhr.open("GET", "view-all.view", true);
	xhr.send();
}

function getAllPlanets(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let planets = JSON.parse(xhr.responseText).results;
			console.log(planets);
			for (let p of planets){
				var row = document.createElement("tr");
				var name = document.createElement("td");
			    var diameter = document.createElement("td");
			    var volume = document.createElement("td");
			    name.innerText = p.name;
			    diameter.innerText = p.diameter;
			    volume.innerText = ((4/3)*3.14*(Math.pow(((Number(p.diameter))/2),3))).toExponential();
			    row.appendChild(name);
			    row.appendChild(diameter);
			    row.appendChild(volume);
			    document.getElementById("planetsBody").appendChild(row);
			}

		}
	}
	xhr.open("GET", "https://swapi.co/api/planets/", true);
	xhr.send();	
}

function loadResidentsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			loadDropDown();
		}
	}
	
	// Messed up naming my views...
	xhr.open("GET", "view-by-movie.view", true);
	xhr.send();
}

function loadDropDown(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let planets = JSON.parse(xhr.responseText).results;
			for (let p of planets){
				var dropdown = document.createElement("a");
				dropdown.className = "dropdown-item";
				dropdown.innerText = p.name;
				dropdown.setAttribute("onchange", "displayResidents")
//				dropdown.onclick(function(e){
//					console.log("I'm trying to do stuff, but I think I give up." + e.target);
//				});
//				dropdown.on('click', displayResidents);
				document.getElementById("planetDropdown").appendChild(dropdown);
			}
		}
	}
	xhr.open("GET", "https://swapi.co/api/planets/", true);
	xhr.send();	
}

function displayResidents(){
	console.log("in displayResidents()");
	document.getElementById("displayResidents()").innerHTML = "hello";
}





















