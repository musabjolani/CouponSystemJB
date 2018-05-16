import { Component, OnInit } from '@angular/core';
import {CustomerdataService} from '../../services/customerdata.service'
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private customerData:CustomerdataService) { }
  private customerName: String;
  ngOnInit() {

    this.customerName=this.customerData.customer.cust_NAME;
  }

}
