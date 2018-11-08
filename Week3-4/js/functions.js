/*
ABOUT JS FUNCTIONS
- functions inherit from objects and may be passed as variables 
or stored just like any other value 
- no function overloading in JS -- last function is used 
missing parameters are set to undefined 
extra parameters are ignored
- this keyword. "this" represents what the function is bound to 
at invocation time 
*/

function func(){
    console.log("inside of regular function");
}
func();

// Function Expression: function name can be comitted in function expressions to create anonomous functions, and function expressions can be
//   used to create IIFE's which run as soon as they are defined
var functionExpression = function(){
    console.log("inside of regular function expression")
}
functionExpression();

// IIFE - execute as soon as they are defined
// IIFE's are a design pattern, also known as self-executing anonomous functions
(function(){
    console.log("this is an immediately invoked function expression")
})();   // The () invokes the function

var person = (function(){
    var name = "Margy";
})();
person;     // Immediately returns "Margy"



/*
CLOSURES
Because JS does not have access mods/support encapsulation natively, we use closures (nested functions) 
to emulate encapsulation
*/
//IIFE
var counter = (function(){
    var privateCounter = 0;

    function changeBy(val){
        privateCounter += val;
    }

    return{
        increment: function(){
            changeBy(1);
        },
        decrement: function(){
            changeBy(-1);
        },
        value: function(){
            return privateCounter;
        }
    }

})();

// counter();                   // Won't work because counter is not a fucntion
// counter.prvateCounter        // will return undefined. Don't have access to counter or vars locally
counter.value();        // will return 0
counter.increment();
counter.increment();
counter.increment();
counter.value()         // will now return 3



var makeCounter = function(){

    var privateCounter = 0;

    function changeBy(val){
        privateCounter += val;
    }

    return{
        increment: function(){
            changeBy(1);
        },
        decrement: function(){
            changeBy(-1);
        },
        value: function(){
            return privateCounter;
        }
    }

}
// makeCounter.increment();        // won't work
var counter1 = makeCOunter();
counter1.increment();              // 2 different objects in memory
var counter2 = makeCOunter();
counter2.increment();              // 2 different objects in memory

// JSON (JavaScript Object Notation): string represestation of an object
//          standard data format that's meant to be parsed into a JavaScript object
//          But you can't stringify a function
//          If you stringify an object with a function in it, it just won't save/stringify the function


