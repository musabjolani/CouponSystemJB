import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import { Coupon } from '../../Beans/Coupon' ;
import { CouponForTable } from '../../Beans/CouponForTable' ;
import { Customer } from '../../Beans/Customer' ;
import { WebapiService } from '../../services/webapi.service' ;
import {SavedataService} from '../../services/savedata.service'
import {CustomerdataService} from '../../services/customerdata.service'
import { DatePipe } from '@angular/common'
import { Router } from '@angular/router';



@Component({
  selector: 'app-purchasecoupon',
  templateUrl: './purchasecoupon.component.html',
  styleUrls: ['./purchasecoupon.component.css']
})
export class PurchasecouponComponent implements OnInit {

  
  



 private static TRUE_STATUS_COLOR="#D0ECE7";
 private static FLASE_STATUS_COLOR="#FADBD8";

 private StatusText:string;
 private statusColor:string;

private coupons:Array<CouponForTable>=[];
//private coupon:CouponForTable;
private customer:Customer;
private dataSource;

private displayedColumns = ['check','title', 'type', 'start_DATE', 'end_DATE','price'];

constructor(private webapi:WebapiService,public router: Router,
  private data:SavedataService,private customerData:CustomerdataService) { }

ngOnInit() {

this.customer=
{
id: this.customerData.customer.id,
cust_NAME: this.customerData.customer.cust_NAME,
password:this.customerData.customer.password,
coupons: []
};



// this.customer.coupons= [{

// "id": null,
// "amount": 0,
// "type": "",
// "start_DATE": null,
// "end_DATE": null,
// "message": "",
// "title": "",
// "price": 0,
// "image": ""

// }];


}


 private LoadTable()
 {
  this.getAllCoupons();
  //console.log(this.coupons);
  //this.dataSource=this.coupons;
 //this.dataSource=this.myCoupons;
 //console.log(this.dataSource);

 }
 

   private getAllCoupons()
  {
    var self = this;

    this.webapi.getAllCoupons().subscribe( function(coupons)
    {
      self.coupons=[];
      let temp:CouponForTable;
      for (var _i = 0; _i < coupons.length; _i++) {
        temp= new CouponForTable();
        temp.check=false;
        temp.id=coupons[_i].id;
        temp.title=coupons[_i].title;
        temp.amount=coupons[_i].amount;
        temp.message=coupons[_i].message;
        temp.type=coupons[_i].type;
        temp.image=coupons[_i].image;
        temp.start_DATE=coupons[_i].start_DATE;
        temp.end_DATE=coupons[_i].end_DATE;
        temp.price=coupons[_i].price;
        
        self.coupons.push(temp);
      }
       self.dataSource= self.coupons;
    });  
  }


  private purchaseCoupon()
  {
  // var temp2 :Array<Coupon>=[];
    var self = this;
    var temp:Coupon=null;
    for (var _i = 0; _i < this.coupons.length; _i++) {
      if (this.coupons[_i].check)
      {
        temp= new Coupon();
        temp.id=self.coupons[_i].id;
        temp.title=self.coupons[_i].title;
        temp.amount=self.coupons[_i].amount;
        temp.message=self.coupons[_i].message;
        temp.type=self.coupons[_i].type;
        temp.image=self.coupons[_i].image;
        temp.start_DATE=self.coupons[_i].start_DATE;
        temp.end_DATE=self.coupons[_i].end_DATE;
        temp.price=self.coupons[_i].price;
        temp.company=null;
        temp.customers=null;
        self.customer.coupons.push(temp);
        //temp2.push(temp);
      }
    }
  

//this.customer.coupons.push(temp2);

console.log("this.customer");
console.log(this.customer);
    this.webapi.purchaseCoupon(self.customer).subscribe( function(res)
    {
      self.data.message="you purchased the selected coupons successfully";
      self.data.backToPage="/purchaseCoupon";
       self.router.navigate(['savedcompleted']);
      console.log(res);
    },function(error)
    {
      self.statusColor=PurchasecouponComponent.FLASE_STATUS_COLOR; 
      self.StatusText=error._body;
      console.log(error);
     }
    );  
  }


// private getAllCouponsOfCompanyByType()
// {
// var self = this;

// this.webapi.getAllCouponsOfCompanyByType(this.MyCompanyID,this.coupon.type).subscribe( function(coupons)
// {
// self.coupons=coupons;
// });  
// }

// private getAllCouponsOfCompanyByEndDate()
// {



// let  newFormat=this.datePipe.transform(this.coupon.end_DATE, 'dd-MM-yyyy');


// var self = this;

// this.webapi.getAllCouponsOfCompanyByEndDate(this.MyCompanyID,newFormat).subscribe( function(coupons)
// {
// self.coupons=coupons;

// });  
// }

// private getAllCouponsOfCompanyByPrice()
// {
// var self = this;

// this.webapi.getAllCouponsOfCompanyByPrice(this.MyCompanyID,this.coupon.price).subscribe( function(coupons)
// {
// self.coupons=coupons;
// });  
// }


// private EnableDisableFilters(value)
// {

// this.filterSelected=value;
// this.TypeDisabled=true;
// this.EndDateDisabled=true;
// this.PriceDisabled=true;

// if(value=="FType")
// this.TypeDisabled=false
// else if (value=="FDate") 
// this.EndDateDisabled=false
// else if (value=="FPrice") 
// this.PriceDisabled=false
// }

// date:Date = new Date(2012,4,4,5,5,5,5);


myCoupons=
[
  {
    check:false,
    id: 1,
    amount:88,
    end_DATE:null,
    image:"C:\Donats",
    message:"Welcome Donats",
    price:10.8,
    start_DATE:null,
    title: "MyDonats !!!",
    type:"FOOD"
  },
    {
      check:false,
      id: 1,
      amount:88,
      end_DATE:null,
      image:"C:\Donats",
      message:"Welcome Donats",
      price:10.8,
      start_DATE:null,
      title: "MyDonats !!!",
      type:"FOOD"
      
      },
      {
        check:false,
        id: 1,
        amount:88,
        end_DATE:null,
        image:"C:\Donats",
        message:"Welcome Donats",
        price:10.8,
        start_DATE:null,
        title: "MyDonats !!!",
        type:"FOOD"
      },
      {
        check:false,
        id: 1,
        amount:88,
        end_DATE:null,
        image:"C:\Donats",
        message:"Welcome Donats",
        price:10.8,
        start_DATE:null,
        title: "MyDonats !!!",
        type:"FOOD"
      }
    
    
    
    ]
 }


