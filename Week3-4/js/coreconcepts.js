/**
 * @author Margy
 * @name Intro to JS
 * @since 11/6/18
 */

 /*
JavaScript is a scripting language used to client-side operations; although there are frameworks that allow you to write server-side JS
- loosely typed - do not declare variable types. simply declare variables with the declarative keywords var, let, const. The types
    of the variables are then dynamically allocated. (see with typeOf() operator)

- var scopes:
        - global: accessible throughout the entirety of the script and through the browser. Globally scoped variables are anything
            declared outside of a block or function OR variables that are never declared at al. (You don't have to declare variables.
            Will just become global scope)
        - function: declared in function/passed in as a parameter. accessible only throughout function
        - block: new to ES6. Can only obtain with variables declared with let or const keywords
- some familar terms: if..else, return, switch, try...catch, while, do...while, for, break, continue
- load and go delivery

 */



var a = 5;
var b = 'single quote string';
var c = "double quote string";
var obj = {
    name : "Margy",
    age : 24,
};

obj.name;
obj["name"];
obj["about me"] = "can create and access properties of our objects with spaces in their names. Not that you ever should..."
obj.height = 5.2;

console.log("Logging to the console")
var x = `Hi my name is ${obj.name}`;

/*
For... In Loop: Iternate thruogh properties of an object
*/
for (var prop in obj){
    // console.log prints to your client console
    // `` and ${} indicate string interpolation/template literals, which allow for the easy displaying of data and evaluation of expressions
    console.log(` ${prop} = ${obj[prop]}`)
}
y = `The sum of 5 and 10 = ${5+10}`


/*
DATA TYPES OF JS and TYPE COERCION
- As a loosely typed language that is interpreted and not compiled, JS has to be able to accomodate comparisons between and manipulation
    on otherwise incompatible data types (such as string and number, or boolean and obj)
- Type coercion is the process that JS takes to bring data from one type to another to compare actual value as opposed to the datatype 
    that the new value would be held in
    == allows type coersion
    === restricts type coersion 

*/

7 == 7; // TRUE 
7 == '7'; //TRUE - forces type conversion (type coersion)
7 === 7; //TRUE
7 === '7' // FALSE

7 + 7 + 7; // 21
7 + 7 + '7'; //147
'7' + 7 + 7; // 777

var exp = (7);
if(exp){
    console.log("this is true");
}
else{
    console.log("this is false");
}

/*TRUTHY AND FALSY
- everything in JS evaluates to a boolean either true or false
- though we only refer to TRUE and FALSE and true and false, respectively, 
other values have been dubbed "truthy" and "falsy" 
Falsy - ''(empty string), undefined, 0, null, false, NaN
Truthy - everything else(including 'false') 
*/
function truthyOrFalsy(exp){
    if(exp) return "this is true";
    else return "this is false";
}


/* STRINGS 
    - 0 or more 16-bit characters
    - " or ', but not for the same string 
    - string.length 
    - other important methods - charAt, concat, indexOf, replace, split, slice, substring 
    - search w regex
    - immutable
*/


//MORE ON FUNCTIONAL AND ARROW NOTATIONS
function test(){
    return 0;
}

function regularWithParams(a, b){
    return a + b;
}

function doesNotHaveToReturnThings(a, b){
    console.log(a);
}

//func(). anonymous 
var func = function(x){
    console.log("doing cool things with js");
    return x;
}

var add = function(a, b){ return a + b};

var addArrow = (a, b)=> {return a + b;}




// scopes, hoisting, operators, loops, statements, 




