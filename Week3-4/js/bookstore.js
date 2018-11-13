window.onload = function(){
    getGenresAJAX();
    document.getElementById('add').addEventListener('click', addBook);
    $('#addGenre').on('click', addGenre);

}

function addGenre(){
    $('#newGenre').removeAttr("hidden");
    $('#newGenre').keydown(function(e){
        if(e.keyCode == 13){
                //write method to add new Genre 
                postGenreAJAX();
            }
    })
}

function postGenreAJAX(){
    let genreObj = { genre : $('#newGenre').val()  };
 //   console.log(genreObj);
    var xhr = new XMLHttpRequest();
    if(xhr.readyState == 4 && xhr.status == 201){ //201 - created
        console.log(xhr.responseText);
    }
    xhr.open("POST","http://localhost:3000/genres", true );
    /*
    Must set this request header! Allows server to properly process 
    request body of the POST request 
    */
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(genreObj));
}



function getGenresAJAX(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var genres = JSON.parse(xhr.responseText);      // Response is an array of genres 
            console.log(genres);
            displayGenres(genres);
        }
    }
    xhr.open("GET", "http://localhost:3000/genres", true);
    xhr.send();

}

function displayGenres(genres){
    //var genres = ["Fiction", "Non-Fiction", "History", "Drama", "Romance"];
    for(let i = 0; i < genres.length; i++) {
        let elem = document.createElement("option");
        elem.value = genres[i].id;
        elem.innerHTML = genres[i].genre;
        document.getElementById('genres').appendChild(elem);
    }
}

var count = 100;
function addBook(){
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