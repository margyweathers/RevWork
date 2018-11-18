export class User{
    // model classes are used somewhat like pojos in Java. Used to model objects
    username: string;
    password: string;

    constructor(name: string, pw:string){
        this.username = name;
        this.password = pw;
    }

}