import { Company } from '../Beans/Company' ;


export class Coupon {
    constructor(private _id?:number, private _amount?:number,private _type?:string,
        private _start_DATE?:Date,private _end_DATE?:Date , private _message?:string ,
        private _title?:string, private _price?:number , private _image?:string, 
        private _company?:Company )
    {

    }
    get id() : number {
      return this._id;
    }
    set id(newID : number)
    {
      this._id = newID;
    }

    get amount() : number {
        return this._amount;
      }
      set amount(newID : number)
      {
        this._amount = newID;
      }

      get type() : string {
        return this._type;
      }
      set type(newName : string)
      {
        this._type = newName;
      }

      get start_DATE() : Date {
        return this._start_DATE;
      }
      set start_DATE(newName : Date)
      {
        this._start_DATE = newName;
      }

      get end_DATE() : Date {
        return this._end_DATE;
      }
      set end_DATE(newName : Date)
      {
        this._end_DATE = newName;
      }

      get message() : string {
        return this._message;
      }
      set message(newName : string)
      {
        this._message = newName;
      }

      get title() : string {
        return this._title;
      }
      set title(newName : string)
      {
        this._title = newName;
      }

      get price() : number {
        return this._price;
      }
      set price(newID : number)
      {
        this._price = newID;
      }

      get image() : string {
        return this._image;
      }
      set image(newName : string)
      {
        this._image = newName;
 
     }

      get company() :Company
     {
      return this._company;
     }
     set company(newName :Company) 
     {
      this._company=newName;
     }
  }
 
 /*
 
     "id": 11,
 "amount": 103,
 "type": "RESTAURANT",
 "start_DATE": "2017-02-05",
 "end_DATE": "2018-11-02",
 "message": "good luck Mac",
 "title": "Mac",
 "price": 9.2,
 "image": "C:\\Dir Goood-Mac",

 */