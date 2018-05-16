import { Component, OnInit } from '@angular/core';
import {SavedataService} from '../../services/savedata.service'
@Component({
  selector: 'app-savedcompleted',
  templateUrl: './savedcompleted.component.html',
  styleUrls: ['./savedcompleted.component.css']
})
export class SavedcompletedComponent implements OnInit {

  constructor(private data:SavedataService) { }

  ngOnInit() {
  }

}
