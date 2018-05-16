import { Component, OnInit } from '@angular/core';
import { Customer } from '../../Beans/Customer' ;
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';
import { WebapiService } from '../../services/webapi.service' ;
import { SavedataService } from '../../services/savedata.service'
import { AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import {MatSelectModule} from '@angular/material/select';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private webapi:WebapiService,public router: Router,private data:SavedataService) {

   }


  private static TRUE_STATUS_COLOR="#D0ECE7";
  private static FLASE_STATUS_COLOR="#FADBD8";

  private customer:Customer;
  private customers:Customer[];
  private showPassword  :boolean;
  private StatusText:string;
  private statusColor:string;

  ngOnInit() 
  {
  this.getAllCustomers(); 
  this.customer={id:null,cust_NAME:"",password:""};
  this.showPassword=false;
  this.statusColor=CustomerComponent.TRUE_STATUS_COLOR;

 
}


  
log(x)
{
  console.log(x);
  
}




private getAllCustomers()
{
  var self = this;
  
   this.webapi.getAllCustomers().subscribe( function(customers)
   {
    
     self.customers=customers;
  
   });  
}



public clearControls()
{
  this.customer.id=null;
  this.customer.cust_NAME="";
  this.customer.password="";
  
}


private save(isValid:boolean)
{
  if (this.customer.id== null)
    this.createCustomer(isValid);
  else
    this.updateCustomer(isValid)  ;
}

private createCustomer(isValid:boolean)
{
  var self = this;
  if(isValid)
  {
    this.webapi.createCustomer(this.customer).subscribe( function(res)
    {
      self.data.message="Customer Saved Successfully";
      self.data.backToPage="/customer";
      self.router.navigate(['savedcompleted']);
      console.log(res);
    },function(error)
    {
      self.statusColor=CustomerComponent.FLASE_STATUS_COLOR; 
      self.StatusText=error._body;
      console.log(error);
    }
    );  
  }
 else
 {
  this.statusColor=CustomerComponent.FLASE_STATUS_COLOR; 
  this.StatusText="Please check the errors "
 }


}


private updateCustomer(isValid:boolean)
{
  var self = this;
  if(isValid)
  {
    this.webapi.updateCustomer(this.customer).subscribe( function(res)
    {
      self.statusColor=CustomerComponent.TRUE_STATUS_COLOR; 
      self.StatusText="Customer Updated Successfully"  
      console.log(res);
    },
    function(error)
    {
      self.statusColor=CustomerComponent.FLASE_STATUS_COLOR; 
      self.StatusText=error._body;
      console.log(error);
    }
    );  
  }
  else
  {
    this.statusColor=CustomerComponent.FLASE_STATUS_COLOR; 
    this.StatusText="Please check the errors "
  }  
}

private removeCustomer(isValid:boolean)
{
  var self = this;
  if (this.customer.id != null)
  {
    if (confirm('Are you sure you want to delete this customer?')) 
    {
      this.webapi.removeCustomer(this.customer).subscribe( function(res)
      {
        self.data.message="Customer Deleted Successfully";
        self.data.backToPage="/customer";
        self.router.navigate(['savedcompleted']);
        console.log(res);
      },function(error)
      {
        self.statusColor=CustomerComponent.FLASE_STATUS_COLOR; 
        self.StatusText=error._body;
        console.log(error);
      }
      );    
    } 
    else  
    {
     // Do nothing!
    }
  }
}





public showCustomer(id:number)
{
  var self = this;
  
  if(id==null)
    return;
  this.webapi.getCustomer(id).subscribe( function(customer)
  {
    self.customer=customer;
  });
}



private changePasswordContrilType() :string
{
  if (this.showPassword)
    return "text";
  else
    return "password"
}


}
