import { Component } from '@angular/core';
import { CoupondataService } from './services/coupondata.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';



  
  constructor(public coupondata:CoupondataService) 
    {
      this.coupondata.companyID= +this.getParameterByName('companyID'); 
      
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
