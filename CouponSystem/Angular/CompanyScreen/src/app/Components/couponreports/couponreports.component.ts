import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import { Coupon } from '../../Beans/Coupon' ;
import { WebapiService } from '../../services/webapi.service' ;
import { CoupondataService } from '../../services/coupondata.service'
import { DatePipe } from '@angular/common'
import { Router } from '@angular/router';


@Component({
  selector: 'app-couponreports',
  templateUrl: './couponreports.component.html',
  styleUrls: ['./couponreports.component.css']
})
export class CouponreportsComponent implements OnInit {

  

  constructor(private webapi:WebapiService,private datePipe: DatePipe,
              public router: Router , private couponData:CoupondataService) { }



  private coupons:Coupon[];
  private coupon:Coupon;
  private MyCompanyID:number=76;
  private dataSource;
  private TypeDisabled:boolean=true;
  private EndDateDisabled:boolean=true;
  private PriceDisabled:boolean=true;
  private displayedColumns = ['title', 'type', 'start_DATE', 'end_DATE','price'];
   private filterSelected:string="FNoFilter" ;
 

  ngOnInit() {
  
    
    this.coupon= {
      "id": null,
      "amount": 0,
      "type": "",
      "start_DATE": null,
      "end_DATE": null,
      "message": "",
      "title": "",
      "price": 0,
      "image": "",
      "company":{
       "id":this.MyCompanyID,
      "comp_NAME":"",
      "password":"",
      "email":""}
     };

      }

  

  selectedRowIndex: number = -1;
  
  
  
  
  showSelectedCoupon(id:number){
      
    this.couponData.couponID=id;
    this.router.navigate(['coupon']);
    
  }


private LoadTable()
{

 
  if(this.filterSelected=="FNoFilter")
    this.getAllCoupons();
  else if(this.filterSelected=="FType")  
    this.getAllCouponsOfCompanyByType();
  else if(this.filterSelected=="FDate")  
    this.getAllCouponsOfCompanyByEndDate();
  else if(this.filterSelected=="FPrice")
    this.getAllCouponsOfCompanyByPrice();
  
     this.dataSource=this.coupons;
  
}

  private getAllCoupons()
  {
    var self = this;
    
      this.webapi.getAllCoupons(this.MyCompanyID).subscribe( function(coupons)
      {
      self.coupons=coupons;
           
      });  
  }

  private getAllCouponsOfCompanyByType()
  {
    var self = this;
    
      this.webapi.getAllCouponsOfCompanyByType(this.MyCompanyID,this.coupon.type).subscribe( function(coupons)
      {
        self.coupons=coupons;
      });  
  }

  private getAllCouponsOfCompanyByEndDate()
  {
    
    
     
    let  newFormat=this.datePipe.transform(this.coupon.end_DATE, 'dd-MM-yyyy');
    
  
    var self = this;
    
      this.webapi.getAllCouponsOfCompanyByEndDate(this.MyCompanyID,newFormat).subscribe( function(coupons)
      {
        self.coupons=coupons;
      
      });  
  }

  private getAllCouponsOfCompanyByPrice()
  {
    var self = this;
    
      this.webapi.getAllCouponsOfCompanyByPrice(this.MyCompanyID,this.coupon.price).subscribe( function(coupons)
      {
        self.coupons=coupons;
      });  
  }
 

private EnableDisableFilters(value)
{
  
  this.filterSelected=value;
  this.TypeDisabled=true;
  this.EndDateDisabled=true;
  this.PriceDisabled=true;

  if(value=="FType")
    this.TypeDisabled=false
  else if (value=="FDate") 
    this.EndDateDisabled=false
  else if (value=="FPrice") 
    this.PriceDisabled=false
}
  
  
  
  
  
}
