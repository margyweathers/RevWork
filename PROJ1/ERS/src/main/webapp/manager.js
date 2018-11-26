/**
 * 
 */
window.onload = function(){
	loadUser();
	loadFrontView();
	$('#homeNav').on('click', loadFrontView);
	$('#pastNav').on('click', loadPastView);
	$('#resolvedNav').on('click', loadResolvedView);
	$('#employeeNav').on('click', loadEmployeesView);
	$('#pendingUsersNav').on('click', loadPendingUsersView);
}

function loadUser(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			console.log(user);
			// String interpolation doesn't work?
//			$('#welcomeMessage').html(`Welcome, ${user.firstName}. Here are your pending reimbursement requests.`);
			$('#welcomeMessage').html('Welcome, ' + user.firstName + '. Here are all pending reimbursement requests.' +
			'<br>Expand a request to approve or deny');
		}
	}
	xhr.open("GET", "user-servlet", true);
	xhr.send();	
}

///////////////////////////////////////////////////////// FORMAT CHILD ROWS /////////////////////////////////////////////////////////////////
//Format child rows for Pending table
function formatPending(d, index){
	// `d` is the original data object for the row
	// child rows for pending reimbursements
	if (d.rStatus == 1){
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
		'<tr>' +
		'<td>Description:</td>' +
		'<td>' + d.rDesc + '</td>' +
		'</tr>' +
		'<tr>' +
		'<td id="resolve' +d.rId+ '"><button onclick="approveRequest('+d.rId+','+index+')" type="button" class="btn btn-success btn-sm">Approve</button>&nbsp&nbsp' +
		'<button onclick="denyRequest(' +d.rId+','+index+ ')" type="button" class="btn btn-danger btn-sm">Deny</button></td>' +
		'</tr>' +
		'</table>'; 
	}
	// child rows for resolved
	else if (d.rStatus == 2){
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
		'<tr>' +
			'<td>Description:</td>' +
			'<td>' + d.rDesc + '</td>' +
		'</tr>' +
		'<tr>' +
			'<td><i>Request Approved</i></td>' +
		'</tr>' +
		'</table>'; 
	}
	else {
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
		'<tr>' +
		'<td>Description:</td>' +
		'<td>' + d.rDesc + '</td>' +
		'</tr>' +
		'<tr>' +
		'<td><i>Request Denied</i></td>' +
		'</tr>' +
		'</table>';
	}
}
//Format child rows for Past and Personally Resolved table
function format(d){
	// `d` is the original data object for the row
	// Child rows for personally resolved
	if (d.rResolver == user.userId){
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
		'<tr>' +
			'<td>Description:</td>' +
			'<td>' + d.rDesc + '</td>' +
		'</tr>' +

		'<tr>' +
			'<td>Resolved By You:</td>' +
			'<td>' + d.resolveDate + '</td>' +
		'</tr>' +       
		'</table>';
	}
	// child rows for all past
	else{
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
		'<tr>' +
			'<td>Description:</td>' +
			'<td>' + d.rDesc + '</td>' +
		'</tr>' +
		'<tr>' +
			'<td>Resolved By:</td>' +
			'<td>' + d.rResolver + ' on '+ d.resolveDate + '</td>' +
		'</tr>' +       
		'</table>'; 
	}
}

function formatResolved(d){
	return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
	'<tr>' +
		'<td>Description:</td>' +
		'<td>' + d.rDesc + '</td>' +
	'</tr>' +      
	'</table>'; 
}

/////////////////////////////////////////////////////////////// APPROVE/DENY //////////////////////////////////////////////////////////////
function approveRequest(id, index){
	var obj ={
			rId : id
	}
	var idToApprove = JSON.stringify(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#resolve' + id).html('<i>Request Approved</i>');
			rdata[index].rStatus = 2;		// Change the status in rData so it displays correctly in the table
		}		
	}
	xhr.open("POST", "approve-request", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(idToApprove);		
}
function denyRequest(id, index){
	var obj ={
			rId : id
	}
	var idToDeny = JSON.stringify(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#resolve' + id).html('<i>Request Denied</i>');
			rdata[index].rStatus = 3;		// Change the status in rData so it displays correctly in the table
		}		
	}
	xhr.open("POST", "deny-request", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(idToDeny);		
}

/////////////////////////////////////////////////////////////////FRONT VIEW ////////////////////////////////////////////////////////////////
function loadFrontView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#managerView').html(xhr.responseText);
			// Why isn't user defined here?
			loadPending(pendingCallback);
		}
	}
	xhr.open("GET", "front.managerView", true);
	xhr.send();
}

function pendingCallback(pending){
	rdata = pending;		// Can this be global?
	// Manipulate reimbursement objects to dynamically load types
//	getRType(rdata, typeCallback)
	console.log(rdata);
	var table = $('#pending').DataTable({
		"data": rdata,
		retrieve: true,
		select:"single",
		"columns": [
			{
				"className": 'details-control',
				"orderable": false,
				"data": null,
				"defaultContent": '',
				"render": function () {
					return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
				},
				width:"15px"
			},
			{ "data": "author" },
			{ "data": "rType" },
			{ "data": "amount" },
			{ "data": "submitDate"}
			],
			"order": [[1, 'asc']]
	});
//	Add event listener for opening and closing details
	$('#pending tbody').on('click', 'td.details-control', function () {
		var tr = $(this).closest('tr');
		var tdi = tr.find("i.fa");
		var row = table.row(tr);

		if (row.child.isShown()) {
			// This row is already open - close it
			row.child.hide();
			tr.removeClass('shown');
			tdi.first().removeClass('fa-minus-square');
			tdi.first().addClass('fa-plus-square');
		}
		else {
			// Open this row
			var index = row[0][0];	// This is the index of the table row, which corresponds rdata array!
			row.child(formatPending(row.data(), index)).show();	// Pass the index into formatPending()
			tr.addClass('shown');
			tdi.first().removeClass('fa-plus-square');
			tdi.first().addClass('fa-minus-square');
		}
	});

	table.on("user-select", function (e, dt, type, cell, originalEvent) {
		if ($(cell.node()).hasClass("details-control")) {
			e.preventDefault();
		}
	});		
}

function loadPending(callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pending = JSON.parse(xhr.responseText);
			if(callback) callback(pending);		// if statement checks if function param exists?
		}
	}
	xhr.open("POST", "get-all-pending");
	xhr.send();
}

//Reimbursement Type callback function
function typeCallback(data, types){
	for (let r of data){
		console.log((types[r.rType-1]).type);
		r.rType = (types[r.rType-1]).type;
	}
	rdata = data;
	console.log(rdata);
}
function getRType(rdata, callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let types = JSON.parse(xhr.responseText);
			if(callback) callback(rdata, types);
		}
	}
	xhr.open("GET", "r-type", true);
	xhr.send();
}

/////////////////////////////////////////////////////////////////PAST VIEW ////////////////////////////////////////////////////////////////////////
function loadPastView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#managerView').html(xhr.responseText);
			loadPast(pastCallback);
		}
	}
	xhr.open("GET", "past.managerView", true);
	xhr.send();	
}

function pastCallback(past){
	rdata = past;		// Can this be global?
	var table = $('#pending').DataTable({
		"data": rdata,
		retrieve: true,
		select:"single",
		"columns": [
			{
				"className": 'details-control',
				"orderable": false,
				"data": null,
				"defaultContent": '',
				"render": function () {
					return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
				},
				width:"15px"
			},
			{ "data": "author" },
			{ "data": "rType" },
			{ "data": "amount" },
			{ "data": "submitDate"},
			{ "data": "resolveDate"},
			{ "data": "rStatus"}
			],
			"order": [[1, 'asc']]
	});
//	Add event listener for opening and closing details
	$('#pending tbody').on('click', 'td.details-control', function () {
		var tr = $(this).closest('tr');
		var tdi = tr.find("i.fa");
		var row = table.row(tr);

		if (row.child.isShown()) {
			// This row is already open - close it
			row.child.hide();
			tr.removeClass('shown');
			tdi.first().removeClass('fa-minus-square');
			tdi.first().addClass('fa-plus-square');
		}
		else {
			// Open this row
			row.child(format(row.data())).show();
			tr.addClass('shown');
			tdi.first().removeClass('fa-plus-square');
			tdi.first().addClass('fa-minus-square');
		}
	});

	table.on("user-select", function (e, dt, type, cell, originalEvent) {
		if ($(cell.node()).hasClass("details-control")) {
			e.preventDefault();
		}
	});	
}

function loadPast(callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var past = JSON.parse(xhr.responseText);
			if(callback) callback(past);		// if statement checks if function param exists?
		}
	}
	xhr.open("POST", "get-all-past", true);
	xhr.send();
}

////////////////////////////////////////////////////PERSONALLY RESOLVED VIEW //////////////////////////////////////////////////////////////////
function loadResolvedView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#managerView').html(xhr.responseText);
			loadResolved(resolvedCallback);
		}
	}
	xhr.open("GET", "resolved.managerView", true);
	xhr.send();	
}

function resolvedCallback(resolved){
	rdata = resolved;		// Can this be global?
	var table = $('#pending').DataTable({
		"data": rdata,
		retrieve: true,
		select:"single",
		"columns": [
			{
				"className": 'details-control',
				"orderable": false,
				"data": null,
				"defaultContent": '',
				"render": function () {
					return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
				},
				width:"15px"
			},
			{ "data": "author" },
			{ "data": "rType" },
			{ "data": "amount" },
			{ "data": "submitDate"},
			{ "data": "resolveDate"},
			{ "data": "rStatus"}
			],
			"order": [[1, 'asc']]
	});
//	Add event listener for opening and closing details
	$('#pending tbody').on('click', 'td.details-control', function () {
		var tr = $(this).closest('tr');
		var tdi = tr.find("i.fa");
		var row = table.row(tr);

		if (row.child.isShown()) {
			// This row is already open - close it
			row.child.hide();
			tr.removeClass('shown');
			tdi.first().removeClass('fa-minus-square');
			tdi.first().addClass('fa-plus-square');
		}
		else {
			// Open this row
			row.child(formatResolved(row.data())).show();
			tr.addClass('shown');
			tdi.first().removeClass('fa-plus-square');
			tdi.first().addClass('fa-minus-square');
		}
	});

	table.on("user-select", function (e, dt, type, cell, originalEvent) {
		if ($(cell.node()).hasClass("details-control")) {
			e.preventDefault();
		}
	});	
}

function loadResolved(callback){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var resolved = JSON.parse(xhr.responseText);
			if(callback) callback(resolved);		// if statement checks if function param exists?
		}
	}
	xhr.open("POST", "get-past-by-resolver", true);
	xhr.send();
}

//////////////////////////////////////////////////// ALL EMPLOYEES VIEW //////////////////////////////////////////////////////////////////////
function loadEmployeesView(){

}

//////////////////////////////////////////////////// PENDING EMPLOYEES VIEW //////////////////////////////////////////////////////////////////
function loadPendingUsersView(){

}





