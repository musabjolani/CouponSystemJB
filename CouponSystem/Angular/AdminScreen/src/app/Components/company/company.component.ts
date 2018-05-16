import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs/Observable';
import {startWith} from 'rxjs/operators/startWith';
import {map} from 'rxjs/operators/map';
import { WebapiService } from '../../services/webapi.service' ;
import { SavedataService } from '../../services/savedata.service'
import { Company } from '../../Beans/Company' ;
import { AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})


export class CompanyComponent implements OnInit {

constructor(private webapi:WebapiService,public router: Router,private data:SavedataService) {
 
  
  
 }


 

private static TRUE_STATUS_COLOR="#D0ECE7";
private static FLASE_STATUS_COLOR="#FADBD8";

private companies:Company[];
private company:Company;
private showPassword  :boolean;
private StatusText:string;
private statusColor:string;



ngOnInit() {
  this.getAllCompanies(); 
  this.company={id:null,comp_NAME:"",password:"",email:""}
  this.showPassword=false;
  this.statusColor=CompanyComponent.TRUE_STATUS_COLOR;

 
}


  
log(x)
{
  console.log(x);
  
}


public showCompany(id:number)
{
  var self = this;
  if(id==null)
    return;
 
  this.webapi.getCompany(id).subscribe( function(company)
  {
    self.company=company;
  });
}


private getAllCompanies()
{
  var self = this;
  
   this.webapi.getAllCompanies().subscribe( function(companies)
   {
    
     self.companies=companies;

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
  if (this.company.id== null)
    this.createCompany(isValid);
  else
    this.updateCompany(isValid)  ;
}

private createCompany(isValid:boolean)
{
  var self = this;
  if(isValid)
  {
    this.webapi.createCompany(this.company).subscribe( function(res)
    {
      self.data.message="Company Saved Successfully";
      self.data.backToPage="/company";
      self.router.navigate(['savedcompleted']);
      console.log(res);
    },function(error)
    {
      self.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
      self.StatusText=error._body;
      console.log(error);
    }
    );  
  }
 else
 {
  this.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
  this.StatusText="Please check the errors "
 }


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
      console.log(res);
    },
    function(error)
    {
      self.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
      self.StatusText=error._body;
      console.log(error);
    }
    );  
  }
  else
  {
    this.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
    this.StatusText="Please check the errors "
  }  
}

private removeCompany(isValid:boolean)
{
  var self = this;
  if (this.company.id != null)
  {
    if (confirm('Are you sure you want to delete this company?')) 
    {
      this.webapi.removeCompany(this.company).subscribe( function(res)
      {
        self.data.message="Company Deleted Successfully";
        self.data.backToPage="/company";
        self.router.navigate(['savedcompleted']);
        console.log(res);
      },function(error)
      {
        self.statusColor=CompanyComponent.FLASE_STATUS_COLOR; 
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


private changePasswordContrilType() :string
{
  if (this.showPassword)
    return "text";
  else
    return "password"
}


}
