import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

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
