import { Injectable } from '@angular/core';

import { Http,Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Customer } from '../Beans/Customer' ;

@Injectable()
export class WebapiService {

  constructor(public http:Http) { }
  

  public getAllCoupons()
  {
    return this.http.get('http://localhost:9090/getAllCoupons/').map( 
      x => x.json() );
  }


public purchaseCoupon(customer:Customer)
{
  
  return this.http.post('http://localhost:9090/purchaseCoupon', customer)
}

public getAllPurchasedCoupons(id:number)
{
  return this.http.get('http://localhost:9090/getAllPurchasedCoupons/' + id).map( 
    x => x.json() );
}

public getAllPurchasedCouponsByType(id:number,type:string)
{
  return this.http.get('http://localhost:9090/getAllPurchasedCouponsByType/' + id +'/' + type).map( 
    x => x.json() );
}


public getAllCouponsOfCompanyByPrice(id:number,price:number)
{
  return this.http.get('http://localhost:9090/getAllPurchasedCouponsByPrice/' + id +'/' + price ).map( 
    x => x.json() );
}

}
