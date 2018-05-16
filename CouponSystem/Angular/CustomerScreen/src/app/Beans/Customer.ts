import { Coupon } from '../Beans/Coupon' ;

export class Customer {
    constructor(private _id?:number, private _cust_NAME?:string,
                 private _password?:string, private _coupons?:Coupon[])
    {
    }
    get id() : number {
      return this._id;
    }
    set id(newID : number)
    {
      this._id = newID;
    }
    get cust_NAME() : string {
        return this._cust_NAME;
      }
      set cust_NAME(newName : string)
      {
        this._cust_NAME = newName;
      }
      get password() : string {
        return this._password;
      }
      set password(newName : string)
      {
        this._password = newName;
      }
   
      get coupons() : Coupon[] {
        return this._coupons;
      }
      set coupons(newName : Coupon[])
      {
        this._coupons = newName;
      }
   
  }
  
