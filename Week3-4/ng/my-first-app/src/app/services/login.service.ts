import { Injectable } from '@angular/core';
import { User } from '../models/user.model'

@Injectable({
  // This says 2 things: manage this service in the root module. This service is avaiable to antything THAT WANTS IT 
  //  (aka a component that has a dependency, aka has it in their constructor)
  providedIn: 'root'
})
export class LoginService {

  userList: User[] = [
    new User('name', 'pwd'), new User('Margy', 'Pass'), new User('learning', 'angular')
  ];

  constructor() { }

  public validateUser(username: string, password: string): User {
    for (const u of this.userList) {
      if (u.username == username) {
        if (u.password == password) {
          return u;
        }
      }
    }
    return null;
  }


  
}
