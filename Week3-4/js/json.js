/*
JSON - JavaScript Object Notation is a minimal, readble format for 
structuring data. It is used primarily to transmit data between 
server and client, as an alternative to XML
"lightweight data interchange format modeled after JS objects"
it is NOT a JS object
*/
let person = {
    name: 'GB', 
    workplace: 'Revature',
    skills: ['coding', 'talking to people', 'eating']
}

let personStr = JSON.stringify(person);

//"{"name":"GB","workplace":"Revature","skills":["coding","talking to people","eating"]}";

///////////

let respString = ""; //filled with some text
let resp = JSON.parse(respString);

resp.field1;
resp.field2;