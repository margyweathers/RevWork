import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  username : string;
  password : string;
  output : string;
  currentUser: User;

  constructor(private loginService: LoginService) { 
    console.log('Using dependency injection in login component for login service');
  }

  // automatically called
  ngOnInit() {
  }

  clickLogin(){
  //  this.output = `Your username is: ${this.username} and your password is: ${this.password}`

    this.currentUser = this.loginService.validateUser(this.username, this.password);
    if (this.currentUser == null){
      this.output = 'invalid credentials'
    }
    else{
      this.output = `Welcome, ${this.username}.`;
    }

    }

}
