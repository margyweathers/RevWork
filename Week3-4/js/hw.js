window.onload = function(){
    //function will run as soon as page loads fully
    
    document.getElementById('runFib').addEventListener("click", runFib, true);
    document.getElementById('bSort').addEventListener("click", runBubbleSort, true);
    document.getElementById('rStrButton').addEventListener("click", runReverseStr, true);

    }
     ////// PROBLEM 1  
    function runFib(){
        //take input and call fibonacci function
        var n = document.getElementById('fibInput').value;
        document.getElementById("fibOutput").innerHTML = `fib(n) = ${fibR(n)}`;
    }  
    function fibR(n){
        if(n == 0 | n == 1) return n;
        return fibR(n-1) + fibR(n-2);
    }


    ////// PROBLEM 2
    function runBubbleSort(){
        let bubbleString = document.getElementById("bubbleString").value;
        let array = bubbleString.split(",");
        array = array.map(Number);
        document.getElementById("bubbleOutput").innerHTML = `Bubble Sort: ${bubbleSort(array)}`;
    }
    
    function bubbleSort(numArray){
        var temp;
        var didSwap = true;
        while(didSwap == true){
            didSwap = false;
            console.log("in while");
            for(let i = 0; i < numArray.length; i++){
                if(numArray[i] > numArray[i+1]){
					temp = numArray[i];
					numArray[i] = numArray[i+1];
					numArray[i+1] = temp;
					didSwap = true;
				}
            }
        }
        return numArray;
    }


    ////// PROBLEM 3 
    function reverseStr(someStr){
        var sArray = someStr.split("");
        var rArray = sArray.reverse();
        var rString = rArray.join("");
        return rString;
    }
    function runReverseStr(){
        let s = document.getElementById("rString").value;
        document.getElementById("rStringOutput").innerHTML = `Reversed String: ${reverseStr(s)}`;
    }


    ////// PROBLEM 4
    function factorial(n){
        
    }


