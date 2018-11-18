import { Component, OnInit } from '@angular/core';

// @Component 
@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {    // Always export a component class so you can import it elsewhere

  hero = 'Windstorm';

  constructor() { }

  ngOnInit() {
  }

}
