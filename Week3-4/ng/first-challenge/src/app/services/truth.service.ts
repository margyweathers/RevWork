import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface StarPerson{
  name : string;
  height: number;
}

@Injectable({
  providedIn: 'root'
})
export class TruthService {

  public truthInfo = "TRUTH!";

  constructor(private http : HttpClient) { }

  updateTruthInfo(newTruth : string): void{
    this.truthInfo = newTruth;
  }

  getStarWarsPerson(id : number){
    console.log(this.http.get<StarPerson>(`https://swapi.co/api/people/${id}/`));
    return this.http.get<StarPerson>(`https://swapi.co/api/people/${id}/`);    // get's return type is Observable
  }

}
