import { Component, OnInit } from '@angular/core';
import { TruthService } from '../../services/truth.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  people = [];
  errorMsg = '';

  constructor(private truthService : TruthService) { }

  ngOnInit() {
    this.getPerson();
    console.log(this.people);
  }

  
  getPerson(){
    console.log(this.truthService.getStarWarsPerson(1));
    this.truthService.getStarWarsPerson(1).subscribe(
      (StarPerson) => this.people.push(StarPerson),
      (error) => this.errorMsg = 'There was a network error'
    );
  }

}
