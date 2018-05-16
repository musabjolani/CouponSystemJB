import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import { Coupon } from '../../Beans/Coupon' ;
import { Customer } from '../../Beans/Customer' ;
import { WebapiService } from '../../services/webapi.service' ;
import { CustomerdataService } from '../../services/customerdata.service'
//import { DatePipe } from '@angular/common'
import { Router } from '@angular/router';

@Component({
  selector: 'app-getpurchasecoupon',
  templateUrl: './getpurchasecoupon.component.html',
  styleUrls: ['./getpurchasecoupon.component.css']
})
export class GetpurchasecouponComponent implements OnInit {

  

  constructor(private webapi:WebapiService,
    public router: Router , private customerData:CustomerdataService) { }



private coupons:Coupon[];
private coupon:Coupon;

private dataSource;
private TypeDisabled:boolean=true;
private PriceDisabled:boolean=true;
private displayedColumns = ['title', 'type', 'start_DATE', 'end_DATE','price'];
private filterSelected:string="FNoFilter" ;
private customer:Customer;


ngOnInit() {

this.customer=
{
id: this.customerData.customer.id,
cust_NAME: this.customerData.customer.cust_NAME,
password:this.customerData.customer.password,
coupons: []
};


}











private LoadTable()
{


if(this.filterSelected=="FNoFilter")
this.getAllPurchasedCoupons();
else if(this.filterSelected=="FType")  
this.getAllPurchasedCouponsByType();
else if(this.filterSelected=="FPrice")
this.getAllPurchasedCouponsByPrice();

this.dataSource=this.coupons;

}

private getAllPurchasedCoupons()
{
var self = this;

this.webapi.getAllPurchasedCoupons(this.customer.id).subscribe( function(coupons)
{
self.coupons=coupons;
 
});  
}

private getAllPurchasedCouponsByType()
{
var self = this;

this.webapi.getAllPurchasedCouponsByType(this.customer.id,this.coupon.type).subscribe( function(coupons)
{
self.coupons=coupons;
});  
}



private getAllPurchasedCouponsByPrice()
{
var self = this;

this.webapi.getAllCouponsOfCompanyByPrice(this.customer.id,this.coupon.price).subscribe( function(coupons)
{
self.coupons=coupons;
});  
}


private EnableDisableFilters(value)
{

  this.filterSelected=value;
  this.TypeDisabled=true;
  this.PriceDisabled=true;

  if(value=="FType")
    this.TypeDisabled=false
   else if (value=="FPrice") 
    this.PriceDisabled=false
}

}
