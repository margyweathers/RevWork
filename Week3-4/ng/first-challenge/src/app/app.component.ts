import { Component, OnInit } from '@angular/core';
import { TruthService } from './services/truth.service';  // Need to import

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'first-challenge';

  constructor(private truthService: TruthService){} // Dependency injection

  ngOnInit(){}
}
