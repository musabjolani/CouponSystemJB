import { Component, OnInit,ViewChild,ElementRef } from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';
import { WebapiService } from '../../services/webapi.service' ;
import { SavedataService } from '../../services/savedata.service' ;
import { CoupondataService } from '../../services/coupondata.service'
import { Coupon } from '../../Beans/Coupon' ;
import { AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSelectModule } from '@angular/material/select';





@Component({
  selector: 'app-coupon',
  templateUrl: './coupon.component.html',
  styleUrls: ['./coupon.component.css']
})
export class CouponComponent implements OnInit {

 
 
  @ViewChild('Input') fileInput: ElementRef;

  constructor(private webapi:WebapiService,public router: Router,
              private couponData:CoupondataService,private data:SavedataService) 
              {     
                
            }  
   
   
   private static TRUE_STATUS_COLOR="#D0ECE7";
   private static FLASE_STATUS_COLOR="#FADBD8";
   
   private coupons:Coupon[];
   private coupon:Coupon;
   private StatusText:string;
   private statusColor:string;
     

   
   ngOnInit() {
    
   
    this.showCoupon(this.couponData.couponID);
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
      "id":this.couponData.companyID,
     "comp_NAME":"",
     "password":"",
     "email":""}
    };
   
     
     this.statusColor=CouponComponent.TRUE_STATUS_COLOR;
   
     
  }
   

  private showPreviewImage(event: any) {
      if (event.target.files && event.target.files[0]) {
          var reader = new FileReader();
          reader.onload = (event: any) => {
            this.coupon.image = event.target.result;
          }
          reader.readAsDataURL(event.target.files[0]);
      }
    
  }


     
  private clearFile() {
    this.fileInput.nativeElement.value = '';
    this.coupon.image='';
  }

   l
   
   public showCoupon(id:number)
   {
    
   
      var self = this;
      if(id==null)
        return;
      
    this.webapi.getCoupon(id).subscribe( function(coupon)
      {
       //self.coupon=coupon;
      
       self.coupon.id=coupon.id;
       self.coupon.title=coupon.title;
       self.coupon.amount=coupon.amount;
       self.coupon.type=coupon.type;
       self.coupon.price=coupon.price;
       self.coupon.start_DATE=coupon.start_DATE;
       self.coupon.end_DATE=coupon.end_DATE;
       self.coupon.message=coupon.message;
       self.coupon.image=coupon.image;
       self.coupon.company.id=self.coupon.company.id;

      });

      this.StatusText="";
      console.log("this.coupon");
      console.log(this.coupon);
   }
   
   
   private getAllCoupons(id:number)
   {
     var self = this;
     
       this.webapi.getAllCoupons(id).subscribe( function(coupons)
       {
       
        self.coupons=coupons;
   
      });  
   }
   
   
   
   public clearControls()
   {
    this.coupon.id=null;
    this.coupon.amount=0;
    this.coupon.type= "";
    this.coupon.start_DATE=null;
    this.coupon.end_DATE= null;
    this.coupon.message= "";
    this.coupon.title= "";
    this.coupon.price= 0;
    this.coupon.image= "";
    this.coupon.company.id=this.coupon.company.id;
    this.clearFile();

    this.StatusText="";
       
   }
   
   
   private save(isValid:boolean)
   {
      
     if (this.coupon.id== null)
       this.createCoupon(isValid);
     else
       this.updateCompany(isValid)  ;
   }
   
   private createCoupon(isValid:boolean)
   {

     var self = this;
     if(isValid)
     {

      console.log(this.coupon);
        this.webapi.createCoupon(this.coupon).subscribe( function(res)
        {
         
          // self.data.message="Coupon Saved Successfully";
          // self.data.backToPage="/coupon";
          // self.router.navigate(['savedcompleted']);
          // console.log(res);
          self.statusColor=CouponComponent.TRUE_STATUS_COLOR; 
          self.StatusText="Coupon Saved Successfully"  
        },function(error)
        {
          self.statusColor=CouponComponent.FLASE_STATUS_COLOR; 
          self.StatusText=error._body;
          console.log(error);
        }
       );  
     }
    else
    {
     this.statusColor=CouponComponent.FLASE_STATUS_COLOR; 
     this.StatusText="Please check the errors "
    }
   
   
   }
   
   
   private updateCompany(isValid:boolean)
   {
     var self = this;
     if(isValid)
     {
       this.webapi.updateCoupon(this.coupon).subscribe( function(res)
       {
         self.statusColor=CouponComponent.TRUE_STATUS_COLOR; 
         self.StatusText="Coupon Updated Successfully"  

         console.log(res);
       },
       function(error)
       {
         self.statusColor=CouponComponent.FLASE_STATUS_COLOR; 
         self.StatusText=error._body;
         console.log(self.coupon);
         console.log(error);
       }
       );  
     }
     else
     {
       this.statusColor=CouponComponent.FLASE_STATUS_COLOR; 
       this.StatusText="Please check the errors "
     }  
   }
   
   private removeCoupon(isValid:boolean)
   {
     var self = this;
     if (this.coupon.id != null)
     {
       if (confirm('Are you sure you want to delete this coupon?')) 
       {
         this.webapi.removeCoupon(this.coupon).subscribe( function(res)
         {
           self.data.message="Coupon Deleted Successfully";
           self.data.backToPage="/coupon";
           self.router.navigate(['savedcompleted']);
          //  console.log(res);
         // self.statusColor=CouponComponent.TRUE_STATUS_COLOR; 
         // self.StatusText="Coupon Removed Successfully"  
         },function(error)
         {
           self.statusColor=CouponComponent.FLASE_STATUS_COLOR; 
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
   
   
   
  
}
