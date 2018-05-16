import { Component, OnInit } from '@angular/core';
import { SavedataService } from '../../services/savedata.service'

@Component({
  selector: 'app-saved-completed',
  templateUrl: './saved-completed.component.html',
  styleUrls: ['./saved-completed.component.css']
})
export class SavedCompletedComponent implements OnInit {

  constructor(private data:SavedataService) { }

  ngOnInit() {
  }

}
