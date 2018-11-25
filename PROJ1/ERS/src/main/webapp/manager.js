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

//Format's child rows. Used for all tables
function format(d){   
    // `d` is the original data object for the row
	// child rows for pending reimbursements
	if (d.rStatus == 1){
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
        '<tr>' +
            '<td>Description:</td>' +
            '<td>' + d.rDesc + '</td>' +
        '</tr>' +
        '<tr>' +
        '<td><button type="button" class="btn btn-success btn-sm">Success</button>&nbsp&nbsp<button type="button" class="btn btn-danger btn-sm">Danger</button></td>' +
        '</tr>' +
    '</table>'; 
	}
	// child rows for personally resolved
	else if ((d.rStatus == 2 || d.rStatus == 3) && d.rResolver == user.rId){
		
	}
	// child rows for all approved/denied
	else{
		return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
        '<tr>' +
            '<td>Description:</td>' +
            '<td>' + d.rDesc + '</td>' +
        '</tr>' +
        
        '<tr>' +
        '<td>Resolved By:</td>' +
        '<td>' + d.rResolver + ' ('+ d.resolveDate + ')' + '</td>' +
        '</tr>' +
        
    '</table>'; 
	}
}

////////////////////////////////////////////////////////FRONT VIEW //////////////////////////////////////////////////////////
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





////////////////////////////////////////////////////////PAST VIEW //////////////////////////////////////////////////////////
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
	rdata = pending;		// Can this be global?

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

function loadResolvedView(){
	
}

function loadEmployeesView(){
	
}


function loadPendingUsersView(){
	
}





