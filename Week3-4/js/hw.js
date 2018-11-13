window.onload = function () {
    //function will run as soon as page loads fully

    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('bSort').addEventListener("click", runBubbleSort, true);
    document.getElementById('rStrButton').addEventListener("click", runReverseStr, true);
    document.getElementById('factorialButton').addEventListener("click", runFactorial, true);
    // jQuery
    $('#substringButton').on('click', runSubstring);
    $('#evenButton').on('click', runIsEven);
    $('#palindromeButton').on('click', runIsPalindrome);
    $('#shapeButton').on('click', runPrintShape);
    $('#descendingButton').on('click', runDescending);
    $('#constructorButton').on('click', createPersonWithConstructor);


}
////// PROBLEM 1  
function runFib() {
    //take input and call fibonacci function
    var n = document.getElementById('fibInput').value;
    document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;
}
function fibR(n) {
    if (n == 0 | n == 1) return n;
    return fibR(n - 1) + fibR(n - 2);
}


////// PROBLEM 2
function runBubbleSort() {
    let bubbleString = document.getElementById("bubbleString").value;
    let array = bubbleString.split(",");
    array = array.map(Number);
    document.getElementById("bubbleOutput").innerHTML = `Bubble Sort: ${bubbleSort(array)}`;
}
function bubbleSort(numArray) {
    var temp;
    var didSwap = true;
    while (didSwap == true) {
        didSwap = false;
        for (let i = 0; i < numArray.length; i++) {
            if (numArray[i] > numArray[i + 1]) {
                temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
                didSwap = true;
            }
        }
    }
    return numArray;
}


////// PROBLEM 3 
function reverseStr(someStr) {
    var sArray = someStr.split("");
    var rArray = sArray.reverse();
    var rString = rArray.join("");
    return rString;
}
function runReverseStr() {
    let s = document.getElementById("rString").value;
    document.getElementById("rStringOutput").innerHTML = `Reversed String: ${reverseStr(s)}`;
}


////// PROBLEM 4
function runFactorial() {
    let n = document.getElementById("factorial").value;
    document.getElementById("factorialOutput").innerHTML = `n! = ${factorial(n)}`;
}
function factorial(n) {
    if (n < 0) {
        return "Factorial cannot be computed for negative numbers"
    }
    if (n == 0) {     // base case
        return 1;
    }
    return n * factorial(n - 1);
}


////// PROBLEM 5
function runSubstring() {
    // Using jQuery
    let str = $('#substring').val();
    let length = $('#length').val();
    let offset = $('#offset').val();

    $('#substringOutput').html(`Substring: "${substring(str, length, offset)}"`);
}
function substring(str, length, offset) {
    length = Number(length);
    offset = Number(offset);
    if (offset < 0) {
        return "offset cannot be negative."
    }
    if (length <= 0) {
        return "length of the substring must be a positive number greater than zero."
    }
    console.log(length);
    console.log(offset);
    console.log(str.length);
    if ((length + offset) > str.length) {
        return "offset and length may not be greater than the original string length."
    }
    length = Math.round(length);
    offset = Math.round(offset);
    strArray = str.split("");
    let substr = "";
    for (let i = offset; i < length + offset; i++) {
        substr = substr.concat(str[i]);
    }
    return substr;
}

////// PROBLEM 6
function runIsEven() {
    let n = $('#evenNumber').val();
    $('#evenOutput').html(isEven(n));
}
function isEven(n) {
    if (n.includes(".")) {
        return "A decimal number cannot be even or odd"
    }
    let numArray = n.split("");
    let last = numArray[numArray.length - 1];
    if (last == 0 || last == 2 || last == 4 || last == 6 || last == 8) {
        return "Yes!"
    }
    else {
        return "No"
    }
}


////// PROBLEM 7
function runIsPalindrome() {
    let string = $('#palindrome').val();
    $('#palindromeOutput').html(isPalindrome(string));
}
function isPalindrome(string) {
    let sArray = string.split("");
    sArray = sArray.reverse();
    revString = sArray.join("");
    if (string == revString) {
        return "Yes!"
    }
    else {
        return "No"
    }
}

////// PROBLEM 8
function runPrintShape() {
    let shape = $('#shape').val();
    let height = $('#height').val();
    let character = $('#character').val();
    $('#shapeOutput').html(printShape(shape, height, character));
}
function printShape(shape, height, character) {
    h = Math.round(height);
    if (height <= 0) return "Shape height must be greater than 0."
    switch (shape) {
        case "square":
        case "Square":
            return makeSquare(h, character);
        case "triangle":
        case "Triangle":
            return makeTriangle(h, character);
        case "diamond":
        case "Diamond":
            return makeDiamond(h, character);
            break;
        default:
            return "Must enter either 'square', 'triangle', or 'diamond' for the shape."
    }
}
function makeSquare(h, c) {
    let pattern = "";
    for (let i = 1; i <= h; i++) {
        for (let j = 1; j <= h; j++) {
            pattern = pattern.concat(c);
        }
        pattern = pattern.concat('<br/>');
    }
    return pattern;
}
function makeTriangle(h, c) {
    let pattern = "";
    for (let i = 1; i <= h; i++) {
        for (let j = 1; j <= i; j++) {
            pattern = pattern.concat(c);
        }
        pattern = pattern.concat('<br/>');
    }
    return pattern
}
// AHHHHHH YYYYYYYYYYYYYYY
function makeDiamond(h, c) {
    if (isEven(String(h)) == "Yes") return "Diamond height must be odd";
    let pattern = "";
    // ascend
    var space = h / 2 - 0.5;
    var sPrint = 0;
    var cPrint = 0;
    var columns = h / 2 + 0.5;
    for (let i = 1; i <= h / 2 - 0.5; i++) {
        while (cPrint < columns) {
            if (sPrint < space) {
                pattern = pattern.concat('&nbsp;');
                sPrint++;
            }
            else {
                pattern = pattern.concat(c);
            }
            cPrint++;
        }
        pattern = pattern.concat('<br/>');
        columns++;
        cPrint = 0;
        space--;
        sPrint = 0;
    }
    // full
    for (let z = 1; z <= h; z++) {
        pattern = pattern.concat(c)
    }
    pattern = pattern.concat('<br/>');
    // descend
    columns--;
    space++;
    for (let i = 1; i <= h / 2 - 0.5; i++) {
        while (cPrint < columns) {
            if (sPrint < space) {
                pattern = pattern.concat('&nbsp;');
                sPrint++;
            }
            else {
                pattern = pattern.concat(c);
            }
            cPrint++;
        }
        pattern = pattern.concat('<br/>');
        columns--;
        cPrint = 0;
        space++;
        sPrint = 0;
    }
return pattern;
}



////// PROBLEM 12: Define object using a constructor
function createPersonWithConstructor() {
    let name = $('#name').val();
    let age = $('#age').val();
    var p = new Person(name, age);
    $('#constructorOutput').html(JSON.stringify(p));    // How can you print without stringify?
}
function Person(name, age) {
    this.name = name;
    this.age = age;
};



////// PROBLEM 14: Clock. HOW CAN IT NOT TAKE 1 SECOND TO LOAD?!?!?
$(document).ready(function () {
    setInterval(function () {
        let h = new Date().getHours();
        let m = new Date().getMinutes();
        let s = new Date().getSeconds();
        let ampm = "AM"
        if (m < 10) { m = "0" + m; }
        if (h > 12) {
            h = h % 12;
            ampm = "PM"
        }
        if (s < 10) { s = "0" + s; }
        let time = h + ":" + m + ":" + s + " " + ampm;
        $('#clock').html(`Current Time: ${time}`);
    }, 1000);
});


////// PROBLEM 15
function runDescending() {
    let n = $('#descending').val();
    $('#descendingOutput').html(descending(n));
}
function descending(n) {
    if (n < 0) {
        return "Number input must be positive";
    }
    n = n.toString();
    if (n.includes(".")) {
        n = n.replace('.', '');
    }
    numArray = n.split("");
    numArray = numArray.sort();
    rArray = numArray.reverse();
    numString = rArray.join("");
    return numString;
}
