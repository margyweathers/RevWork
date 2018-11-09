window.onload = function () {
    loadGenres();
    document.getElementById('add').addEventListener('click', addBook);
}

function getGenresAJAX(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readystate == 4 && xhr.status == 200) {
            var genres = JSON.parse(xhr.responseText);
            console.log(genres);
        }
    }
    xhr.open("GET", "http://localhost:3000/genres", true);
    xhr.send();
}

    function loadGenres() {
        var genres = ["Fiction", "Non-Fiction", "History", "Drama", "Romance"];
        for (let i = 0; i < genres.length; i++) {
            let elem = document.createElement("option");
            elem.value = genres[i];
            elem.innerHTML = genres[i];
            document.getElementById('genres').appendChild(elem);
        }
    }




var count = 100;
function addBook() {
    //get data from input values
    var isbn = document.getElementById('isbn').value;
    var title = document.getElementById('title').value;
    var price = document.getElementById('price').value;
    var genre = document.getElementById('genres').value;
    var id = count++;

    //generate new DOM elements
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    //add data to cells 
    cell1.innerText = id;
    cell2.innerText = isbn;
    cell3.innerText = title;
    cell4.innerText = price;
    cell5.innerText = genre;
    //append each element to its parent 
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    document.getElementById("tablebody").appendChild(row);
}