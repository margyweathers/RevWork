window.onload = function(){
// function will run as soon as page loads fully
// alert("page has loaded");
// console.log("in the console")

document.getElementById('runfib').addEventListener("click", runfib, true);

}

function runfib(){
    // take input and call fibonacci function
    var n = document.getElementById("fibInput").value;
    console.log(n);
    console.log(`fib(n) = ${fibR(n)}`);
}

function fibR(n){
    if(n == 0 | n == 1) return n;
    return fibR(n-1) + fibR(n-2);
}



var gvar = 'This is a global variable';



