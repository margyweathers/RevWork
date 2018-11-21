import { Component, OnInit } from '@angular/core';
import { TruthService } from '../../services/truth.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  tempEdit = "";

  constructor(private truthService : TruthService) { }

  ngOnInit() {
    this.tempEdit = this.truthService.truthInfo;
  }

  update(){
    console.log('clicked edit');
    if (this.truthService.truthInfo != this.tempEdit){
      this.truthService.updateTruthInfo(this.tempEdit);
    }
  }

  reset(){
    this.tempEdit = this.truthService.truthInfo;
  }

  // this.http.get<Config>(this.configUrl)

}
