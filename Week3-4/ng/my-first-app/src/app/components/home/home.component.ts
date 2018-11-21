import { Component, OnInit } from '@angular/core';
// Must import Router
import { Router } from '@angular/router';

/*
@Component indicates that the following 
*/
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  // must use Dependency Injection for router
  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToLogin(){
    this.router.navigate(['login']);  // Notes on GIT?
  }

}
