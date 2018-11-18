import { Component, OnInit } from '@angular/core';

/*
@Component indicates that the following 
*/
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  text = 'hello world';
  buttonClass = 'btn btn-secondary';
  count = 0;
  color = 'blue';

  constructor() { }

  ngOnInit() {
  }

  changeColor() {
    const classes = ['primary', 'secondary', 'success',
  'danger', 'warning', 'info', 'light', 'dark'];
  this.buttonClass = `btn btn-${classes[this.count % 8]}`;
  }
  clickButton() {
    this.count++;
  }

}
