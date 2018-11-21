import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  text = "sample text";
  currentTime;

  constructor() {
    setInterval( () =>{
      this.currentTime = new Date();
    }, 1000)
   }

  ngOnInit() {
  }

}
