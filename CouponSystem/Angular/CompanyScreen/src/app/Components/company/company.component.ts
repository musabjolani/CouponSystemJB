import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';
import { WebapiService } from '../../services/webapi.service' ;
import { SavedataService } from '../../services/savedata.service'
import { CoupondataService } from '../../services/coupondata.service'
import { Company } from '../../Beans/Company' ;
import { AbstractControl } from '@angular/forms';
import { Router,ActivatedRoute } from '@angular/router';
import {MatSelectModule} from '@angular/material/select';


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  
constructor(private webapi:WebapiService,public router: Router,private data:SavedataService,
            private coupondataService: CoupondataService)
            {   
            }
 
 private static TRUE_STATUS_COLOR="#D0ECE7";
 private static FLASE_STATUS_COLOR="#FADBD8";
 private company:Company;
 private showPassword  :boolean;
 private StatusText:string;
 private statusColor:string;
 
 
 
 ngOnInit() {
  
  
   this.showPassword=false;
   this.statusColor=CompanyComponent.TRUE_STATUS_COLOR;
   this.company={id:this.coupondataService.companyID,comp_NAME:"",password:"",email:""}
   this.showCompany()
  
 }
  
 public showCompany()
 {
   var self = this;
   if(this.company.id==null)
     return;
   this.webapi.getCompany(this.company.id).subscribe( function(company)
   {
     self.company=company;
   });
 }
 
 
 public clearControls()
 {
   this.company.id=null;
   this.company.comp_NAME="";
   this.company.password="";
   this.company.email="";
 }
 
  private save(isValid:boolean)
 {
  this.updateCompany(isValid)  ;
 }  
 
 
 
 
 private updateCompany(isValid:boolean)
 {
   var self = this;
   if(isValid)
   {
     this.webapi.updateCompany(this.company).subscribe( function(res)
     {
       self.statusColor=CompanyComponent.TRUE_STATUS_COLOR; 
       self.StatusText="Company Updated Successfully"  
      
     },
     function(error)
     {
       self.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
       self.StatusText=error._body;
      
     }
     );  
   }
   else
   {
     this.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
     this.StatusText="Please check the errors "
   }  
 }
 
 
 
 private changePasswordContrilType() :string
 {
   if (this.showPassword)
     return "text";
   else
     return "password"
 }
 
 
}
