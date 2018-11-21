import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  showIf = true;
  numArray = [1,2,5,3,7];

  constructor() { }

  ngOnInit() {
  }

  toggleIf(){
    this.showIf = !this.showIf;
  }

}
