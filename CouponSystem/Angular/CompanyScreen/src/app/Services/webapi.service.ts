import { Injectable } from '@angular/core';

import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Coupon } from '../Beans/Coupon' ;
import { Company } from '../Beans/Company' ;

@Injectable()
export class WebapiService {

  constructor(public http:Http) { }

  public getCompany(id:number)
  {
    return this.http.get('http://localhost:9090/getCompany/' + id  ).map( 
      x => x.json() );
  }


  public updateCompany(company:Company)
  {

   return this.http.put('http://localhost:9090/updateCompany', company)
  }

  public getAllCoupons(id:number)
  {
    return this.http.get('http://localhost:9090/getAllCouponsOfCompany/' + id).map( 
      x => x.json() );
  }

  public getAllCouponsOfCompanyByType(id:number,type:string)
  {
    return this.http.get('http://localhost:9090/getAllCouponsOfCompanyByType/' + id +'/' + type).map( 
      x => x.json() );
  }

  public getAllCouponsOfCompanyByEndDate(id:number,endDate:String)
  {
    
    return this.http.get('http://localhost:9090/getAllCouponsOfCompanyByEndDate/' + id + '/' + endDate).map( 
      x => x.json() );
  }

  public getAllCouponsOfCompanyByPrice(id:number,price:number)
  {
    return this.http.get('http://localhost:9090/getAllCouponsOfCompanyByPrice/' + id +'/' + price ).map( 
      x => x.json() );
  }

  
  public getCoupon(id:number)
  {
    return this.http.get('http://localhost:9090/getCoupon/' + id ).map( 
      x => x.json() );
  }

    
  public createCoupon(coupon:Coupon)
  {
    return this.http.post('http://localhost:9090/createCoupon', coupon)
  }

  public updateCoupon(coupon:Coupon)
  {
  
    return this.http.put('http://localhost:9090/updateCoupon', coupon)
  }

  public removeCoupon(coupon:Coupon)
  {
    return this.http.delete('http://localhost:9090/removeCoupon', { body: coupon })
  }
  

}
