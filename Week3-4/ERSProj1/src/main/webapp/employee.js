/**
 * onload loads employee home view and initiates user as a global variable
 */
window.onload = function(){
	loadFrontView();
	loadUser()
}

function loadFrontView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#employeeView').html(xhr.responseText);
			
		}
	}
	xhr.open("GET", "front.employeeView", true);
	xhr.send();
}

function loadUser(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			console.log(user);
			// String interpolation doesn't work?
//			$('#welcomeMessage').html(`Welcome, ${user.firstName}. Here are your pending reimbursement requests.`);
			$('#welcomeMessage').html('Welcome, ' + user.firstName + '. Here are your pending reimbursement requests.');
			loadPending();
		}
	}
	xhr.open("GET", "user-servlet", true);
	xhr.send();	
}

function loadPending(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);	// log pending for debug
			let pending = JSON.parse(xhr.responseText);
			for (let r of pending){
				var row = document.createElement("tr");
				var date = document.createElement("td");
				var type = document.createElement("td");
				var amount = document.createElement("td");
				var desc = document.createElement("td");
				date.innerText = r.submitDate;
				type.innerText = r.rType;
				amount.innerText = r.amount;
				desc.innerText = r.rDesc;
				row.appendChild(date);
				row.appendChild(type);
				row.appendChild(amount);
				row.appendChild(desc);
				document.getElementById("rPendingTable").appendChild(row);
			}
		}
	}
	xhr.open("POST", "reimbursement-servlet");
	xhr.send();	
	
}







