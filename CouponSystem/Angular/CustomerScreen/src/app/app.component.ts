import { Component } from '@angular/core';
import { CustomerdataService } from './services/customerdata.service'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';


  constructor(public customerdata:CustomerdataService) 
  {
    this.customerdata.customer.id= +this.getParameterByName('customerID'); 
    this.customerdata.customer.cust_NAME= this.getParameterByName('customerName'); 
    this.customerdata.customer.password= this.getParameterByName('password'); 
  }  


  getParameterByName(name) :string {
    let url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}




}
